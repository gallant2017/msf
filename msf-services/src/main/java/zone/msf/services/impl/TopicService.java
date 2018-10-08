package zone.msf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.msf.dao.mapper.TopicMapper;
import zone.msf.services.ITopicService;

/**
 * Created by huangjunhao on 18/10/8.
 */
@Service
public class TopicService implements ITopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public String test() {
        return topicMapper.test();
    }
}
