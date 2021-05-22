package khj.side.todo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    Long taskIdx;
    String content;
    Boolean complete;
    LocalDateTime regDate;
    LocalDateTime updateDate;

    @ManyToOne
    Todo todo;
}
