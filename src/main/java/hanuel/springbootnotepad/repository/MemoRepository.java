package hanuel.springbootnotepad.repository;

import hanuel.springbootnotepad.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
