package khj.side.board.dto;

import java.time.LocalDateTime;

public class BoardContentDto {
    Long boardContentIdx;
    String subject;
    String content;
    LocalDateTime createDate;
    LocalDateTime updateDate;
    int readCount;
    boolean isNew;
}
