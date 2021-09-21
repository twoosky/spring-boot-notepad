package hanuel.springbootnotepad.dto;

import hanuel.springbootnotepad.entity.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestDto {
    private String title;
    private String text;

    public Memo toEntity() {
        return Memo.builder()
                .title(title)
                .text(text)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
