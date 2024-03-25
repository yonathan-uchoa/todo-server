package kaveski.yonathan.todoserver.Task;

import javax.annotation.processing.Generated;
import kaveski.yonathan.todoserver.Task.dto.request.TaskPatchRequestBody;
import kaveski.yonathan.todoserver.Task.dto.request.TaskPostRequestBody;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-21T13:21:05-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toTask(TaskPostRequestBody taskPostRequestBody) {
        if ( taskPostRequestBody == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.name( taskPostRequestBody.getName() );
        task.description( taskPostRequestBody.getDescription() );
        task.dueDate( taskPostRequestBody.getDueDate() );

        return task.build();
    }

    @Override
    public Task toTask(TaskPatchRequestBody taskPatchRequestBody) {
        if ( taskPatchRequestBody == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.name( taskPatchRequestBody.getName() );
        task.description( taskPatchRequestBody.getDescription() );
        task.dueDate( taskPatchRequestBody.getDueDate() );

        return task.build();
    }

    @Override
    public void update(Task task, TaskPatchRequestBody taskPatchRequestBody) {
        if ( taskPatchRequestBody == null ) {
            return;
        }

        if ( taskPatchRequestBody.getName() != null ) {
            task.setName( taskPatchRequestBody.getName() );
        }
        if ( taskPatchRequestBody.getDescription() != null ) {
            task.setDescription( taskPatchRequestBody.getDescription() );
        }
        if ( taskPatchRequestBody.getDueDate() != null ) {
            task.setDueDate( taskPatchRequestBody.getDueDate() );
        }
    }
}
