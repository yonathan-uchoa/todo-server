package kaveski.yonathan.todoserver.Task.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema
public class TaskPatchRequestBody {
    @Schema(type = "string", example = "string or null")
    @Pattern(regexp= "^(?!\\s*$).+", message = "can be null, but not blank")
    private String name;
    @Schema(type = "string", example = "string or null")
    @Pattern(regexp= "^(?!\\s*$).+", message = "can be null, but not blank")
    private String description;
    private Long listId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
}
