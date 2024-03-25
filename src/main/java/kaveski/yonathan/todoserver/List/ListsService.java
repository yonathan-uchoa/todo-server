package kaveski.yonathan.todoserver.List;

import kaveski.yonathan.todoserver.List.dto.request.ListsPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListsService {
    @Autowired
    private ListsRepository listsRepository;

    Lists save(ListsPostRequestBody listDTO) {
        Lists _lists = ListsMapper.INSTANCE.toLists(listDTO);
        return listsRepository.save(_lists);
    }

    Iterable<Lists> searchAll(){ return listsRepository.findAll(); }

    public Optional<Lists> searchById(Long id) { return listsRepository.findById(id); }

    void delete(Long id) { listsRepository.deleteById(id); }
}
