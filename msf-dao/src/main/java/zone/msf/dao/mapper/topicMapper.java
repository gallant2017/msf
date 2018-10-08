package zone.msf.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zone.msf.entity.TopicDto;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/8.
 */
@Mapper
public interface TopicMapper {

     @Select("select id,title from topic")
     List<TopicDto> test();
}
