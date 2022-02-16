package young.board.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //테이블로 매필하지 않고, 자식 클래스(엔티티)에게 매핑정보를 상속하기 위한 어노테이션
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeEntity {

    // 게시물을 생성할 때 자동 생성
    @CreatedDate    //엔티티가 처음 저장될때 생성일을 주입입
    @Column(updatable = false)
    private LocalDateTime createdDate;

    //게시물이 수정될 때 수정일자 생성
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
