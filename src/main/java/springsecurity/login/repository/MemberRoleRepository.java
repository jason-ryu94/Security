package springsecurity.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecurity.login.entity.MemberRole;

@Repository
public interface MemberRoleRepository extends JpaRepository<MemberRole, String> {
}
