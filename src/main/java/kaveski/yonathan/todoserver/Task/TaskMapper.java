package kaveski.yonathan.todoserver.Task;

import kaveski.yonathan.todoserver.Task.dto.request.TaskPatchRequestBody;
import kaveski.yonathan.todoserver.Task.dto.request.TaskPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "list", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Task toTask (TaskPostRequestBody taskPostRequestBody);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "list", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    Task toTask (TaskPatchRequestBody taskPatchRequestBody);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "list", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    void update(@MappingTarget Task task, TaskPatchRequestBody taskPatchRequestBody);

}
