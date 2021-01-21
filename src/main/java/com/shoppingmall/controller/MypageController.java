package com.shoppingmall.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shoppingmall.service.MypageService;
import com.shoppingmall.service.RegisterService;
import com.shoppingmall.vo.MembersVO;

@Controller
public class MypageController {

	@Inject
	RegisterService registerService;
	
	@Inject
	MypageService mypageService;
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String ChattingBangList(Model model, HttpServletRequest request) throws Exception {
		//회원의 정보를 가져온 후 뿌려주는 로직 작성......
		HttpSession session = request.getSession();
		String memberid = (String)session.getAttribute("memberid");
		MembersVO vo = mypageService.MypageList(memberid);
		String FilePath = "";
		
		//기본 이미지
		if(vo.getUuid().equals("") && vo.getUploadPath().equals("")) {
			//집에서 하려면 경로 바꿔주어야 합니다 ~~~~~~~~~~~~~~~@@#@131232131321321312
			FilePath = "/resources/upload/temp/"+ vo.getUploadPath() + vo.getUuid() + vo.getFileName();
		}
		else { 		//기본 이미지 아닐 때
			//집에서 하려면 경로 바꿔주어야 합니다 ~~~~~~~~~~~~~~~@@#@131232131321321312
			FilePath = "/resources/upload/temp/"+ vo.getUploadPath() + "/" + vo.getUuid() + "_" + vo.getFileName();
		}
		model.addAttribute("filePath", FilePath);
		return "/mypage";
	}
	
	
	@RequestMapping(value = "/mypage/uploadAjaxAction", method = RequestMethod.POST)
	public String uploadAjaxAction(MultipartHttpServletRequest multipartHttpServletRequest, HttpServletRequest request) {
		//집에서 하려면 경로 바꿔주어야 합니다
		String uploadFolder = "D:\\KHT\\shopping_mall_project\\src\\main\\webapp\\resources\\upload\\temp";
		List<MultipartFile> uploadFile = multipartHttpServletRequest.getFiles("uploadFile");
		
		
		
		//파일 만듬
		String getFolder = getFolder();
		File uploadPath = new File(uploadFolder, getFolder);
		System.out.println("uploadPath ==== " + uploadPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		for(int i = 0; i < uploadFile.size(); i++) {
			String uploadFileName = uploadFile.get(i).getOriginalFilename();
			String DBuploadFileName = uploadFileName;
			//IE일 경우
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			
			//파일의 중복저장을 피하기 위해 UUID 사용
			// _ 를 기준으로 원래이름 파악
			UUID uuid = UUID.randomUUID();
			String uuidName = uuid.toString();
			System.out.println(uuidName);
			uploadFileName = uuidName + "_" + uploadFileName;
			File saveFile = new File(uploadPath, uploadFileName);
			try {
				//서버에 파일 저장
				uploadFile.get(i).transferTo(saveFile);
				
				//서버에 저장 후 db에 파일 정보 저장
				MembersVO vo = new MembersVO();
				HttpSession session = request.getSession();
				
				vo.setMemberid((String)session.getAttribute("memberid"));
				vo.setUuid(uuidName);
				vo.setUploadPath(getFolder);
				vo.setFileName(DBuploadFileName);
				
				int num = mypageService.MypageUpdate(vo);
				if(num == 1) {
					System.out.print("잘 됐다.");
				}
				
			} catch(Exception e) {
				System.out.println("uploadAjaxAction() 오류");
				e.printStackTrace();
			}
		}
		return "redirect:/mypage";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//회원의 정보를 가져온 후 뿌려주는 로직 작성...... 나중에....
	// 파일을 구별하기 위해 날짜 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
}
