package hanuel.springbootnotepad.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hanuel.springbootnotepad.entity.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InfoResponseDto {
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private Long id;
    private String title;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone="Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone="Asia/Seoul")
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
