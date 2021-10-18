package springsecurity.login.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecurity.login.entity.Member;
import springsecurity.login.entity.MemberRole;
import springsecurity.login.repository.MemberRepository;
import springsecurity.login.repository.MemberRoleRepository;

import java.util.List;

@Service
@Slf4j
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberRoleRepository memberRoleRepository;

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
}
