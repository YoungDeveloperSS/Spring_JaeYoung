package young.board.domain;


import lombok.Getter;

@Getter
public enum Category {

    CHAT("잡담"), STUDY("공부"), INFO("정보");

    private String category;

    Category(String category) {
        this.category = category;
    }
}
