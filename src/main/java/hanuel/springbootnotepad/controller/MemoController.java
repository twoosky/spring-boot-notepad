package hanuel.springbootnotepad.controller;

import hanuel.springbootnotepad.entity.Memo;
import hanuel.springbootnotepad.dto.MemoDto;
import hanuel.springbootnotepad.service.MemoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memos")
public class MemoController {
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public ResponseEntity<Memo> save(@RequestBody MemoDto memoDto) {
        Memo memo = memoService.saveMemo(memoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(memo);
    }

    @PutMapping("/{memoId}")
    public ResponseEntity<Memo> update(@PathVariable Long id, @RequestBody MemoDto memoDto) throws Exception{
        Memo memo = memoService.updateMemo(id, memoDto);
        return ResponseEntity.status(HttpStatus.OK).body(memo);
    }

    @DeleteMapping("/{memoId}")
    public void delete(@PathVariable Long id) throws Exception{
        memoService.deleteMemo(id);
    }

    @GetMapping("/{memold}")
    public ResponseEntity<Memo> detail(@PathVariable Long id) throws Exception{
        Memo memo = memoService.detailMemo(id);
        return ResponseEntity.status(HttpStatus.OK).body(memo);
    }
}
