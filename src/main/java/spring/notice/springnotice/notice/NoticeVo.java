package spring.notice.springnotice.notice;


import lombok.Getter;

@Getter
public class NoticeVo {

    private NoticeVo(String title, String content) {
        this.id = 1;
        this.title = title;
        this.content = content;
    }

    private int id;

    private String title;

    private String content;


    public static NoticeVo createNoticeVo(String title, String content) {
        if (title == null || content == null) throw new IllegalArgumentException();
        if (title.isEmpty() || content.isEmpty() ) throw new IllegalArgumentException();

        return new NoticeVo(title, content);
    }

    ;

    public void update(String title, String content) {
        if (title.isBlank() || content.isBlank()) throw new IllegalArgumentException();

        this.title = title;
        this.content = content;
    }
};


