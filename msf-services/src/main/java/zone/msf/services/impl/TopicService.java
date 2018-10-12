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
    public List<TopicDto> getIndexTopicList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public TopicDto getObjById(int topicId) {
        return topicMapper.getObjById(topicId);
    }

    @Override
    public List<TopicDto> getList() {
        List<TopicDto> lst= topicMapper.getList();
        return fixList(lst);
    }

    @Override
    public List<TopicDto> getPageList(int pageIndex, int pageSize) {
        int offset = (pageIndex - 1) * pageSize;
        List<TopicDto> lst= topicMapper.getPageList(offset,pageSize);
        return fixList(lst);
    }

    @Override
    public List<TopicImgDto> getImgsByTopicId(int topicId) {
        List<TopicImgDto> lst= topicMapper.GetImgsByTopicId(topicId);
        for (TopicImgDto dto
                : lst) {
            dto.setUrl("/images/"+dto.getUrl());
            //dto.setMemo1("test");
            //dto.setUrl("/images/img/11.jpg");

        }
        return lst;
    }

    private List<TopicDto> fixList(List<TopicDto> lst){
        for (TopicDto dto :
                lst) {
            List<TopicImgDto> lstImg= topicMapper.GetImgsByTopicId(dto.getId());
            if (lstImg.size()>0) {
                dto.setCoverImgUrl("/images/"+lstImg.get(0).getUrl());
                //dto.setTitle("test");
                //dto.setCoverImgUrl("/images/img/11.jpg");
            }
        }
        return lst;
    }
}
