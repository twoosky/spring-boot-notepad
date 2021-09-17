package hanuel.springbootnotepad.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import hanuel.springbootnotepad.entity.Memo;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MemoDto {
    private String title;
    private String text;

    public Memo toEntity() {
        Memo build = Memo.builder()
                .title(title)
                .text(text)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return build;
    }

    @Builder
    public MemoDto(String title, String text, LocalDate createdAt, LocalDate updatedAt) {
        this.title = title;
        this.text = text;
    }
}
