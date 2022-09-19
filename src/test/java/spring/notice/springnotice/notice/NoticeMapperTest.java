package spring.notice.springnotice.notice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@SpringBootTest
class NoticeMapperTest {

    @Autowired
    private NoticeMapper noticeMapper;

    @Test
    void 게시글_조회() {
        NoticeVo noticeVo = NoticeVo.createNoticeVo("title", "content");

        noticeMapper.create(noticeVo);

        NoticeVo findNotice = noticeMapper.getNotice(1);

        assertThat(findNotice.getId()).isNotNull();
        assertThat(findNotice.getTitle()).isEqualTo("title");
        assertThat(findNotice.getContent()).isEqualTo("content");
    }
}