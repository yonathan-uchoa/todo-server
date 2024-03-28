package kaveski.yonathan.todoserver.User.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserRequestPostBody(
        @NotEmpty @Size(max = 40)
        String username,
        @NotEmpty @Size(min = 8, max = 16)
        String password
) {}
