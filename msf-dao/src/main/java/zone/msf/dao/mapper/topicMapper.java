package zone.msf.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import zone.msf.entity.TopicDto;
import zone.msf.entity.TopicImgDto;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/8.
 */
@Mapper
public interface TopicMapper {

     @Select("select id,title from topic")
     List<TopicDto> getTopicList();

     @Select("select id,topic_id,url,memo1,view_count,createdOn from topic_img where topic_id=#{topic_id}")
     List<TopicImgDto> GetTopicImgsByTopicId(@Param("topic_id")int topic_id);
}
