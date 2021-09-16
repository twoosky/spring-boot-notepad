package hanuel.springbootnotepad.controller;

import hanuel.springbootnotepad.dto.MemoDto;
import hanuel.springbootnotepad.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memos")
public class MemoController {
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("")
    public ResponseEntity<MemoDto> save(@RequestBody MemoDto memoDto) {
        memoService.saveMemo(memoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(memoDto);
    }

    @DeleteMapping("/{memoId}")
    public void delete(@PathVariable Long id){
        memoService.deleteMemo(id);
    }

}
