package com.shoppingmall.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

	// static ���� ����� ���� / static ������ ���ϸ� 1��1???
	public static ExecutorService executorService; // ������Ǯ�� ExecutorService �ʵ尡 ����Ǿ� �ִ�.
	public static Vector<Client> vector = new Vector<Client>(); // ������ Ŭ���̾�Ʈ���� ������ �� �ֵ��� ��.
	ServerSocket serverSocket; // ���� ����
	
	
	// ������ �������Ѽ� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼���
	public void startServer(String IP, int port) {
		//������ �����̵Ǹ� ServerSocket���� �۾��� ���ش�.
		try {
			this.serverSocket = new ServerSocket();					//ServerSocket ��ü�� ����
			this.serverSocket.bind(new InetSocketAddress(IP, port));//���� ��ǻ�� ������ �����ϴ� �� ��ǻ�Ͱ� �ڽ��� IP�ּ� �׸��� ��Ʈ��ȣ�� Ư���� Ŭ���̾�Ʈ�� ������ ��ٸ�
		} catch (Exception e) {
			e.printStackTrace();
			//������ �߻��ϸ� ���������� ���࿡ �����ִ� ���°� �ƴ϶�� stopServer()�޼ҵ带 ȣ���� ������ �ݾ��ش�.
			if (!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}

		// Ŭ���̾�Ʈ�� ������ ������ ��� ��ٸ��� �������Դϴ�.(������ �����ϴ� �ڵ�)
		Runnable runnable = new Runnable() {
			// ���� ���� �۾��� Runnable�� ����
			@Override
			public void run() {
				//���ѷ����� ���� ����ؼ� ���ο� Ŭ���̾�Ʈ���� ���� ������ ������ �ݺ��ϵ��� �Ѵ�.
				while (true) {
					try {
						Socket socket = serverSocket.accept(); //Ŭ���̾�Ʈ�� ���� ��û�� ��ٸ���, ���� �����ϴ� accept()�޼ҵ带 ȣ���Ѵ�.
						vector.add(new Client(socket));		//Ŭ���̾�Ʈ ���Ϳ� ���Ӱ� ������ Ŭ���̾�Ʈ�� �߰���. 
						System.out.println("[Ŭ���̾�Ʈ ����]" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());//���� ������ �� Ŭ���̾�Ʈ�� IP�ּҿ� ���� �ּ� ������ ����ϰ� �������� ��������(�̸�) ���
					} catch (Exception e) {
						if(!serverSocket.isClosed()) { //������ �߻��ߴٸ� ������ ����
							stopServer();
						}
					}
				}
			}
		};
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // ������Ǯ�� �ʱ�ȭ�ϰ�
		executorService.submit(runnable);	//������ Ǯ�� ���� Ŭ���̾�Ʈ�� ��ٸ��� runnable��ü�� ���� �� �ֵ��� ó���� �ؼ� ������ Ǯ�� ���� �ʱ�ȭ�� ���ְ� ������ Ǯ�ȿ� ù��° ������ν� Ŭ���̾�Ʈ�� ������ ��ٸ��� �����带 �־��ذ�
	}
	
	//������ �۵��� ������Ű�� �޼���
	public void stopServer() {
		try {
			//���� �۵����� ��� ���� �ݱ�
			Iterator<Client> iterator = vector.iterator();
			while(iterator.hasNext()) {
				Client vo = iterator.next();
				vo.getSocket().close();
				iterator.remove();
			}
			
			//���� ���� ��ü �ݱ�
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			//������ Ǯ �����ϱ�
			if(executorService !=null && executorService.isShutdown()) {
				executorService.shutdown();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
