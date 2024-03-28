package kaveski.yonathan.todoserver.User.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import kaveski.yonathan.todoserver.List.Lists;

import java.util.List;

public record UserRequestPatchBody(
        @Schema(type = "string", example = "string or null")
        @Pattern(regexp= "^(?!\\s*$).+", message = "can be null, but not blank")
        String username,
        @Size(min = 8, max = 16)
        String password,
        @Schema(type = "string", example = "string or null")
        @Pattern(regexp= "^(?!\\s*$).+", message = "can be null, but not blank")
        String loginWith,
        List<Lists> lists
)
{}
