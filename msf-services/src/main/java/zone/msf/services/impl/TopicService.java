package zone.msf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zone.msf.dao.mapper.PVCountMapper;
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

    @Autowired
    PVCountMapper pvCountMapper;

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
    public List<TopicDto> getPageListByCategoryId(int pageIndex, int pageSize, int categoryId) {

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
        return fixList(lst);
    }

    @Override
    public List<TopicImgDto> getImgsByTopicId(int topicId,boolean isPc) {
        List<TopicImgDto> lst = topicMapper.GetImgsByTopicId(topicId);
        for (TopicImgDto dto
                : lst) {
            if (isPc) {
                dto.setUrl(prefixImg + dto.getUrl().replace(".jpg", "_c.jpg"));
            } else {
                dto.setUrl(prefixImg + dto.getUrl().replace(".jpg", "_m.jpg"));
            }
        }
        return lst;
    }

    @Override
    public List<TopicDto> getHotList() {
        List<TopicDto> lst = topicMapper.GetHotList();
        return fixList(lst);
    }

    @Override
    public void AddPV(String ip, int position) {
        pvCountMapper.AddPV(ip,position);
    }

    @Override
    public void AddCK(String a, String b) {
        pvCountMapper.AddCK(a,b);
    }

    private int ensureCategoryId(int categoryId) {
        int[] arrCategoryId = {0, 1, 2, 3, 4, 5, 6, 7, 8,9,10,11};
        if (Arrays.binarySearch(arrCategoryId, categoryId) > 0) {
            return categoryId;
        }
        return 0;
    }

    private List<TopicDto> fixList(List<TopicDto> lst) {
        for (TopicDto dto :
                lst) {
            TopicImgDto imgObj = topicMapper.GetCoverImgByTopicId(dto.getId());
            if (imgObj != null) {
                dto.setCoverImgUrl(prefixImg + imgObj.getUrl().replace(".jpg", "_m.jpg"));
            }
        }
        return lst;
    }
}
