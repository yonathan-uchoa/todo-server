package kaveski.yonathan.todoserver.Task;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kaveski.yonathan.todoserver.List.Lists;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "tasks")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Task {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty(message = "Name is required")
    private String name;
    @Value("${description:no description}")
    private String description;
    @Column
    @CreationTimestamp
    private Timestamp creationDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    @NotNull(message = "a task must be inside a list")
    @ManyToOne
    @JoinColumn(name = "lists_id", referencedColumnName = "lists_id", nullable = false)
    @JsonBackReference
    private Lists list;




}
