package zone.msf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.msf.dao.mapper.TopicMapper;
import zone.msf.entity.TopicDto;
import zone.msf.entity.TopicImgDto;
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
    public List<TopicDto> getTopicList() {
        List<TopicDto> lst= topicMapper.getTopicList();
        for (TopicDto dto :
                lst) {
            List<TopicImgDto> lstImg= topicMapper.GetTopicImgsByTopicId(dto.getId());
            if (lstImg.size()>0) {
                dto.setCoverImgUrl("/images/"+lstImg.get(0).getUrl());
            }
        }
        return lst;
    }
}
