package kaveski.yonathan.todoserver.Task;

import jakarta.validation.Valid;
import kaveski.yonathan.todoserver.List.Lists;
import kaveski.yonathan.todoserver.List.ListsService;
import kaveski.yonathan.todoserver.Task.dto.request.TaskPatchRequestBody;
import kaveski.yonathan.todoserver.Task.dto.request.TaskPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ListsService listsService;

    @GetMapping("/{listsId}")
    public ResponseEntity<List<Task>> searchByListId(@PathVariable Long listsId){
        List<Task> _tasks = taskService.searchByListId(listsId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(_tasks);
    }
    @PostMapping("/")
    public ResponseEntity<Task> save(@RequestBody @Valid TaskPostRequestBody taskDTO){
        Optional<Lists> _lists = listsService.searchById(taskDTO.getListId());
        if(_lists.isEmpty()) ResponseEntity.notFound().build();
        Task response = taskService.save(taskDTO, _lists.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PatchMapping("/{taskID}")
    public ResponseEntity<Task> update(@PathVariable(value = "taskID") Long taskID, @RequestBody @Valid TaskPatchRequestBody taskDTO) {
        Optional<Lists> _lists = Optional.empty();
        if(!isNull(taskDTO.getListId())) _lists = listsService.searchById(taskDTO.getListId());
        Optional<Task> response = taskService.update(taskID, taskDTO, _lists);
        if(response.isPresent())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response.get());
        else
            return ResponseEntity.notFound().build();

    }
}
