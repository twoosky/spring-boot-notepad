package hanuel.springbootnotepad.dto;

import hanuel.springbootnotepad.domain.entity.Memo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MemoDto {
    private String title;
    private String text;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Memo toEntity() {
        Memo build = Memo.builder()
                .title(title)
                .text(text)
                .build();
        return build;
    }

    @Builder
    public MemoDto(String title, String text, LocalDate createdAt, LocalDate updatedAt) {
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
