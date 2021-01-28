package com.shoppingmall.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mchange.v1.lang.holders.VolatileBooleanHolder;
import com.shoppingmall.service.BoardService;
import com.shoppingmall.service.CategoryService;
import com.shoppingmall.service.NoticeService;
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.service.ReplyService;
import com.shoppingmall.service.VisitcountService;
import com.shoppingmall.vo.AccessorVO;
import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.CategoryVO;
import com.shoppingmall.vo.MembersVO;
import com.shoppingmall.vo.Pagination;
import com.shoppingmall.vo.ReplyVO;


@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	@Inject
	private CategoryService cate;
	@Inject
	private ReplyService reply;
	@Inject
	private NoticeService noticeService;
	@Inject
	VisitcountService visitcountService;
	@Inject
	private RegisterService registerService;
	
	
	//게시판 목록 조회
	@RequestMapping(value = "/board/{cateid}")
	public String MoveBoard(@RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range, 
			@PathVariable Integer cateid, String keyword, Locale locale, Model model) throws Exception {
		List<String> list = new ArrayList<String>();
		
		CategoryVO getOneCategoryName = cate.getOneCategoryName(cateid);
		model.addAttribute("catename", getOneCategoryName);
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		int listCnt = service.getBoardListCnt(cateid, keyword);

		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		
		int startList = pagination.getStartList();
		int listSize = pagination.getListSize();
		
		List<BoardVO> GetBoardList = service.GetBoardList(cateid, page, keyword, startList, listSize);
		model.addAttribute("pagination", pagination);
		model.addAttribute("GetBoardList", GetBoardList);
		
		for(int i = 0; i < GetBoardList.size(); i++) {
			System.out.println(GetBoardList.get(i).toString());
		}
		
		
		//접속자 수, 접속자 아이디 가져온다.
		int num = AccessorVO.getHttpSession().size();
		for(int i = 0; i < AccessorVO.getHttpSession().size(); i++) {
			String memberid = (String) AccessorVO.getHttpSession().get(i).getAttribute("memberid");
			MembersVO vo = registerService.ListNameAccessor(memberid);
			list.add(vo.getNickname());
		}
		System.out.println("list 크기 == " + list.size());
		
		System.out.println("현재 접속자 수 :: " + AccessorVO.getHttpSession().size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		model.addAttribute("list", list); //접속자 아이디
		model.addAttribute("size", AccessorVO.getHttpSession().size()); //접속자 수
		model.addAttribute("TotalCount", visitcountService.getTotalCount().getTotalcount());//총 방문자 수
		model.addAttribute("TodayCount", visitcountService.getTodayCount());//오늘 방문자 수
		
		return "/board";
	}
	
	//게시글 조회
	@RequestMapping(value = "/board/{cateid}/{b_num}")
	public String ViewBoard(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer cateid, @PathVariable Integer b_num, Integer notice_no, Locale locale, Model model) throws Exception {
		List<String> list = new ArrayList<String>();
		
		//조회수 중복 방지
		Cookie cookies[] = request.getCookies();
		
		HttpSession session = request.getSession();
		
		String SessionID = (String)session.getAttribute("memberid");
		System.out.println("현재 로그인 한 사람의 아이디 ::: " + SessionID);
		
		//비교 쿠키
		Cookie TargetCookie = null;
		
		//쿠키가 있다면
		if(cookies != null && cookies.length > 0) {
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals(SessionID + "cookie" + b_num)) {
					System.out.println("쿠키 생성 뒤 입장.....");
					TargetCookie = cookies[i];
				}
			}
		}
		//만약 TargetCookie가 null일 경우 쿠키 생성 및 조회수 증가 로직
		if(TargetCookie == null) {
			System.out.println("쿠키 x");
			
			//쿠기 생성
			Cookie newCookie = new Cookie(SessionID + "cookie" + b_num, "IILLiiLLllIIl" +  + b_num + "|" + SessionID);
			newCookie.setMaxAge(60*60*24);
			
			//쿠키 추가
			response.addCookie(newCookie);
			
			try {
				//쿠키 추가 후 조회수 증가
				service.UpdateBoardHit(b_num);
				System.out.println("조회수 잘 들어감......");
			} catch(Exception e) {
				System.out.println("조회수 증가 하다 오류....");
			}
		}
		else {
			System.out.println("cookie 있다 ~~~~");
			System.out.println("Cookie :::: " + TargetCookie.getValue());
		}
		
		
		
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		BoardVO ViewBoard = service.ViewBoard(b_num);
		model.addAttribute("ViewBoard", ViewBoard);
		
		//접속자 수, 접속자 아이디 가져온다.
		int num = AccessorVO.getHttpSession().size();
		for(int i = 0; i < AccessorVO.getHttpSession().size(); i++) {
			String memberid = (String) AccessorVO.getHttpSession().get(i).getAttribute("memberid");
			MembersVO vo = registerService.ListNameAccessor(memberid);
			list.add(vo.getNickname());
		}
		System.out.println("list 크기 == " + list.size());
		
		System.out.println("현재 접속자 수 :: " + AccessorVO.getHttpSession().size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		model.addAttribute("list", list); //접속자 아이디
		model.addAttribute("size", AccessorVO.getHttpSession().size()); //접속자 수
		model.addAttribute("TotalCount", visitcountService.getTotalCount().getTotalcount());//총 방문자 수
		model.addAttribute("TodayCount", visitcountService.getTodayCount());//오늘 방문자 수

		return "/viewboard";
	}
	
	//게시글 작성페이지로 이동
	@RequestMapping(value = "/board/{cateid}/writeboard")
	public String WriteBoard(@PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		
		return "/writeboard";
	}
	
	//게시글 작성 로직
	@RequestMapping(value = "/board/{cateid}/wroteboard")
	public String WroteBoard(@PathVariable Integer cateid, String b_title, BoardVO vo, Locale locale, Model model, HttpServletResponse response) throws Exception {
		
		//제목에 공백만 있으면 리턴
		if(b_title == null) {
			PrintWriter pw = response.getWriter();
			pw.println("<script>alert('제목을 입력해 주세요.');</script>");
			pw.flush();
			return "redirect:/board/{cateid}";
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa" + vo.getBoardflag());
		service.WroteBoard(vo);
		
		return "redirect:/board/{cateid}";
	}
	
	//게시글 수정페이지로 이동
	@RequestMapping(value = "/board/{cateid}/{b_num}/updateboard")
	public String UpdateBoard(@PathVariable Integer b_num, @PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		//글내용 불러오기
		BoardVO UpdateGetBoard = service.UpdateGetBoard(b_num);
		
		model.addAttribute("UpdateGetBoard", UpdateGetBoard);
		
		return "/updateboard";
	}
	
	//게시글 수정 로직
	@RequestMapping(value = "/board/{cateid}/{b_num}/updatedboard")
	public String UpdatedBoard(@PathVariable Integer b_num, @PathVariable Integer cateid, BoardVO vo, Locale locale, Model model) throws Exception {
		
		service.UpdateBoard(vo);
		
		return "redirect:/board/{cateid}";
	}
	
	//게시글 삭제
	@RequestMapping(value = "/board/{cateid}/{b_num}/deleteboard")
	public String DeleteBoard(@PathVariable Integer b_num, @PathVariable Integer cateid, Locale locale, Model model) throws Exception {
		
		service.DeleteBoard(b_num);
		
		return "redirect:/board/{cateid}";
	}
	
	//writerboard 글쓴이 클릭 했을때 글쓴이가 쓴 게시글만 가져옴
	@RequestMapping(value = "/writerboard")
	public String writerboard(String nickname, Model model) throws Exception {
		
		List<BoardVO> GetBoardList = service.getWriterBoard(nickname);
		for(int i = 0; i < GetBoardList.size(); i++) {
			System.out.println(GetBoardList.get(i).toString());
		}
		
		model.addAttribute("GetBoardList", GetBoardList);
		
		return "/board";
	}
}
