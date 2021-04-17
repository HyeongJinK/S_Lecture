package khj.side.board.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import khj.side.board.entity.BoardContent;
import khj.side.board.entity.QBoard;
import khj.side.board.entity.QBoardContent;
import khj.side.board.repository.custom.BoardContentCustomRepository;
import khj.side.board.request.BoardContentSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

@RequiredArgsConstructor
public class BoardContentRepositoryImpl implements BoardContentCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<BoardContent> findAllBySearch(BoardContentSearchRequest request) {
        QBoard board = QBoard.board;
        QBoardContent boardContent = QBoardContent.boardContent;

        BooleanBuilder search = new BooleanBuilder();

        if (request.getSearchText() != "") {
            search.and(boardContent.content.contains(request.getSearchText()))
                    .and(boardContent.subject.contains(request.getSearchText()));
        }

        QueryResults<BoardContent> results = queryFactory.selectFrom(boardContent)
                .join(board)
                .where(search.and(board.boardIdx.eq(request.getBoardIdx())))
                .fetchResults();

        return new PageImpl<>(results.getResults());
    }
}
