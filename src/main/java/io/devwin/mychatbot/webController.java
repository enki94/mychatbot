package io.devwin.mychatbot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class webController {

	@GetMapping("index.do")
	public String index() {
		return "index";
	}
}
