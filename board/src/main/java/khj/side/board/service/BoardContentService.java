package khj.side.board.service;

import khj.side.board.entity.BoardContent;
import org.springframework.data.domain.Page;

public interface BoardContentService {
    /**
     * 게시판 리스트
     * */
    Page<BoardContent> getList(Long boardIdx);
    /**
     * 상세 조회
     * */
    BoardContent get(Long boardContentIdx);
    /**
     * 저장
     * */
    Long edit(BoardContent boardContent);
    /**
     * 삭제
     * */
    void del(Long boardContentIdx);
}
