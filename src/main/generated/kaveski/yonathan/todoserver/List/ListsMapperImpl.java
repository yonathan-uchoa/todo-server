package kaveski.yonathan.todoserver.List;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kaveski.yonathan.todoserver.List.dto.request.ListsPostRequestBody;
import kaveski.yonathan.todoserver.List.dto.request.ListsPutRequestBody;
import kaveski.yonathan.todoserver.Task.Task;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T14:05:44-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class ListsMapperImpl implements ListsMapper {

    @Override
    public Lists toLists(ListsPostRequestBody listsPostRequestBody) {
        if ( listsPostRequestBody == null ) {
            return null;
        }

        Lists.ListsBuilder lists = Lists.builder();

        lists.name( listsPostRequestBody.getName() );
        lists.icon( listsPostRequestBody.getIcon() );

        return lists.build();
    }

    @Override
    public void updateLists(ListsPutRequestBody listsPutRequestBody, Lists lists) {
        if ( listsPutRequestBody == null ) {
            return;
        }

        if ( listsPutRequestBody.getName() != null ) {
            lists.setName( listsPutRequestBody.getName() );
        }
        if ( lists.getTasks() != null ) {
            List<Task> list = listsPutRequestBody.getTasks();
            if ( list != null ) {
                lists.getTasks().clear();
                lists.getTasks().addAll( list );
            }
        }
        else {
            List<Task> list = listsPutRequestBody.getTasks();
            if ( list != null ) {
                lists.setTasks( new ArrayList<Task>( list ) );
            }
        }
    }
}
