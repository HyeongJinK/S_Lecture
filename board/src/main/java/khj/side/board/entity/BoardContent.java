package khj.side.board.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class BoardContent {
    @Id
    Long boardContentIdx;
    String subject;
    String content;
    LocalDateTime regDate;
    int readCount;
    Long userIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardIdx")
    Board board;

    public void read() {
        this.readCount++;
    }
}
