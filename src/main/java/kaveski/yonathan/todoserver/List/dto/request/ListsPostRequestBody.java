package kaveski.yonathan.todoserver.List.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListsPostRequestBody {
    private String name;
    private String icon;
}
