package spring.notice.springnotice.notice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.notice.springnotice.notice.NoticeMapper;
import spring.notice.springnotice.notice.NoticeVo;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class DomainNoticeServiceTest {

    @Autowired
    NoticeService noticeService;

    @Autowired
    NoticeMapper noticeMapper;

    @Test
    void 게시물_생성() {
        int result = noticeService.create("제목", "콘텐트");

        assertThat(result).isEqualTo(1L);
    }

    @Test
    void 게시물_조회() {
        int result = noticeService.create("제목", "콘텐트");

        List<NoticeVo> noticeList = noticeService.getNotices();

        assertThat(noticeList.get(0).getId()).isEqualTo(1L);
        assertThat(noticeList.get(0).getTitle()).isEqualTo("제목");
        assertThat(noticeList.get(0).getContent()).isEqualTo("콘텐트");
    }

    @Test
    void 게시물_수정() {
        noticeService.create("제목", "콘텐트");

        int noticeId = 1;

        int result = noticeService.update(noticeId, "수정제목", "수정콘텐트");

        NoticeVo findNotice = noticeMapper.getNotice(noticeId);

        assertThat(result).isEqualTo(1);
        assertThat(findNotice.getId()).isEqualTo(noticeId);
        assertThat(findNotice.getTitle()).isEqualTo("수정제목");
        assertThat(findNotice.getContent()).isEqualTo("수정콘텐트");
    }
}