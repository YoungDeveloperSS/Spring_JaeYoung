package young.board.dto;


import io.swagger.annotations.ApiParam;
import lombok.*;
import young.board.domain.Board;
import young.board.domain.Like;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    @ApiParam(value = "게시물 ID",required = true)
    private Long id;

    @ApiParam(value = "게시물 저자")
    private String writer;

    @ApiParam(value = "게시물 제목")
    private String title;

    @ApiParam(value = "게시물 내용")
    private String content;

    @ApiParam(value = "게시물 생성일")
    private LocalDateTime createdDate;

    @ApiParam(value = "게시물 수정일")
    private LocalDateTime modifiedDate;

    @ApiParam(value = "게시물 좋아요")
    private Like like;


    // dto에서 필요한 엔티티를 빌더패턴을 통해 엔티티로 만듦
    public Board toEntity(){
        Board board = Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return board;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime
            createdDate, LocalDateTime modifiedDate,Like like) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.like =like;

    }
}
