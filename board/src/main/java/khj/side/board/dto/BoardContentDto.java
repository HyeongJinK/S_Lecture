package khj.side.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardContentDto {
    Long boardContentIdx;
    String subject;
    String content;
    LocalDateTime createDate;
    LocalDateTime updateDate;
    int readCount;
    boolean isNew;
}
