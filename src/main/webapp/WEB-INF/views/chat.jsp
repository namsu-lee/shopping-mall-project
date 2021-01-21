<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>웹소켓 채팅</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
	<script type="text/javascript">
		var webSocket = {
			init: function(param) {
				this._url = param.url;
				this._initSocket();
			},
			sendChat: function() {
				this._sendMessage('${sessionScope.memberid}', '${param.bang_id}', 'CMD_MSG_SEND', $('#message').val());
				$('#message').val('');
			},
			sendEnter: function() {
				this._sendMessage('${sessionScope.memberid}', '${param.bang_id}', 'CMD_ENTER', $('#message').val());
				$('#message').val('');
			},
			receiveMessage: function(msgData) {
				//아이디 말고 닉네임을 뿌려주고 && db연동 해야한다.
				//ChatView로 들어갈때 즉 컨트롤러를 탈때 model에다 닉네임 추가시켜준다.
				
				// 정의된 CMD 코드에 따라서 분기 처리
				if(msgData.cmd == 'CMD_MSG_SEND') {
					var output = "";
					if(msgData.msgname == '${sessionScope.memberid}') {//로그인
						output += "<div class='container darker'>";
						output += 	"<img src='" + msgData.msgimage + "' alt='x' class='right' style='width:100%;'>";
						output += 	"<p>" + msgData.msg + "</p>";
						output +=	"<p style='clear:both; text-align:right; width:96%; margin:0px auto;'>" + msgData.msgname + "</p>";
						output += 	"<span class='time-left'>" + msgData.msgdate + "</span>";
						output += "</div>";
					}
					else{
						output += "<div class='container'>";
						output += 	"<img src='" + msgData.msgimage + "' alt='x' style='width:100%;'>";
						output += 	"<p>" + msgData.msg + "</p>";
						output +=	"<p style='clear:both;'>" + msgData.msgname + "</p>";
						output += 	"<span class='time-right'>" + msgData.msgdate + "</span>";
						output += "</div>";
					}

					$('#divChatData').append(output);
				}
				// 입장
				else if(msgData.cmd == 'CMD_ENTER') {
					$('#divChatData').append('<div>' + msgData.msg + '</div>');
				}
				// 퇴장
				else if(msgData.cmd == 'CMD_EXIT') {					
					$('#divChatData').append('<div>' + msgData.msg + '</div>');
				}
			},
			closeMessage: function(str) {
				$('#divChatData').append('<div>' + '연결 끊김 : ' + str + '</div>');
			},
			disconnect: function() {
				this._socket.close();
			},
			_initSocket: function() {
				this._socket = new SockJS(this._url);
				this._socket.onopen = function(evt) {
					webSocket.sendEnter();
				};
				this._socket.onmessage = function(evt) {
					webSocket.receiveMessage(JSON.parse(evt.data));
				};
				this._socket.onclose = function(evt) {
					webSocket.closeMessage(JSON.parse(evt.data));
				}
			},
			_sendMessage: function(SessionID, bang_id, cmd, msg) {
				var msgData = {
						SessionID : SessionID,
						bang_id : bang_id,
						cmd : cmd,
						msg : msg
				};
				var jsonData = JSON.stringify(msgData);
				this._socket.send(jsonData);
			}
		};
	</script>	
	<script type="text/javascript">
        $(window).on('load', function () {
			webSocket.init({ url: '<c:url value="/chat" />' });	
		});
        
        
	</script>
	<link href="/resources/css/chat.css" rel="stylesheet">
</head>
<body>
	<div style="width: 800px; height: 700px; padding: 10px; border: solid 1px #e1e3e9;">
		<div id="divChatData">
			
		</div>
	</div>
	<div style="width: 100%; height: 10%; padding: 10px;">
		<input type="text" id="message" size="110" onkeypress="if(event.keyCode==13){webSocket.sendChat();}" />
		<input type="button" id="btnSend" value="채팅 전송" onclick="webSocket.sendChat()" />
		<button type="button" onclick="history.back()">채팅목록으로</button>
	</div>
</body>
</html>