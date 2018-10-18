package zone.msf.services;

import zone.msf.entity.TopicDto;
import zone.msf.entity.TopicImgDto;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/8.
 */
public interface ITopicService {

    /**
     * 获取首页列表
     * @return
     */
    List<TopicDto> getIndexTopicList(int pageIndex,int pageSize);

    TopicDto getObjById(int topicId);

//    List<TopicDto> getList();

    List<TopicDto> getPageListByCategoryId(int pageIndex, int pageSize, int categoryId, boolean isPc);

    List<TopicImgDto> getImgsByTopicId(int topicId);

    List<TopicDto> getHotList();
}
