package osj.javat.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstServiceController {
	
	private final MessageManager messageManager = new MessageManager();
	
	@GetMapping("/{name}")
	public String hello(@PathVariable String name) {
		return messageManager.hello(name);
	}
	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping("/say")
	public String getMethodName() {
		return new String("HI "+serverPort);
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to First service";
	}
	
	@GetMapping("/message")
	public String message(@RequestHeader("first-request") String header) {
		log.info(header);
		return "Welcome to first service";
	}
	
	@GetMapping("/check")
	public String check(HttpServletRequest request) {
		log.info("Server port = {}", request.getServerPort());
		return String.format("This is a message from First Service on PORT");
	}
}
