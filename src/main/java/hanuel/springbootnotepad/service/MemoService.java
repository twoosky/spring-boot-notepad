package hanuel.springbootnotepad.service;

import hanuel.springbootnotepad.entity.Memo;
import hanuel.springbootnotepad.dto.MemoDto;
import org.springframework.stereotype.Service;
import hanuel.springbootnotepad.repository.MemoRepository;

import java.util.Optional;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo saveMemo(MemoDto memoDto) {
        return memoRepository.save(memoDto.toEntity());
    }

    public Memo updateMemo(Long id, MemoDto memoDto) throws Exception{
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() ->
                        new Exception("don't exist memo!")
                );
        memo.update(memoDto.getTitle(), memoDto.getText());
        return memoRepository.findById(id).get();
    }

    public void deleteMemo(Long id) throws Exception{
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() ->
                        new Exception("don't exist memo!")
                );
        memoRepository.delete(memo);
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
