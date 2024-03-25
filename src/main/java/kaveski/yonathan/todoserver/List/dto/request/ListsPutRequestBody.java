package kaveski.yonathan.todoserver.List.dto.request;

import kaveski.yonathan.todoserver.Task.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListsPutRequestBody {
    private String name;
    private List<Task> tasks;
}
