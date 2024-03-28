package kaveski.yonathan.todoserver.User;

import kaveski.yonathan.todoserver.User.dto.request.UserRequestPatchBody;
import kaveski.yonathan.todoserver.User.dto.request.UserRequestPostBody;
import kaveski.yonathan.todoserver.User.dto.response.UserResponseBody;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserResponseBody toDto(User user);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loginWith", ignore = true)
    @Mapping(target = "lists", ignore = true)
    @Mapping(target = "password", qualifiedByName = "encryptPassword")
    User toUser(UserRequestPostBody userRequestPostBody);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    void update(@MappingTarget User user, UserRequestPatchBody userRequestPatchBody);

    @Named("encryptPassword")
    default String encryptPassword(String pass){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode(pass);
    }

}
