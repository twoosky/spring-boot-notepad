package hanuel.springbootnotepad.service;

import hanuel.springbootnotepad.domain.repository.MemoRepository;
import hanuel.springbootnotepad.dto.MemoDto;
import org.springframework.stereotype.Service;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Long saveMemo(MemoDto memoDto) {
        return memoRepository.save(memoDto.toEntity()).getId();
    }

    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }






}
