package hanuel.springbootnotepad.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hanuel.springbootnotepad.entity.Memo;

import java.time.LocalDateTime;

public class DetailResponseDto {
    private Long id;
    private String title;
    private String text;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private LocalDateTime createdAt;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private LocalDateTime updatedAt;

    public DetailResponseDto(Memo memo){
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.text = memo.getText();
        this.createdAt = memo.getCreatedAt();
        this.updatedAt = memo.getUpdatedAt();
    }

    public static DetailResponseDto create(Memo memo){
        return new DetailResponseDto(memo);
    }

}
