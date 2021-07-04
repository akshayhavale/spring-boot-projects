package com.example.v1.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MessageMimicService {

	@Async
	public void sendMessage(String message) throws InterruptedException {

		System.out.println("SENDING MESSAGE >>>>>>>>>>>>>>>>>>");
		// make thread sleep
		Thread.sleep(15000);

		System.out.println("MESSAGE SENT SUCCESSFULLY >>>>>>>>>>>>>>>>>>");
		

	}

}
