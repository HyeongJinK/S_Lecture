package khj.side.board.controller;

import khj.side.board.entity.BoardContent;
import khj.side.board.request.BoardContentSearchRequest;
import khj.side.board.service.BoardContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardContentControllerImpl implements BoardContentController {
    private final BoardContentService boardContentService;

    @Override
    public ResponseEntity<Page<BoardContent>> getList(BoardContentSearchRequest boardContentSearchRequest) {
        return ResponseEntity.ok(boardContentService.getList(boardContentSearchRequest));
    }

    @Override
    public ResponseEntity<BoardContent> get(Long boardContentIdx) {
        return ResponseEntity.ok(boardContentService.get(boardContentIdx));
    }

    @Override
    public ResponseEntity<Long> add(BoardContent boardContent) {
        return ResponseEntity.ok(boardContentService.edit(boardContent));
    }

    @Override
    public ResponseEntity<Long> mod(BoardContent boardContent) {
        return ResponseEntity.ok(boardContentService.edit(boardContent));
    }

    @Override
    public ResponseEntity<String> del(Long boardContentIdx) {
        boardContentService.del(boardContentIdx);
        return ResponseEntity.ok("success");
    }
}
