package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Example {
	@RequestMapping("/heartbeat")
	@ResponseBody
	public String hello() {
		return "Spring Boot is up.";
	}

	@RequestMapping("/error")
	@ResponseBody
	public String errorMessage() {
		return "ERROR! Check the logs.";
	}
}