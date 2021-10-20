package springsecurity.login.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecurity.login.app.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
