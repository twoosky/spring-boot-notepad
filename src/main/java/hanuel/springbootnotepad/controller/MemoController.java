package hanuel.springbootnotepad.controller;

import hanuel.springbootnotepad.dto.*;
import hanuel.springbootnotepad.entity.Memo;
import hanuel.springbootnotepad.service.MemoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/memos")
public class MemoController {
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public ResponseEntity<CreateResponseDto> create(@RequestBody RequestDto requestDto) {
        return new ResponseEntity<>(memoService.createMemo(requestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{memoId}")
    public ResponseEntity<UpdateResponseDto> update(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        UpdateResponseDto memo = memoService.updateMemo(id, requestDto);
        return new ResponseEntity<>(memo, HttpStatus.OK);
    }

    @DeleteMapping("/{memoId}")
    public void delete(@PathVariable Long id){
        memoService.deleteMemo(id);
    }

    @GetMapping("/{memoId}")
    public ResponseEntity<DetailResponseDto> detail(@PathVariable Long id) {
        DetailResponseDto memo = memoService.detailMemo(id);
        return new ResponseEntity<>(memo, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<InfoResponseDto>> search(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime date, @RequestParam("page") Integer page) {
        List<InfoResponseDto> memos = memoService.searchMemo(date, page);
        return new ResponseEntity<>(memos, HttpStatus.OK);
    }
}
