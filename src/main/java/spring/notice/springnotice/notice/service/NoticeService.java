package spring.notice.springnotice.notice.service;

import spring.notice.springnotice.notice.NoticeVo;

import java.util.List;

public interface NoticeService {

    int create(String title, String content);

    int update(int noticeId, String title,String content);

    NoticeVo getNotice(int noticeId);

    List<NoticeVo> getNotices();
}
