package young.board.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import young.board.domain.Board;
import young.board.dto.BoardDto;
import young.board.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class BoardService {

    private BoardRepository boardRepository;

    //게시글 추가
    @Transactional
    public Long savePost(BoardDto boardDto) {

        return boardRepository.save(boardDto.toEntity()).getId();
    }


    //게시글 목록 조회
    @Transactional(readOnly = true)
    public List<BoardDto> getBoardlist(){
        //Controller 와 Service 간의 데이터 전달을 dto 객체로 하므로 Repository에서 가져온 엔티티를 반복문을 통해 dto로 변환
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board board : boards) {

            BoardDto boardDto = this.convertEntityToDto(board);

            boardDtoList.add(boardDto);

        }
        return boardDtoList;
    }

    //게시글 조회
    @Transactional(readOnly = true)
    public BoardDto getPost(Long id) {

        //게시글의 엔티티 내용을 조회
        Board board = boardRepository.findById(id).get();

        BoardDto boardDto = this.convertEntityToDto(board);

        return boardDto;
    }

    //게시글 삭제
    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

    //게시글 검색
    @Transactional(readOnly = true)
    public List<BoardDto> searchPosts(String keyword) {
        List<Board> boards = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        if(boards.isEmpty()) return boardDtoList; //예외처리 추가

        for (Board board : boards) {

            boardDtoList.add(this.convertEntityToDto(board));

        }
        return boardDtoList;

    }

    //Entity를 Dto로 변환하는 작업을 함수 처리
    private BoardDto convertEntityToDto(Board board) {
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdDate(board.getCreatedDate())
                .like(board.getLike())
                .commentList(board.getCommentList())
                .build();
    }

}
