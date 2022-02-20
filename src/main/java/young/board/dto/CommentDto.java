package young.board.dto;


import io.swagger.annotations.ApiParam;
import lombok.*;
import young.board.domain.Board;
import young.board.domain.Comment;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentDto {

    @ApiParam(value = "댓글 ID")
    private Long id;

    @ApiParam(value = "댓글 내용")
    private String comment_content;

    @ApiParam(value = "댓글 저자")
    private String comment_author;

    private Board board;

    @ApiParam(value = "댓글 생성 시기")
    private LocalDateTime createdDate;

    @ApiParam(value = "댓글 수정 시기")
    private LocalDateTime modifiedDate;

    public Comment toEntity(){
        Comment comment = Comment.builder()
                .id(id)
                .comment_content(comment_content)
                .comment_author(comment_author)
                .build();
        return comment;
    }


    @Builder
    public CommentDto(Long id, String comment_content, String comment_author,
                      LocalDateTime createdDate, LocalDateTime modifiedDate, Board board) {

        this.id = id;
        this.comment_content = comment_content;
        this.comment_author = comment_author;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.board = board;

    }



}
