package springsecurity.login.app.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserDetail와 Entity를 같은 클래스에서 관리한다.
 */

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "userId")
@ToString(of = {"id", "username", "age"})
public class Member implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;

    private String userEmail;

    private String userId;

    private String userPassword;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "member_role_mapping",
                joinColumns = @JoinColumn(name = "id"),
                inverseJoinColumns = @JoinColumn(name = "rno"))
    private List<MemberRole> roles = new ArrayList<>();

    @CreationTimestamp
    private Date registerDate;

    @UpdateTimestamp
    private Date updateDate;

    public Member(String username, int age, String userEmail, String userId, String userPassword) {
        this.username = username;
        this.age = age;
        this.userEmail = userEmail;
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public Member() {
    }

    public Member(String username) {
        this.username = username;
    }

    public void addRole(MemberRole role) {
        this.roles.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roleList = this.roles.stream()
                .map(e -> e.getRoleName())
                .collect(Collectors.toList());

        return roleList.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
