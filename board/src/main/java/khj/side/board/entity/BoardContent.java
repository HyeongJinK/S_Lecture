package khj.side.board.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
public class BoardContent {
    @Id
    @GeneratedValue
    Long boardContentIdx;
    Long userIdx;
    String userName;
    String subject;
    String content;
    @CreationTimestamp
    LocalDateTime createDate;
    @UpdateTimestamp
    LocalDateTime updateDate;
    int readCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardIdx")
    Board board;

    @OneToMany
    @JoinColumn(name = "boardContentIdx")
    List<BoardTag> boardTagList;

    public void read() {
        this.readCount++;
    }
}
