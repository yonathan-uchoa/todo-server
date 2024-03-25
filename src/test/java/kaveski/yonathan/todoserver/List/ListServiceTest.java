package kaveski.yonathan.todoserver.List;

import kaveski.yonathan.todoserver.List.dto.request.ListsPostRequestBody;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListServiceTest {
    @Mock
    private ListsRepository listsRepository;

    @InjectMocks
    private ListsService listsService;

    @Test
    public void ListService_CreateList_ReturnList() {
        Lists lists = Lists.builder()
                .name("my list")
                .icon("icon code")
                .build();

        ListsPostRequestBody listsDTO = ListsPostRequestBody.builder()
                .name("my list")
                .icon("icon code")
                .build();

        when(listsRepository.save(Mockito.any(Lists.class)))
                .thenReturn(lists);

        Lists savedList = listsService.save(listsDTO);

        Assertions.assertThatObject(savedList)
                .usingRecursiveAssertion()
                .isEqualTo(lists);
    }

}
