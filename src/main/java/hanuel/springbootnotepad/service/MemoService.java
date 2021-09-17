package hanuel.springbootnotepad.service;

import hanuel.springbootnotepad.repository.MemoRepository;
import hanuel.springbootnotepad.entity.Memo;
import hanuel.springbootnotepad.dto.MemoDto;
import org.springframework.stereotype.Service;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo saveMemo(MemoDto memoDto) {
        return memoRepository.save(memoDto.toEntity());
    }

    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }






}
