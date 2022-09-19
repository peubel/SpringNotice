package spring.notice.springnotice.notice;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    int create(NoticeVo noticeVo);

    int update(NoticeVo noticeVo);

    List<NoticeVo> getNotices();

    NoticeVo getNotice(int noticeId);
}
