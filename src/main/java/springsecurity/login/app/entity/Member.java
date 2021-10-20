package springsecurity.login.app.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "userId")
@ToString(of = {"id", "username", "age"})
public class Member {

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
}
