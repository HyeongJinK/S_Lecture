package khj.side.board.service;

import khj.side.board.entity.BoardContent;
import khj.side.board.repository.BoardContentRepository;
import khj.side.board.request.BoardContentSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardContentServiceImpl implements BoardContentService {
    private final BoardContentRepository boardContentRepository;

    @Override
    public Page<BoardContent> getList(BoardContentSearchRequest request) {
        return boardContentRepository.findAllBySearch(request);
    }

    @Override
    public BoardContent get(Long boardContentIdx) {
        Optional<BoardContent> optionalBoardContent = boardContentRepository.findById(boardContentIdx);

        if (optionalBoardContent.isPresent()) {
            BoardContent boardContent = optionalBoardContent.get();

            boardContent.read();

            return boardContent;
        }
        return null;
    }

    @Override
    public Long edit(BoardContent boardContent) {
        return boardContentRepository.save(boardContent).getBoardContentIdx();
    }

    @Override
    public void del(Long boardContentIdx) {
        boardContentRepository.deleteById(boardContentIdx);
    }
}
