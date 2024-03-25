package kaveski.yonathan.todoserver.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import kaveski.yonathan.todoserver.Task.Task;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "lists")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Lists {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "lists_id")
    private Long id;
    @NotEmpty(message = "Name is required")
    private String name;
    @Value("${icon:test}")
    private String icon;
    @OneToMany(
            mappedBy= "list",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Task> tasks;
}
