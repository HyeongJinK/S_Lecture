package khj.side.board.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class BoardContent {
    @Id
    Long boardContentIdx;
    String subject;
    String content;
    @CreationTimestamp
    LocalDateTime createDate;
    @UpdateTimestamp
    LocalDateTime updateDate;
    int readCount;
    Long userIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardIdx")
    Board board;

    public void read() {
        this.readCount++;
    }
}
