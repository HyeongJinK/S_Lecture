package khj.side.board.controller;

import khj.side.board.entity.BoardContent;
import khj.side.board.request.BoardContentSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
public interface BoardContentController {

    @GetMapping
    ResponseEntity<Page<BoardContent>> getList(BoardContentSearchRequest boardContentSearchRequest);

    @GetMapping("/{boardContentIdx}")
    ResponseEntity<BoardContent> get(@PathVariable Long boardContentIdx);

    @PostMapping
    ResponseEntity<Long> add(BoardContent boardContent);

    @PutMapping
    ResponseEntity<Long> mod(BoardContent boardContent);

    @DeleteMapping("/{boardContentIdx}")
    ResponseEntity<String> del(@PathVariable Long boardContentIdx);
}
