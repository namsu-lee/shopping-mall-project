package com.shoppingmall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.client.Client;
import com.shoppingmall.task.TransmissionControlProtocol;


@Controller
@RequestMapping(value = "/chat")
public class ChatController {

	//해당 클라이언트 소켓
	@ResponseBody
	@RequestMapping(value = "/ClientSocketOpen", method = RequestMethod.POST)
	public Map<String, Client> Client_Socket_Open() {
		Client client = new Client();
		client.startClient(TransmissionControlProtocol.getIp(), TransmissionControlProtocol.getPort());
		
		Map<String, Client> map = new HashMap<String, Client>();
		map.put("Socket", client);
		return map;
	}
}