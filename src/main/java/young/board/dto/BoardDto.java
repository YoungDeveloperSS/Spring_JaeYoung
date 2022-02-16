package young.board.dto;


import lombok.*;
import young.board.domain.Board;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


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
            createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;

    }
}
