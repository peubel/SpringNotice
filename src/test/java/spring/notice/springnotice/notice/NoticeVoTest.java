package spring.notice.springnotice.notice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NoticeVoTest {


    @ParameterizedTest
    @NullAndEmptySource
    void 생성_실패_제목_값이_존재하지_않음(String title) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> NoticeVo.createNoticeVo(title, "content"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 생성_실패_본문_값이_존재하지_않음(String content) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> NoticeVo.createNoticeVo("title", content));
    }
}