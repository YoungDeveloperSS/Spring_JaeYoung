package young.board.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import young.board.domain.Board;
import young.board.domain.Like;
import young.board.repository.BoardRepository;

@AllArgsConstructor
@Service
public class LikeService {

    private BoardRepository boardRepository;


    @Transactional
    public Like addLike(Long id) {
        Board board = boardRepository.findById(id).get();

        //dto 로 변환이 필요할까? 둘다 테스트 해보고 둘다 되면 dto로
        return board.addLike();

    }

}
