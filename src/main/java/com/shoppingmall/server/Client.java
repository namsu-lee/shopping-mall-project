package com.shoppingmall.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


//�Ѹ��� Ŭ���̾�Ʈ�� ����� �ϱ� ���ؼ� �ʿ��� ��ɵ��� Client Ŭ������ ����
public class Client {
	Socket socket;

	public Client(Socket socket) { //�����ڸ� ȣ�������ν� ���� Ŭ���̾�Ʈ�� ������ ���ϰ� ����� ������ ����.
		this.socket = socket;
		receive();					//receive()�޼ҵ� ����
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	//Ŭ���̾�Ʈ�κ��� �޼����� ���� �޴� �޼���
	public void receive() { //�ݺ������� ��� Ŭ���̾�Ʈ�κ��� �޼����� ���� �ް� �׿� ���ÿ� ���� ���� �޼����� �ٸ� Ŭ���̾�Ʈ�����׵� ������ �������ν� ä�ü����ν��� ������ �����ϴ°�
		Runnable runnable = new Runnable() { // Runnable ��ü �� �۾� ��ü�� ���� 

			@Override
			public void run() {	//start run();
				try {
					while(true) { //�ݺ������� Ŭ���̾�Ʈ���� ������ ���޹��� �� �ֵ��� ����� �ش�.
						
						// ��� ������ ���� ���� �� �ֵ��� InputStream��ü�� �̿���
						InputStream inputStream = socket.getInputStream();
						
						byte buffer[] = new byte[512]; // �ѹ��� 512byte��ŭ ���� ������ �ֵ��� ����
						int length = inputStream.read(buffer); //Ŭ���̾�Ʈ�κ��� ���� ����(������)�� byte�迭�� �����ϰ� ���� ����Ʈ ���� length�� ����
						
						//����(������)�� �о���̴µ� �־ ������ �߻��Ѵٸ� ������ �߻��ߴٰ� �˷���.
						while(length == -1) {
							throw new IOException();
						}
						
						//���� ������ �� Ŭ���̾�Ʈ�� IP�ּҿ� ���� �ּ� ������ ����ϰ� �������� ��������(�̸�) ���
						System.out.println("Ŭ���̾�Ʈ�� ���� �޼����� �������� �޼��� �ޱ� ���� = " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());
						
						//buffer�迭�� 0��°���� length ���� �� ���޹��� �����͸� "UTF-8"�� ���ڵ�ó���� �Ͽ� data�� ������.
						String message = new String(buffer, 0, length, "UTF-8");

						//���� ���� �޼����� �ٸ� Ŭ���̾�Ʈ�鿡�Ե� ���� �� �ֵ��� �����.
						for(int i = 0; i < Server.vector.size(); i++) {
							Server.vector.get(i).send(message);
						}
					}
				} catch(Exception e1) {
					try {
						//�޼����� ���� �޴� �������� ������ �߻��Ѵٸ� �޼����� ���� Ŭ���̾�Ʈ�� IP�ּҿ� ���� �ּ� ������ ����ϰ� �ش� �������� ���� ��������(�̸�) ���
						System.out.println("�޼��� ���� ����" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());	//�޼����� ���� �޴� �������� ������ �߻��Ѵٸ� �޼����� ���� Ŭ���̾�Ʈ�� IP�ּҿ� ���� �ּ� ������ ����ϰ� �ش� �������� ���� ��������(�̸�) ���
						Server.vector.remove(Client.class);
						socket.close();
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			} //end run();			
		};
		
		// ������Ǯ�� �̷��� ������� �ϳ��ǽ�����(�۾���ü)�� ����� �����ְڴٶ�� ��
		Server.executorService.submit(runnable);
	}	//end receive();
	
	
	//�ٸ� Ŭ���̾�Ʈ���� �޼����� �������ִ� �޼���
	public void send(final String message) {
		Runnable runnable = new Runnable() { // Runnable ��ü �� �۾� ��ü�� ���� 

			@Override
			public void run() {
				try {
					OutputStream outputStream = socket.getOutputStream(); // ��� ������ ���� �� �ֵ��� OutputStream��ü�� �̿���
					byte buffer[] = message.getBytes("UTF-8");				// ���� ����(������)�� getBytes()�޼ҵ�� ���ڿ��� ����Ʈ�� ��ȯ �� "UTF-8"�� ���ڵ� �� �� buffer�迭�� ����
					outputStream.write(buffer);							// write�޼ҵ带 �̿��Ͽ� buffer�� ��� ������ �������� Ŭ���̾�Ʈ�� �����Ѵٴ� ��
					outputStream.flush();								// ��� ��Ʈ���� ���� ���۸� ������ ��쵵�� flush()�޼ҵ带 ȣ����.
				} catch(Exception e1) {
					try {
						//�޼����� ���� �޴� �������� ������ �߻��Ѵٸ� �޼����� ���� Ŭ���̾�Ʈ�� IP�ּҿ� ���� �ּ� ������ ����ϰ� �ش� �������� ���� ��������(�̸�) ���
						System.out.println("�޼��� �۽� ����" + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());
						
						
						/*
						  ������ ������ �߻��ߴٸ� �����Լ��� �ִ� Ŭ���̾�Ʈ �� ��� Ŭ���̾�Ʈ�鿡 ���� ������ ��� 
						  �迭���� ���� �����ϴ� Ŭ���̾�Ʈ�� �����ش�. �� ������ �߻��ؼ� �ش� Ŭ���̾�Ʈ�� �����κ���
						   ������ �������ϱ� �翬�� �츮 �����ȿ����� �ش� Ŭ���̾�Ʈ�� ������ ����ٴ�
						  ������ ó���� ���ֵ��� ���ش�. �� Ŭ���̾�Ʈ �迭���� �ش� ������ ���� Ŭ���̾�Ʈ�� �������ִ°�.
						 */
						Server.vector.remove(Client.class);
						socket.close();  //���� Ŭ���� �Լ��� �����ؼ� ������ ���� Ŭ���̾�Ʈ�� ������ �ݴ´�.
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}; 		// end run();
		// ������Ǯ�� �̷��� ������� �ϳ��ǽ�����(�۾���ü)�� ����� �����ְڴٶ�� ��
		Server.executorService.submit(runnable);
	} // end send();
}
