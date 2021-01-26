package com.shoppingmall.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shoppingmall.service.BoardService;
import com.shoppingmall.service.CategoryService;
import com.shoppingmall.service.NoticeService;
import com.shoppingmall.service.ReplyService;
import com.shoppingmall.vo.BoardVO;
import com.shoppingmall.vo.CategoryVO;
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
	
	//게시판 목록 조회
	@RequestMapping(value = "/board/{cateid}")
	public String MoveBoard(@RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range, 
			@PathVariable Integer cateid, String keyword, Locale locale, Model model) throws Exception {
		
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
		return "/board";
	}
	
	//게시글 조회
	@RequestMapping(value = "/board/{cateid}/{b_num}")
	public String ViewBoard(@PathVariable Integer cateid, @PathVariable Integer b_num, Integer notice_no, Locale locale, Model model) throws Exception {
		
		//noticeService.ReadCheck_Change(notice_no);
		System.out.println("notice === " + notice_no);
		service.UpdateBoardHit(b_num);
		
		List<CategoryVO> selectList = cate.CategoryGet();
		model.addAttribute("selectList", selectList);
		
		BoardVO ViewBoard = service.ViewBoard(b_num);
		model.addAttribute("ViewBoard", ViewBoard);
		
		List<ReplyVO> GetReply = reply.GetReply(b_num);
		model.addAttribute("GetReply", GetReply);

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
