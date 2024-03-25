package kaveski.yonathan.todoserver.Task.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kaveski.yonathan.todoserver.List.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema
public class TaskPostRequestBody {
    @NotEmpty
    private String name;
    private String description;
    @NotNull
    private Long listId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
}
