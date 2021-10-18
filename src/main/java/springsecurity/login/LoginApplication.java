package springsecurity.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springsecurity.login.service.MemberService;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoginApplication.class, args);
	}

}
