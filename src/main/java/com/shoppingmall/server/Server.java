package com.shoppingmall.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

	// static 으로 선언시 다중 / static 선언을 안하면 1대1???
	public static ExecutorService executorService; // 스레드풀인 ExecutorService 필드가 선언되어 있다.
	public static Vector<Client> vector = new Vector<Client>(); // 접속한 클라이언트들을 관리할 수 있도록 함.
	ServerSocket serverSocket; // 서버 소켓
	
	
	// 서버를 구동시켜서 클라이언트의 연결을 기다리는 메서드
	public void startServer(String IP, int port) {
		//서버가 실행이되면 ServerSocket부터 작업을 해준다.
		try {
			this.serverSocket = new ServerSocket();					//ServerSocket 객체를 생성
			this.serverSocket.bind(new InetSocketAddress(IP, port));//서버 컴퓨터 역할을 수행하는 그 컴퓨터가 자신의 IP주소 그리고 포트번호로 특정한 클라이언트의 접속을 기다림
		} catch (Exception e) {
			e.printStackTrace();
			//오류가 발생하면 서버소켓이 만약에 닫혀있는 상태가 아니라면 stopServer()메소드를 호출해 서버를 닫아준다.
			if (!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}

		// 클라이언트가 접속할 때까지 계속 기다리는 쓰레드입니다.(연결을 수락하는 코드)
		Runnable runnable = new Runnable() {
			// 연결 수락 작업을 Runnable로 정의
			@Override
			public void run() {
				//무한루프를 돌려 계속해서 새로운 클라이언트들의 연결 수락을 무한히 반복하도록 한다.
				while (true) {
					try {
						Socket socket = serverSocket.accept(); //클라이언트의 연결 요청을 기다리고, 연결 수락하는 accept()메소드를 호출한다.
						vector.add(new Client(socket));		//클라이언트 백터에 새롭게 접속한 클라이언트를 추가함. 
						System.out.println("[클라이언트 접속]" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());//현재 접속을 한 클라이언트의 IP주소와 같은 주소 정보를 출력하고 스레드의 고유정보(이름) 출력
					} catch (Exception e) {
						if(!serverSocket.isClosed()) { //오류가 발생했다면 서버를 닫음
							stopServer();
						}
					}
				}
			}
		};
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // 스레드풀을 초기화하고
		executorService.submit(runnable);	//스레드 풀에 현재 클라이언트를 기다리는 runnable객체를 담을 수 있도록 처리를 해서 스레드 풀을 먼저 초기화를 해주고 스레드 풀안에 첫번째 스레드로써 클라이언트에 접속을 기다리는 스레드를 넣어준것
	}
	
	//서버의 작동을 중지시키는 메서드
	public void stopServer() {
		try {
			//현재 작동중인 모든 소켓 닫기
			Iterator<Client> iterator = vector.iterator();
			while(iterator.hasNext()) {
				Client vo = iterator.next();
				vo.getSocket().close();
				iterator.remove();
			}
			
			//서버 소켓 객체 닫기
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			//쓰레드 풀 종료하기
			if(executorService !=null && executorService.isShutdown()) {
				executorService.shutdown();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
