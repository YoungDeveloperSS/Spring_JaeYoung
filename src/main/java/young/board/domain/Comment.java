package young.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import young.board.dto.BoardDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends TimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String comment_content;

    private String comment_author;

    //다대일 단방향 관계
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    //==생성 메서드==//
    @Builder
    public Comment(Long id,String comment_content,String comment_author){
        this.id = id;
        this.comment_content = comment_content;
        this.comment_author = comment_author;
        this.board = new Board();
    }



}
