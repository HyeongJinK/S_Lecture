package khj.side.todo.repository;

import khj.side.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
}
