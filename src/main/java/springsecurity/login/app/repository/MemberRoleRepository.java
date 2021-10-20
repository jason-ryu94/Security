package springsecurity.login.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecurity.login.app.entity.MemberRole;

@Repository
public interface MemberRoleRepository extends JpaRepository<MemberRole, String> {
}
