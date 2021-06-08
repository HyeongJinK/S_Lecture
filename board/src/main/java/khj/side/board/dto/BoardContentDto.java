package khj.side.board.dto;

import khj.side.board.entity.BoardTag;
import lombok.Getter;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BoardContentDto {
    Long boardContentIdx;
    Long userIdx;
    String userName;
    String subject;
    String content;
    LocalDateTime createDate;
    LocalDateTime updateDate;
    int readCount;
    boolean isNew;
}
