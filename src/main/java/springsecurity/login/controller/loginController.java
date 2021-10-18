package springsecurity.login.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import springsecurity.login.dto.LoginForm;
import springsecurity.login.service.MemberService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class loginController {

    private final MemberService memberService;
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        memberService.tt();
        memberService.tt2();
        return "login/loginForm";
    }

}
