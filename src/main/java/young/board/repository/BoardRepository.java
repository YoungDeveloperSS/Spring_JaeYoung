package young.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import young.board.domain.Board;

import java.util.List;

//제목 검색 기능
public interface BoardRepository extends JpaRepository<Board, Long> {

    //키워드 검색을 통해 게시물 검색
    List<Board> findByTitleContaining(String keyword);

}
