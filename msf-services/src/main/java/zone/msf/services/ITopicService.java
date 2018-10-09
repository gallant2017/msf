package zone.msf.services;

import zone.msf.entity.TopicDto;
import zone.msf.entity.TopicImgDto;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/8.
 */
public interface ITopicService {

    TopicDto getTopicById(int topicId);

    List<TopicDto> getTopicList();

    List<TopicImgDto> GetTopicImgsByTopicId(int topicId);
}
