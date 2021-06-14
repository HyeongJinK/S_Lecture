package khj.side.board.controller;

import io.swagger.annotations.*;
import khj.side.board.entity.BoardContent;
import khj.side.board.request.BoardContentSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "게시판")
@RequestMapping("/board")
public interface BoardContentController {
    @ApiOperation(value = "게시글 리스트")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardIdx", value = "게시판 번호", required = true, dataType = "Long", paramType = "param"),
            @ApiImplicitParam(name = "searchText", value = "검색할 문자열", dataType = "String", paramType = "param")
    })
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
