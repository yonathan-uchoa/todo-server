package kaveski.yonathan.todoserver.List;

import kaveski.yonathan.todoserver.List.dto.request.ListsPostRequestBody;
import kaveski.yonathan.todoserver.List.dto.request.ListsPutRequestBody;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ListsMapper {

    ListsMapper INSTANCE = Mappers.getMapper(ListsMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    Lists toLists (ListsPostRequestBody listsPostRequestBody);

    @InheritConfiguration(name = "toLists")
    void updateLists(ListsPutRequestBody listsPutRequestBody, @MappingTarget Lists lists);



}
