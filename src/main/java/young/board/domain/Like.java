package young.board.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Like {

    private Integer likeCount = 0;

    public void addLike(){
        if (this.likeCount >= 1) {
            throw new IllegalStateException("이미 좋아요를 눌렀습니다.");
        }
        likeCount += 1;
    }

}
