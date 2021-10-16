package springsecurity.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecurity.login.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
