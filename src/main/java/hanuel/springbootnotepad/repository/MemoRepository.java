package hanuel.springbootnotepad.repository;

import hanuel.springbootnotepad.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    @Override
    Optional<Memo> findById(Long id);

    Page<Memo> findAllByCreatedAtBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
