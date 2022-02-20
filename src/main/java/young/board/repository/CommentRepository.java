package young.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import young.board.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
