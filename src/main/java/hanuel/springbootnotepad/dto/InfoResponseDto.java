package hanuel.springbootnotepad.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hanuel.springbootnotepad.entity.Memo;

import java.time.LocalDateTime;

public class InfoResponseDto {
    private Long id;
    private String title;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private LocalDateTime updatedAt;

    public InfoResponseDto(Memo memo){
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.createdAt = memo.getCreatedAt();
        this.updatedAt = memo.getUpdatedAt();
    }

    public static InfoResponseDto create(Memo memo){
        return new InfoResponseDto(memo);
    }
}
