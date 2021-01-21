package com.shoppingmall.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class MypageController {

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String ChattingBangList(Model model, HttpServletRequest request) {
		
		//회원의 정보를 가져온 후 뿌려주는 로직 작성......
		HttpSession session = request.getSession();
		
		
		return "/mypage";
	}
	
	
	@RequestMapping(value = "/mypage/uploadAjaxAction", method = RequestMethod.POST)
	public void uploadAjaxAction(MultipartHttpServletRequest request) {
		
		String uploadFolder = "C:\\upload\\temp";
		List<MultipartFile> uploadFile = request.getFiles("uploadFile");
		
		
		
		//파일 만듬
		File uploadPath = new File(uploadFolder, getFolder());
		System.out.println("uploadPath ==== " + uploadPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		for(int i = 0; i < uploadFile.size(); i++) {
			String uploadFileName = uploadFile.get(i).getOriginalFilename();
			
			//IE일 경우
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
		
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				//서버에 파일 저장
				uploadFile.get(i).transferTo(saveFile);
			} catch(Exception e) {
				System.out.println("uploadAjaxAction() 오류");
				e.printStackTrace();
			}
		}
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
