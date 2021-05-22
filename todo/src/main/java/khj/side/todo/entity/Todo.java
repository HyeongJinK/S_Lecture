package khj.side.todo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Todo {
    @Id
    Long todoIdx;
    String subject;
    LocalDateTime regDate;

    @OneToMany
    List<Task> tasks;

    @OneToMany
    List<Tag> tags;
}
