package khj.side.board.request;

import lombok.Getter;

@Getter
public class BoardContentSearchRequest {
    Long boardIdx;
    String searchText;
}
