package spring.notice.springnotice.notice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.notice.springnotice.notice.NoticeMapper;
import spring.notice.springnotice.notice.NoticeVo;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DomainNoticeService implements NoticeService {

    private final NoticeMapper noticeMapper;

    @Override
    public int create(String title, String content) {
        NoticeVo noticeVo = NoticeVo.createNoticeVo(title, content);
        return noticeMapper.create(noticeVo);
    }

    @Override
    public int update(int noticeId, String title, String content) {
        NoticeVo notice = noticeMapper.getNotice(noticeId);

        notice.update(title, content);

        return noticeMapper.update(notice);
    }

    @Override
    public NoticeVo getNotice(int noticeId) {
        return noticeMapper.getNotice(noticeId);
    }


    @Override
    public List<NoticeVo> getNotices() {
        return noticeMapper.getNotices();
    }
}
