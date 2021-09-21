package hanuel.springbootnotepad.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hanuel.springbootnotepad.entity.Memo;

import java.time.LocalDateTime;

public class SearchResponseDto {
    private Long id;
    private String title;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private LocalDateTime updatedAt;

    public SearchResponseDto(Memo memo){
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.createdAt = memo.getCreatedAt();
        this.updatedAt = memo.getUpdatedAt();
    }

    public static SearchResponseDto create(Memo memo){
        return new SearchResponseDto(memo);
    }
}
