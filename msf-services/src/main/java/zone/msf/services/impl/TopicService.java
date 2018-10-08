package zone.msf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.msf.dao.mapper.TopicMapper;
import zone.msf.entity.TopicDto;
import zone.msf.services.ITopicService;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/8.
 */
@Service
public class TopicService implements ITopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public List<TopicDto> test() {
        return topicMapper.test();
    }
}
