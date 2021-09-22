package hanuel.springbootnotepad.service;

import hanuel.springbootnotepad.dto.*;
import hanuel.springbootnotepad.entity.Memo;
import hanuel.springbootnotepad.exception.MemoNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import hanuel.springbootnotepad.repository.MemoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
                .orElseThrow(MemoNotFoundException::new);
        memo.update(requestDto.getTitle(), requestDto.getText());
        memoRepository.save(memo);
        return UpdateResponseDto.create(memo);
    }

    public void deleteMemo(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(MemoNotFoundException::new);
        memoRepository.delete(memo);
    }

    public DetailResponseDto detailMemo(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(MemoNotFoundException::new);
        return DetailResponseDto.create(memo);
    }

    public List<InfoResponseDto> searchMemo(LocalDate date, Integer page){
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = LocalDateTime.of(date, LocalTime.of(23, 59, 59));

        PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE, Sort.by("createdAt").descending());
        List<Memo> memos = memoRepository.findAllByCreatedAtBetween(start, end, pageRequest).getContent();
        if(memos.isEmpty()) throw new MemoNotFoundException();

        return memos.stream()
                .map(InfoResponseDto::create)
                .collect(toList());
    }

    public List<DetailResponseDto> allMemo() {
        List<Memo> memos = memoRepository.findAll();
        if(memos.isEmpty()) throw new MemoNotFoundException();

        return memos.stream()
                .map(DetailResponseDto::create)
                .collect(toList());
    }
}
