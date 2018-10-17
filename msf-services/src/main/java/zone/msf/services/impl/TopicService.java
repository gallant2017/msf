package zone.msf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zone.msf.dao.mapper.TopicMapper;
import zone.msf.entity.TopicDto;
import zone.msf.entity.TopicImgDto;
import zone.msf.services.ITopicService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by huangjunhao on 18/10/8.
 */
@Service
public class TopicService implements ITopicService {


    @Value("${keyvalue.prefix-img}")
    private String prefixImg;

    @Autowired
    TopicMapper topicMapper;


    @Override
    public List<TopicDto> getIndexTopicList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public TopicDto getObjById(int topicId) {
        topicMapper.AddViewCount(topicId);
        return topicMapper.getObjById(topicId);
    }

    @Override
    public List<TopicDto> getList() {
        List<TopicDto> lst = topicMapper.getList();
        return fixList(lst);
    }

    @Override
    public List<TopicDto> getPageList(int pageIndex, int pageSize) {
        int offset = (pageIndex - 1) * pageSize;
        List<TopicDto> lst = topicMapper.getPageList(offset, pageSize);
        return fixList(lst);
    }

    @Override
    public List<TopicDto> getPageListByCategoryId(int pageIndex, int pageSize, int categoryId) {
        int offset = (pageIndex - 1) * pageSize;
        categoryId = ensureCategoryId(categoryId);
        List<TopicDto> lst = topicMapper.getPageListByCategoryId(offset, pageSize, categoryId);
        return fixList(lst);
    }

    @Override
    public List<TopicImgDto> getImgsByTopicId(int topicId) {
        List<TopicImgDto> lst = topicMapper.GetImgsByTopicId(topicId);
        for (TopicImgDto dto
                : lst) {
            dto.setUrl(prefixImg + dto.getUrl().replace(".jpg","_m.jpg"));
        }
        return lst;
    }

    private int ensureCategoryId(int categoryId) {
        int[] arrCategoryId = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        if (Arrays.binarySearch(arrCategoryId, categoryId) > 0) {
            return categoryId;
        }
        return 0;
    }

    private List<TopicDto> fixList(List<TopicDto> lst) {
        for (TopicDto dto :
                lst) {
            List<TopicImgDto> lstImg = topicMapper.GetImgsByTopicId(dto.getId());
            if (lstImg.size() > 0) {
                dto.setCoverImgUrl(prefixImg + lstImg.get(0).getUrl().replace(".jpg","_m.jpg"));
            }
        }
        return lst;
    }
}
