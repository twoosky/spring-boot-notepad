package hanuel.springbootnotepad.service;

import hanuel.springbootnotepad.dto.*;
import hanuel.springbootnotepad.entity.Memo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import hanuel.springbootnotepad.repository.MemoRepository;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MemoService {

    private final MemoRepository memoRepository;
    private static final Integer PAGE_SIZE = 5;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public CreateResponseDto createMemo(RequestDto requestDto) {
        Memo memo = memoRepository.save(requestDto.toEntity());
        return CreateResponseDto.create(memo);
    }

    public UpdateResponseDto updateMemo(Long id, RequestDto requestDto) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() ->
                        new Exception("don't exist memo!")
                );
        memo.update(requestDto.getTitle(), requestDto.getText());
        return UpdateResponseDto.create(memoRepository.findById(id).get());
    }

    public void deleteMemo(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() ->
                        new Exception("don't exist memo!")
                );
        memoRepository.delete(memo);
    }

    public DetailResponseDto detailMemo(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() ->
                        new Exception("don't exist memo!")
                );
        return DetailResponseDto.create(memo);
    }

    public List<InfoResponseDto> searchMemo(LocalDateTime date, Integer page){
        PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE, Sort.by("createdAt").descending());
        List<Memo> memos = memoRepository.findAll(pageRequest).getContent();
        return memos.stream()
                .map(InfoResponseDto::create)
                .collect(toList());
    }

    // memoRepository.findById(id) null 검사 함수 만들어 사용
    // optional.orElseThrow(); 하면 optional type이 아니라 Memo type으로 반환되나?
    // 메모 정보 검색 구현 !!
    // GET: /memos 구현
    // GET: /memos/{id} 구현 (선택)
    // @RequestBody 필요 없나?
    // HttpStatus code 구현
    // Exception 더 공부해서 구현
    // User Security 구현

}
