package hanuel.springbootnotepad.controller;

import hanuel.springbootnotepad.dto.*;
import hanuel.springbootnotepad.service.MemoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/memos")
public class MemoController {
    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailResponseDto>> all() {
        return new ResponseEntity<>(memoService.allMemo(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateResponseDto> create(@RequestBody RequestDto requestDto) {
        return new ResponseEntity<>(memoService.createMemo(requestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{memoId}")
    public ResponseEntity<UpdateResponseDto> update(@PathVariable("memoId") Long id, @RequestBody RequestDto requestDto) {
        UpdateResponseDto memo = memoService.updateMemo(id, requestDto);
        return new ResponseEntity<>(memo, HttpStatus.OK);
    }

    @DeleteMapping("/{memoId}")
    public void delete(@PathVariable("memoId") Long id){
        memoService.deleteMemo(id);
    }

    @GetMapping("/{memoId}")
    public ResponseEntity<DetailResponseDto> detail(@PathVariable("memoId") Long id) {
        DetailResponseDto memo = memoService.detailMemo(id);
        return new ResponseEntity<>(memo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InfoResponseDto>> search(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam("page") Integer page) {
        List<InfoResponseDto> memos = memoService.searchMemo(date, page);
        return new ResponseEntity<>(memos, HttpStatus.OK);
    }
}
