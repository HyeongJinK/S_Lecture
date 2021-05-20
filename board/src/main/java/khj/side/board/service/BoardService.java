package khj.side.board.service;

import khj.side.board.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> getList();
    Board get(Long boardIdx);
    void edit(Board board);
    void delete(Long boardIdx);
}
