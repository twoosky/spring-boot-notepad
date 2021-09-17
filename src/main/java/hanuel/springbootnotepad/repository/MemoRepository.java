package hanuel.springbootnotepad.repository;

import hanuel.springbootnotepad.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    @Override
    Optional<Memo> findById(Long id);
}
