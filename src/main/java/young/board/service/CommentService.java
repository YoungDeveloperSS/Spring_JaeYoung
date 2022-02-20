package young.board.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import young.board.domain.Board;
import young.board.domain.Comment;
import young.board.dto.BoardDto;
import young.board.dto.CommentDto;
import young.board.repository.BoardRepository;
import young.board.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CommentService {

    private CommentRepository commentRepository;
    private BoardRepository boardRepository;


    //board를 boardDto로 바꾸는 과정이 필요한데 일단 생략


    //댓글추가
    @Transactional
    public void saveComment(Long boardID, CommentDto commentDto) {

        Board board = boardRepository.findById(boardID).get();
        boardRepository.save(board);
        commentRepository.save(commentDto.toEntity()).getId();
    }

    //댓글 목록
    @Transactional
    public List<CommentDto> getCommentList(){

        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentDtoList = new ArrayList<>();

        for (Comment comment : comments) {
            CommentDto commentDto = this.convertCommentToDto(comment);

            commentDtoList.add(commentDto);
        }

        return commentDtoList;
    }

    //댓글 조회
    public CommentDto getComment(Long id) {

        Comment comment = commentRepository.findById(id).get();

        CommentDto commentDto = this.convertCommentToDto(comment);

        return commentDto;
    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long id){ commentRepository.deleteById(id);}


    private CommentDto convertCommentToDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .comment_content(comment.getComment_content())
                .comment_author(comment.getComment_author())
                .createdDate(comment.getCreatedDate())
                .modifiedDate(comment.getModifiedDate())
                .board(comment.getBoard())
                .build();
    }
}
