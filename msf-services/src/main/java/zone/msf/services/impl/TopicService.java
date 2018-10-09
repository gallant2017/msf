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
    public TopicDto getTopicById(int topicId) {
        return topicMapper.getTopicById(topicId);
    }

    @Override
    public List<TopicDto> getTopicList() {
        List<TopicDto> lst= topicMapper.getTopicList();
        for (TopicDto dto :
                lst) {
            List<TopicImgDto> lstImg= topicMapper.GetTopicImgsByTopicId(dto.getId());
            if (lstImg.size()>0) {
                dto.setCoverImgUrl("/images/"+lstImg.get(0).getUrl());
                //dto.setCoverImgUrl("/images/img/11.jpg");
            }
        }
        return lst;
    }

    @Override
    public List<TopicImgDto> GetTopicImgsByTopicId(int topicId) {
        List<TopicImgDto> lst= topicMapper.GetTopicImgsByTopicId(topicId);
        for (TopicImgDto dto
                : lst) {
            dto.setUrl("/images/"+dto.getUrl());
        }
        return lst;
    }
}
