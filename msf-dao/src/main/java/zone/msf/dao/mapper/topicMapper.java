package zone.msf.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by huangjunhao on 18/10/8.
 */
@Mapper
public interface TopicMapper {

     @Select("select title from topic")
     String test();
}
