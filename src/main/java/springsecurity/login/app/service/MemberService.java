package springsecurity.login.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springsecurity.login.app.dto.LoginDto;
import springsecurity.login.app.entity.Member;
import springsecurity.login.app.entity.MemberRole;
import springsecurity.login.app.repository.MemberRepository;
import springsecurity.login.app.repository.MemberRoleRepository;
import springsecurity.login.security.jwt.JwtTokenProvider;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;



    public void tt() {

        log.info("tt ~~~~~~~~~~~~~~~~시작");
        MemberRole role1 = new MemberRole("BASIC");
        MemberRole role2 = new MemberRole("ADMIN");
        MemberRole role3 = new MemberRole("MASTER");

        memberRoleRepository.save(role1);
        memberRoleRepository.save(role2);
        memberRoleRepository.save(role3);

        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        Member member3 = new Member("member3");

        member1.addRole(role1);
        member2.addRole(role2);
        member3.addRole(role3);
        member1.addRole(role2);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        log.info("tt ~~~~~~~~~~~~~~~~끝");
    }
    
    public void tt2() {
        List<Member> members = memberRepository.findAll();
        
        for(Member m : members) {
            System.out.println("m.getRoles() = " + m.getRoles());
        }
    }

    public String login(LoginDto loginDto) {
        Member findMember = memberRepository.findByUserId(loginDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if(!passwordEncoder.matches(loginDto.getUserPassword(), findMember.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        List<String> roleList = findMember.getRoles().stream()
                .map(e -> e.getRoleName())
                .collect(Collectors.toList());

        return jwtTokenProvider.createToken(findMember.getUserId(), roleList);
    }

}
