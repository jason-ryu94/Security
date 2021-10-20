package springsecurity.login.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * JWT를 생성하고 검증하는 컴포넌트
 */

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private String secretKey = "jasonkey";

    private Long tokenValidTime = 30 * 60 * 1000L;
}
