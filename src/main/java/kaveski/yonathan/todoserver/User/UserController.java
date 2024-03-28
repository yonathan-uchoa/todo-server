package kaveski.yonathan.todoserver.User;

import jakarta.validation.Valid;
import kaveski.yonathan.todoserver.User.dto.request.UserRequestPostBody;
import kaveski.yonathan.todoserver.User.dto.response.UserResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userID}")
    public ResponseEntity<?> searchById (@PathVariable(value = "userID") Long userID){
        Optional<UserResponseBody> userDTO = userService.searchById(userID);
        if(userDTO.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("User with id: %d, not found!", userID));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDTO.get());
    }

    @PostMapping
    public ResponseEntity<UserResponseBody> save(@RequestBody @Valid UserRequestPostBody userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDTO));
    }
}
