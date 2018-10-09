package zone.msf.services;

import zone.msf.entity.TopicDto;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/8.
 */
public interface ITopicService {

    List<TopicDto> getTopicList();
}
