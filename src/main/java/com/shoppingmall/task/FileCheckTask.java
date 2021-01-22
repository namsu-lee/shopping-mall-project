package com.shoppingmall.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shoppingmall.service.MypageService;
import com.shoppingmall.vo.MembersVO;

@Component
public class FileCheckTask {
	
	@Autowired
	private MypageService mypageService;
	
	private final String pailgyeonglo = "D:\\KHT\\shopping_mall_project\\src\\main\\webapp\\resources\\upload\\temp"; 
	
	//어제 날짜
	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		
		String str = sdf.format(cal.getTime());
		return str.replace("-", File.separator);
	}
	
	
	
	//파일 주기적으로 삭제
	@Scheduled(cron = "0 0 2 * * *")
	public void checkFiles() throws Exception {

		/*
		 * 일단 전날 등록된 파일들 목록을 얻어오고
		 * 
		 * 해당목록을 리스트에 보관 fileListPaths
		 * 
		 * 목록의 파일이 이미지인 경우에는 섬네일도 같이 fileListPaths에 추가
		 * 
		 * 마지막으로 폴더에 fileListPaths에 존재하지 않는 파일들만 수집해서 삭제
		 */
		
		//오늘 기준 어제 날짜 파일정보
		List<MembersVO> fileList = mypageService.getOldFiles();
		
		for(int i = 0; i < fileList.size(); i++) {
			System.out.println(fileList.get(i).toString());
		}
		
		List<Path> fileListPaths = new ArrayList<Path>();
		//fileListPaths에 오늘 기준 어제 날짜 파일정보를 담는다.
		for(int i = 0; i < fileList.size(); i++) {
			Path path = Paths.get(pailgyeonglo, fileList.get(i).getUploadPath(),
					fileList.get(i).getUuid() + "_" + fileList.get(i).getFileName());
			fileListPaths.add(path);
			/* path 찍으면
			   D:\\KHT\\shopping_mall_project\\src\\main\\webapp\\resources\\upload\\temp\\2021\\01\\21\\b3b11d10-a412-4384-a54c-332642e07c3e_Hydrangeas.jpg
			   D:\\KHT\\shopping_mall_project\\src\\main\\webapp\\resources\\upload\\temp\\2021\\01\\21\\69bdff2e-a79c-4984-bbe9-99782e1e65dc_Penguins.jpg
			*/
		}
		
		//경로를 파일로 받는다.
		File targetDirectory = Paths.get(pailgyeonglo, getFolderYesterDay()).toFile();
		
		//삭제할 파일 담는 배열
		//File removeFiles[] = null;
		
		//삭제할 파일을 담음
		List<File> removeFiles = new ArrayList<File>();
		
		//디렉토리의 파일목록(디렉토리 포함)을 File배열로 반환한다.
		//C:\\upload\\temp\\2021\\01\\10안에 있는 파일들을 배열로 반환함.
		File[] targetFile = targetDirectory.listFiles();
		
		System.out.println("fileListPaths");
		System.out.println("**********************************");
		for (int i = 0; i < fileListPaths.size(); i++) {
			Path p = fileListPaths.get(i);
			System.out.println(p.getFileName().toString());
		}
		
		System.out.println("**********************************");
		
		System.out.println("targetFile");
		System.out.println("**********************************");
		for (int i = 0; i < targetFile.length; i++) {
			System.out.println(targetFile[i].toPath().getFileName().toString());
		}

		System.out.println("**********************************");
		
		for(int i = 0; i < targetFile.length; i++) {
			boolean flag = false;
			for(int j = 0; j < fileListPaths.size(); j++) {
				if(targetFile[i].toPath().getFileName().toString().equals(fileListPaths.get(j).getFileName().toString())) {
					flag = true;
					continue;
				}
			}
			if(flag == false) {
				removeFiles.add(targetFile[i]);
			}
		}
		
		
		//파일 삭제
		for(int i = 0; i < removeFiles.size(); i++) {
			//C:\\upload\\temp\\2021\\01\\11\\
			//		cba56894-9811-4a6f-bab6-4b532399995f_Penguins.jpg
			System.out.println("서버에 저장되어있는 파일 삭제중..... ===  " + removeFiles.get(i).getAbsolutePath());
			//removeFiles.get(i).delete();     <== 주석 풀어줘야함 지금은 일시적으로 막아놓음.
		}
	} 
}
