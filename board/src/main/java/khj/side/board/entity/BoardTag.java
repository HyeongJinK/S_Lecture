package khj.side.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardTag {
    Long idx;
    Long boardContentIdx;
    String name;
}
