package khj.side.board.service;

import khj.side.board.entity.Board;
import khj.side.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public List<Board> getList() {
        return boardRepository.findAll();
    }

    @Override
    public Board get(Long boardIdx) {
        return boardRepository.findById(boardIdx).get();
    }

    @Override
    @Transactional
    public void edit(Board board) {
        boardRepository.save(board);
    }

    @Override
    @Transactional
    public void delete(Long boardIdx) {
        boardRepository.deleteById(boardIdx);
    }
}
