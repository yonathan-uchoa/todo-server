package kaveski.yonathan.todoserver.Task;

import kaveski.yonathan.todoserver.List.Lists;
import kaveski.yonathan.todoserver.Task.dto.request.TaskPatchRequestBody;
import kaveski.yonathan.todoserver.Task.dto.request.TaskPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public Iterable<Task> searchAll() { return taskRepository.findAll(); }

    List<Task> searchByListId(Long listId) { return taskRepository.findByListId(listId); }
    public Optional<Task> searchById(Long id) { return taskRepository.findById(id); }
    public Task save(TaskPostRequestBody taskDTO, Lists lists){
        Task _task = TaskMapper.INSTANCE.toTask(taskDTO);
        _task.setList(lists);
        return taskRepository.save(_task);
    }
    public Optional<Task> update(Long taskID, TaskPatchRequestBody taskDTO, Optional<Lists> lists){
        Optional<Task> task = searchById(taskID);
        if(task.isEmpty()) return task;
        Task _task = task.get();

//        String _name = taskDTO.getName();
//        String _description = taskDTO.getDescription();
//        Date _dueDate = taskDTO.getDueDate();
//
//        if(!isNull(_name)) _task.setName(_name);
//        if(!isNull(_description)) _task.setDescription(_description);
//        if(!isNull(_dueDate)) _task.setDueDate(_dueDate);
        TaskMapper.INSTANCE.update(_task, taskDTO);
        lists.ifPresent(_task::setList);

        return Optional.of(taskRepository.save(_task));
    }
    public void delete(Long id) { taskRepository.deleteById(id); }
}
