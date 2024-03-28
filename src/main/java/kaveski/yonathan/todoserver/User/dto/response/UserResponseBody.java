package kaveski.yonathan.todoserver.User.dto.response;

import kaveski.yonathan.todoserver.List.Lists;

import java.util.List;

public record UserResponseBody(
        Long id,
        String username,
        String loginWith,
        List<Lists> lists
        ) {}
