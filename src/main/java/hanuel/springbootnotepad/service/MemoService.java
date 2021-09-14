package hanuel.springbootnotepad.service;

import hanuel.springbootnotepad.domain.repository.MemoRepository;
import org.springframework.stereotype.Service;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }





}
