package khj.side.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    Long boardIdx;
    String name;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    List<BoardContent> boardContentList;
}
