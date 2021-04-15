package khj.side.board.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Board {
    @Id
    Long boardIdx;
    String name;
}
