package kaveski.yonathan.todoserver.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ListRepositoryTest {
    @Autowired
    private ListsRepository listsRepository;

    @Test
    public void ListsRepository_SaveAll_ReturnSavedList() {
        Lists _lists = Lists.builder()
                .name("My personal list")
                .icon("My icon code")
                .build();

        Lists savedLists = listsRepository.save(_lists);

        Assertions.assertThat(savedLists.getId()).isNotNull();
        Assertions.assertThatObject(savedLists)
                .usingRecursiveAssertion()
                .ignoringFields("id")
                .isEqualTo(_lists);
    }

}
