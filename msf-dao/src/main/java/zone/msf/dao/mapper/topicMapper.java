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

     @Select("select id,title,createdOn from topic where id=#{topic_id}")
     TopicDto getObjById(@Param("topic_id")int topic_id);

     @Select("select id,title,createdOn from topic")
     List<TopicDto> getList();

     @Select("select id,title,category_id,createdOn from topic where is_show_index=1 and is_del=0 " +
             " and id<=(select id from topic where is_show_index=1 and is_del=0 order by id desc limit #{offset},1) " +
             " order by id desc limit #{pageSize}")
     List<TopicDto> getPageList(@Param("offset")int offset,@Param("pageSize")int pageSize);

     @Select("select id,topic_id,url,memo1,view_count,createdOn from topic_img where topic_id=#{topic_id}")
     List<TopicImgDto> GetImgsByTopicId(@Param("topic_id")int topic_id);
}
