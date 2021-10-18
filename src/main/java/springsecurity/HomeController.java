package springsecurity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springsecurity.login.service.MemberService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home() {
        log.info("시작~~~~~~~~~~~~~~~~~~~~");
        memberService.tt();
        log.info("끝~~~~~~~~~~~~~~~~~~~~~~~");
        return "home";
    }
}
