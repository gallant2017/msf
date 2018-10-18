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

//    @Override
//    public List<TopicDto> getList() {
//        List<TopicDto> lst = topicMapper.getList();
//        return fixList(lst);
//    }

    @Override
    public List<TopicDto> getPageListByCategoryId(int pageIndex, int pageSize, int categoryId, boolean isPc) {

        //pageSize最大设置为20
        if (pageSize > 20) {
            pageSize = 10;
        }

        int offset = (pageIndex - 1) * pageSize;
        categoryId = ensureCategoryId(categoryId);
        List<TopicDto> lst;
        if (categoryId == 0) {
            lst = topicMapper.getPageList(offset, pageSize);
        } else if (categoryId == 11) {
            lst = topicMapper.getOldimeyPageList(offset, pageSize);
        } else if (categoryId == 9) {
            lst = topicMapper.getLatestPageList(offset, pageSize);
            //推荐频道下 先显示少妇类别
        } else if (categoryId == 10) {
            lst = topicMapper.getPageListByCategoryId(offset, pageSize, 2);
        } else {
            lst = topicMapper.getPageListByCategoryId(offset, pageSize, categoryId);
        }
        return fixList(lst, isPc);
    }

    @Override
    public List<TopicImgDto> getImgsByTopicId(int topicId) {
        List<TopicImgDto> lst = topicMapper.GetImgsByTopicId(topicId);
        for (TopicImgDto dto
                : lst) {
            dto.setUrl(prefixImg + dto.getUrl().replace(".jpg","_m.jpg"));
            //dto.setUrl(prefixImg + dto.getUrl());
            dto.setUrl(prefixImg + "1.jpg");

        }
        return lst;
    }

    @Override
    public List<TopicDto> getHotList() {
        List<TopicDto> lst = topicMapper.GetHotList();
        return fixList(lst,false);
    }

    private int ensureCategoryId(int categoryId) {
        int[] arrCategoryId = {0, 1, 2, 3, 4, 5, 6, 7, 8,9,10,11};
        if (Arrays.binarySearch(arrCategoryId, categoryId) > 0) {
            return categoryId;
        }
        return 0;
    }

    private List<TopicDto> fixList(List<TopicDto> lst,boolean isPc) {
        for (TopicDto dto :
                lst) {
            List<TopicImgDto> lstImg = topicMapper.GetImgsByTopicId(dto.getId());
            if (lstImg.size() > 0) {
                if (isPc) {
                    dto.setCoverImgUrl(prefixImg + lstImg.get(0).getUrl().replace(".jpg","_c.jpg"));
                } else {
                    dto.setCoverImgUrl(prefixImg + lstImg.get(0).getUrl().replace(".jpg","_m.jpg"));
                }
                //dto.setCoverImgUrl(prefixImg + "1.jpg");
            }
        }
        return lst;
    }
}
