package khj.side.board.repository.custom;

import khj.side.board.entity.BoardContent;
import khj.side.board.request.BoardContentSearchRequest;
import org.springframework.data.domain.Page;

public interface BoardContentCustomRepository {
    Page<BoardContent> findAllBySearch(BoardContentSearchRequest request);
}
