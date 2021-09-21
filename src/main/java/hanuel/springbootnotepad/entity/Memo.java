package hanuel.springbootnotepad.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Memo(String title, String text, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void update(String title, String text) {
        this.title = title;
        this.text = text;
        this.updatedAt = LocalDateTime.now();
    }
}
