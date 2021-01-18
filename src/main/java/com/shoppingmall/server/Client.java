package com.shoppingmall.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


//한명의 클라이언트와 통신을 하기 위해서 필요한 기능들을 Client 클래스에 정의
public class Client {
	Socket socket;

	public Client(Socket socket) { //생성자를 호출함으로써 현재 클라이언트에 서버의 소켓과 통신할 소켓을 만듬.
		this.socket = socket;
		receive();					//receive()메소드 실행
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	//클라이언트로부터 메세지를 전달 받는 메서드
	public void receive() { //반복적으로 어떠한 클라이언트로부터 메세지를 전달 받고 그와 동시에 전달 받은 메세지를 다른 클라이언트들한테도 전송을 해줌으로써 채팅서버로써의 역할을 수행하는것
		Runnable runnable = new Runnable() { // Runnable 객체 즉 작업 객체를 만듬 

			@Override
			public void run() {	//start run();
				try {
					while(true) { //반복적으로 클라이언트에게 내용을 전달받을 수 있도록 만들어 준다.
						
						// 어떠한 내용을 전달 받을 수 있도록 InputStream객체를 이용함
						InputStream inputStream = socket.getInputStream();
						
						byte buffer[] = new byte[512]; // 한번에 512byte만큼 전달 받을수 있도록 만듬
						int length = inputStream.read(buffer); //클라이언트로부터 받은 내용(데이터)를 byte배열에 저장하고 읽은 바이트 수를 length에 저장
						
						//내용(데이터)를 읽어들이는데 있어서 오류가 발생한다면 오류가 발생했다고 알려줌.
						while(length == -1) {
							throw new IOException();
						}
						
						//현재 접속을 한 클라이언트의 IP주소와 같은 주소 정보를 출력하고 스레드의 고유정보(이름) 출력
						System.out.println("클라이언트가 보낸 메세지를 서버에서 메세지 받기 성공 = " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());
						
						//buffer배열의 0번째부터 length 까지 즉 전달받은 데이터를 "UTF-8"로 인코딩처리를 하여 data에 저장함.
						String message = new String(buffer, 0, length, "UTF-8");

						//전달 받은 메세지를 다른 클라이언트들에게도 보낼 수 있도록 만든다.
						for(int i = 0; i < Server.vector.size(); i++) {
							Server.vector.get(i).send(message);
						}
					}
				} catch(Exception e1) {
					try {
						//메세지를 전달 받는 과정에서 오류가 발생한다면 메세지를 보낸 클라이언트의 IP주소와 같은 주소 정보를 출력하고 해당 스레드의 고유 고유정보(이름) 출력
						System.out.println("메세지 수신 오류" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());	//메세지를 전달 받는 과정에서 오류가 발생한다면 메세지를 보낸 클라이언트의 IP주소와 같은 주소 정보를 출력하고 해당 스레드의 고유 고유정보(이름) 출력
						Server.vector.remove(Client.class);
						socket.close();
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			} //end run();			
		};
		
		// 스레드풀에 이렇게 만들어진 하나의스레드(작업객체)를 등록을 시켜주겠다라는 뜻
		Server.executorService.submit(runnable);
	}	//end receive();
	
	
	//다른 클라이언트에게 메세지를 전송해주는 메서드
	public void send(final String message) {
		Runnable runnable = new Runnable() { // Runnable 객체 즉 작업 객체를 만듬 

			@Override
			public void run() {
				try {
					OutputStream outputStream = socket.getOutputStream(); // 어떠한 내용을 보낼 수 있도록 OutputStream객체를 이용함
					byte buffer[] = message.getBytes("UTF-8");				// 보낼 내용(데이터)을 getBytes()메소드로 문자열을 바이트로 변환 후 "UTF-8"로 인코딩 한 후 buffer배열에 저장
					outputStream.write(buffer);							// write메소드를 이용하여 buffer에 담긴 내용을 서버에서 클라이언트로 전송한다는 뜻
					outputStream.flush();								// 출력 스트림의 내부 버퍼를 완전히 비우도록 flush()메소드를 호출함.
				} catch(Exception e1) {
					try {
						//메세지를 전달 받는 과정에서 오류가 발생한다면 메세지를 보낸 클라이언트의 IP주소와 같은 주소 정보를 출력하고 해당 스레드의 고유 고유정보(이름) 출력
						System.out.println("메세지 송신 오류" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());
						
						
						/*
						  별도로 오류가 발생했다면 메인함수에 있는 클라이언트 즉 모든 클라이언트들에 대한 정보를 담는 
						  배열에서 현재 존재하는 클라이언트를 지워준다. 즉 오류가 발생해서 해당 클라이언트가 서버로부터
						   접속이 끊겼으니까 당연히 우리 서버안에서도 해당 클라이언트가 접속이 끊겼다는
						  정보를 처리할 수있도록 해준다. 즉 클라이언트 배열에서 해당 오류가 생긴 클라이언트를 제거해주는것.
						 */
						Server.vector.remove(Client.class);
						socket.close();  //소켓 클로즈 함수를 실행해서 오류가 생긴 클라이언트의 소켓을 닫는다.
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}; 		// end run();
		// 스레드풀에 이렇게 만들어진 하나의스레드(작업객체)를 등록을 시켜주겠다라는 뜻
		Server.executorService.submit(runnable);
	} // end send();
}
