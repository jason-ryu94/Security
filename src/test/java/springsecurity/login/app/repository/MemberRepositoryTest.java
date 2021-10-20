package springsecurity.login.app.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springsecurity.login.app.entity.Member;
import springsecurity.login.app.entity.MemberRole;

import javax.persistence.EntityManager;

import java.util.List;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberRoleRepository memberRoleRepository;

    @Autowired
    EntityManager em;

    @BeforeEach
    public void before() {
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


    }

    @Test
    public void testData() {
        List<Member> members = memberRepository.findAll();

        for(Member m : members) {
            System.out.println("m = " + m);
            System.out.println("m.getRoles() = " + m.getRoles());
        }

        List<MemberRole> all = memberRoleRepository.findAll();
        for (MemberRole r : all) {
            System.out.println("r = " + r);
        }
    }

}