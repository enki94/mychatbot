package io.devwin.mychatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rivescript.RiveScript;

@RestController
public class restController {

	@Autowired
	private RiveScript bot; 
	
	@PostMapping("/replyMsg")
	public String replyMsg(@RequestParam(name = "message") String message) {
		bot.sortReplies();
		String reply = bot.reply("user", message);
		return reply; 
	}
}
