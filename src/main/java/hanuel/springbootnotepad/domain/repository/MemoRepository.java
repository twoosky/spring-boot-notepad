package hanuel.springbootnotepad.domain.repository;

import hanuel.springbootnotepad.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
