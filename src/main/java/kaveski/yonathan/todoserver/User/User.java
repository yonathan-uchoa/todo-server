package kaveski.yonathan.todoserver.User;

import jakarta.persistence.*;
import kaveski.yonathan.todoserver.List.Lists;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String roles;
    private String loginWith;
    @OneToMany(
           cascade = CascadeType.ALL,
           fetch = FetchType.LAZY
    )
    private List<Lists> lists;

    public User(String username, String password, String roles, String loginWith, List<Lists> lists) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        this.username = username;
        this.password = bcrypt.encode(password);
        this.roles = roles;
        this.loginWith = loginWith;
        this.lists = lists;
    }
    public void setPassword(String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        this.password = bcrypt.encode(password);
    }
}
