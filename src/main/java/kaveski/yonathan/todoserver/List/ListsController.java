package kaveski.yonathan.todoserver.List;

import jakarta.validation.Valid;
import kaveski.yonathan.todoserver.List.dto.request.ListsPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("lists")
public class ListsController {
    @Autowired
    private ListsService listsService;

    @GetMapping
    public ResponseEntity<Iterable<Lists>> searchAll() { return ResponseEntity.ok(listsService.searchAll()); }
    @GetMapping("/test")
    public ResponseEntity<String> test() { return ResponseEntity.ok("Test OK!"); }

    @GetMapping("/{listsId}")
    public ResponseEntity<?> searchById(@PathVariable Long listsId) {
        Optional<Lists> _lists = listsService.searchById(listsId);
        if(_lists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List id: "+listsId+" not found!");
        }
        return ResponseEntity.ok(_lists.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ListsPostRequestBody listDTO){
        Lists response = listsService.save(listDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{listsId}")
    public ResponseEntity<String> delete(@PathVariable Long listsId) {
        Optional<Lists> _lists = listsService.searchById(listsId);
        if(_lists.isEmpty())
            return ResponseEntity.notFound().build();
        String listName = _lists.get().getName();
        listsService.delete(listsId);
        return ResponseEntity.ok("List: " + listName + "removed successful!");
    }


}
