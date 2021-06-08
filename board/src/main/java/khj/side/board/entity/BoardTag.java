package khj.side.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class BoardTag {
    @Id
    @GeneratedValue
    Long boardTagIdx;
    String name;
}
