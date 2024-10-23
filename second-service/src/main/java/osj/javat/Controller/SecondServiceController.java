package osj.javat.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/second-service")
public class SecondServiceController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping("/say")
	public String getMethodName() {
		return new String("HI "+serverPort);
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Second service";
	}
	
	@GetMapping("/message")
	public String message(@RequestHeader("second-request") String header) {
		log.info(header);
		return "Welcome to second service";
	}
	
	@GetMapping("/check")
	public String check() {
		return "Hi second service";
	}
}
