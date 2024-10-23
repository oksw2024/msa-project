package osj.javat.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class MessageManager {

	@Value("${message.greeting}")
	public String greeting;

	@Value("${message.honorific}")
	public String honorific;

	@Value("${message.secret}")
	public String secret;

	public String hello(String name) {
		return greeting + ", " + name + honorific + " " +
			"secret은 다음과 같습니다. : " + secret;
	}

}
