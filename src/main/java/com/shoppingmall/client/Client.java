package com.shoppingmall.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//클라이언트 측

//클라이언트 프로그램 같은 경우는 서버 프로그램과 다르게 굳이 여러개의 스레드가 계속계속
//동시 다발적으로 생겨나는경우가 없기 때문에 굳이 쓰레드풀을 사용할 필요가 없음
//그래서 스레드풀 없이 기본적인 스레드를 이용함
public class Client {
	Socket socket;

	// 클라이언트가 서버에 요청하는 메서드
	public void startClient(final String IP, final int port) {
		Thread thread = new Thread() {
			public void run() {
				try {
					socket = new Socket(IP, port);
					receive();						//IP(192.168.0.3)번호와 port(9876)번호로 연결 요청을 한다.
				} catch (Exception e) {
					if (!socket.isClosed()) { // 오류가 발생한경우 소켓이 그대로 열려있다면
						stopClient(); // 클라이언트를 종료시킨다.
						System.out.println("서버 접속 실패");
					}
				}
			}
		};
		thread.start();
	}

	// 클라이언트 종료 메서드
	public void stopClient() {
		try {
			if (socket != null && !socket.isClosed()) { // 소켓이 현재 열려있는 상태라면 소켓을 닫아줌.
				socket.close();
			}
		} catch (Exception e) { // 종료하는 과정에서도 오류가 발생할 수 있기 때문에 예외처리해줌.
			e.printStackTrace();
		}
	}

	// 서버로부터 메세지를 전달받는 메소드
	public void receive() {
		while (true) { // 계속해서 서버로부터 메세지(데이터)를 계속 전달받기 위해서 무한루프를 돌려줌
			try {
				InputStream in = socket.getInputStream(); // 어떠한 내용을 전달 받을 수 있도록 InputStream객체를 이용함
				byte[] buffer = new byte[512]; // 한번에 512byte만큼 전달 받을수 있도록 만듬
				int length = in.read(buffer); // 클라이언트로부터 받은 내용(데이터)를 byte배열에 저장하고 읽은 바이트 수를 length에 저장, read()메소드를 이용하여
												// 실제로 입력을 받도록 하는것.
				if (length == -1) {
					throw new IOException();
				} // 내용(데이터)를 읽어들이는데 있어서 오류가 발생한다면 오류가 발생했다고 알려줌.
				String message = new String(buffer, 0, length, "UTF-8");// buffer배열의 0번째부터 length 까지 즉 전달받은 데이터를
																		// "UTF-8"로 인코딩처리를 하여 data에 저장함.
			} catch (Exception e) {
				stopClient(); // 오류가 발생했을때는 stopClient()메소드를 실행하고 break를 걸어 무한루프를 탈출함.
				break;
			}
		}
	}

	
	// 서버로 메세지를 전송하는 메서드입니다.
	public void send(final String message) {
		Thread thread = new Thread() {
			public void run() {
				try {
					OutputStream out = socket.getOutputStream(); // 어떠한 내용을 보낼 수 있도록 OutputStream객체를 이용함
					byte[] buffer = message.getBytes("UTF-8"); // 보낼 내용(데이터)을 getBytes()메소드로 문자열을 바이트로 변환 후 "UTF-8"로 인코딩
																// 한 후 buffer배열에 저장
					out.write(buffer); // write메소드를 이용하여 buffer에 담긴 내용을 서버에서 클라이언트로 전송한다는 뜻
					out.flush();
				} catch (Exception e) {
					stopClient();
				}
			}
		};
		thread.start();
	}

}
