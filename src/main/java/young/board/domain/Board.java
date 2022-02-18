package young.board.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Board extends TimeEntity{



    @Id @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Embedded
    private Like like;


    //==생성 메서드==//
    @Builder
    public Board(Long id, String title, String writer, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.like = new Like();

    }

    public Like addLike(){
        like.addLike();
        return like;
    }

}
