package khj.side.board.repository;

import khj.side.board.conf.QuerydslConfiguration;
import khj.side.board.entity.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest(properties = {"spring.jpa.hibernate.ddl-auto:create",
        "spring.jpa.properties.hibernate.dialect:org.hibernate.dialect.H2Dialect"})
@Import(QuerydslConfiguration.class)
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        boardRepository.save(new Board(1L, "테스트 게시판"));
    }

    @Test
    void list() {
        List<Board> list = boardRepository.findAll();

        assertEquals(1, list.size());
    }
}
