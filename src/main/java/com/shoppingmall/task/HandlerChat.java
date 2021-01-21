package com.shoppingmall.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingmall.vo.MembersVO;

@Component
public class HandlerChat extends TextWebSocketHandler {
	// (<"bang_id", 방ID>, <"session", 세션>) - (<"bang_id", 방ID>, <"session", 세션>) -
	// (<"bang_id", 방ID>, <"session", 세션>) 형태
	private List<Map<String, Object>> sessionList = new ArrayList<Map<String, Object>>();

	@Autowired
	private SqlSession sqlSession;
	private String nickname      = "";
	private String TotalFileName = "";
	
	private static final String Namespace = "com.shoppingmall.mapper.ChatMapper";
	
	// 클라이언트가 서버로 메세지 전송 처리
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		super.handleTextMessage(session, message);

		// JSON --> Map으로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> mapReceive = objectMapper.readValue(message.getPayload(), Map.class);
		
		/*	입장했을때 들어오는 데이터
			message.getPayload() == {"SessionID":"test1","bang_id":"ChatView1","cmd":"CMD_ENTER","msg":""}
		*/
		/*	채팅 쳤을때 들어오는 데이터
			message.getPayload() == {"SessionID":"test1","bang_id":"ChatView1","cmd":"CMD_MSG_SEND","msg":"ㅎㅇ"}
		*/
		System.out.println("message.getPayload() == " + message.getPayload());
		
		
		Set<Map.Entry<String, String>> entrySet = mapReceive.entrySet();
		Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, String> entry = entryIterator.next();
			System.out.println("entry.getKey() == " + entry.getKey());
			System.out.println("entry.getValue() == " + entry.getValue());
			/* ************************************
			    입장했을때 들어오는 데이터
			    
				entry.getKey()   == SessionID
				entry.getValue() == test1
				-----------------------------
				entry.getKey()   == bang_id
				entry.getValue() == ChatView1
				-----------------------------
				entry.getKey()   == cmd
				entry.getValue() == CMD_ENTER
				-----------------------------
				entry.getKey()   == msg
				entry.getValue() == 
				************************************
				채팅 쳤을때 들어오는 데이터
				
				entry.getKey() == SessionID
				entry.getValue() == test1
				-----------------------------
				entry.getKey() == bang_id
				entry.getValue() == ChatView1
				-----------------------------
				entry.getKey() == cmd
				entry.getValue() == CMD_MSG_SEND
				-----------------------------
				entry.getKey() == msg
				entry.getValue() == ㅎㅇ
				************************************
			*/
		}
				
		String SessionID = (String)mapReceive.get("SessionID");
		MembersVO vo = Image_NickName(SessionID);
		
		this.nickname = vo.getNickname();
		if(vo.getUuid().equals("") && vo.getUploadPath().equals("")) {
			//집에서 하려면 경로 바꿔주어야 합니다 ~~~~~~~~~~~~~~~
			this.TotalFileName = "/resources/upload/temp/"+ vo.getUploadPath() + vo.getUuid() + vo.getFileName();
		}
		else { 		//기본 이미지 아닐 때
			//집에서 하려면 경로 바꿔주어야 합니다 ~~~~~~~~~~~~~~~
			this.TotalFileName = "/resources/upload/temp/"+ vo.getUploadPath() + "/" + vo.getUuid() + "_" + vo.getFileName();
		}

		switch (mapReceive.get("cmd")) {
		
		// CLIENT 입장
		case "CMD_ENTER":
			// 세션 리스트에 저장
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("bang_id", mapReceive.get("bang_id"));
			map.put("session", session);
			sessionList.add(map);

			// 같은 채팅방에 입장 메세지 전송
			for (int i = 0; i < sessionList.size(); i++) {
				Map<String, Object> mapSessionList = sessionList.get(i);
				String bang_id = (String)mapSessionList.get("bang_id");
				WebSocketSession sess = (WebSocketSession) mapSessionList.get("session");
				if (bang_id.equals(mapReceive.get("bang_id"))) {
					Map<String, String> mapToSend = new HashMap<String, String>();
					mapToSend.put("bang_id", bang_id);
					mapToSend.put("cmd", "CMD_ENTER");
					mapToSend.put("msg", this.nickname + "님이 입장 했습니다.");

					String jsonStr = objectMapper.writeValueAsString(mapToSend);
					sess.sendMessage(new TextMessage(jsonStr));
				}
			}
			break;

		// CLIENT 메세지
		case "CMD_MSG_SEND":
			// 같은 채팅방에 메세지 전송
			for (int i = 0; i < sessionList.size(); i++) {
				Map<String, Object> mapSessionList = sessionList.get(i);
				String bang_id = (String) mapSessionList.get("bang_id");
				WebSocketSession sess = (WebSocketSession) mapSessionList.get("session");

				if (bang_id.equals(mapReceive.get("bang_id"))) {
					Map<String, String> mapToSend = new HashMap<String, String>();
					mapToSend.put("bang_id", bang_id);
					mapToSend.put("cmd", "CMD_MSG_SEND");
					mapToSend.put("msgname", this.nickname);
					mapToSend.put("msgimage", this.TotalFileName);
					mapToSend.put("msg", mapReceive.get("msg"));
					mapToSend.put("msgdate", Chatting_Date());
					String jsonStr = objectMapper.writeValueAsString(mapToSend);
					sess.sendMessage(new TextMessage(jsonStr));
				}
			}
			break;
		}
	}

	// 클라이언트가 연결을 끊음 처리
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		super.afterConnectionClosed(session, status);

		ObjectMapper objectMapper = new ObjectMapper();
		String now_bang_id = "";

		// 사용자 세션을 리스트에서 제거
		for (int i = 0; i < sessionList.size(); i++) {
			Map<String, Object> map = sessionList.get(i);
			String bang_id = (String) map.get("bang_id");
			WebSocketSession sess = (WebSocketSession) map.get("session");

			if (session.equals(sess)) {
				now_bang_id = bang_id;
				sessionList.remove(map);
				break;
			}
		}

		// 같은 채팅방에 퇴장 메세지 전송
		for (int i = 0; i < sessionList.size(); i++) {
			Map<String, Object> mapSessionList = sessionList.get(i);
			String bang_id = (String) mapSessionList.get("bang_id");
			WebSocketSession sess = (WebSocketSession) mapSessionList.get("session");

			if (bang_id.equals(now_bang_id)) {
				Map<String, String> mapToSend = new HashMap<String, String>();
				mapToSend.put("bang_id", bang_id);
				mapToSend.put("cmd", "CMD_EXIT");
				mapToSend.put("msg", this.nickname + "님이 퇴장 했습니다.");

				String jsonStr = objectMapper.writeValueAsString(mapToSend);
				sess.sendMessage(new TextMessage(jsonStr));
			}
		}
	}
	
	//채팅쓴 날짜 구함
	private String Chatting_Date() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String format_time1 = format1.format(time.getTime());
		return format_time1;
	}
	
	
	//로그인 한 사람의 이미지 및 닉네임 가져옴
	
	private MembersVO Image_NickName(String memberid) {
		return sqlSession.selectOne(Namespace + ".GetMemberInfo", memberid);
	}
	
}
