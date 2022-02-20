package young.board.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Board extends TimeEntity{



    @Id @GeneratedValue
    @Column(name = "board_id")
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

    @JsonIgnoreProperties({"board"})
    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    //==생성 메서드==//
    @Builder
    public Board(Long id, String title, String writer, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.like = new Like();
        this.commentList = new ArrayList<>();

    }

    public Like addLike(){
        like.addLike();
        return like;
    }

}
