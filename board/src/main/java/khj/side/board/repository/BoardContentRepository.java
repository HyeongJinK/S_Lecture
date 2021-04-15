package khj.side.board.repository;

import khj.side.board.entity.BoardContent;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardContentRepository extends JpaRepository<BoardContent, Long> {
    Page<BoardContent> findByBoardBoardIdx(Long boardIdx);
}
