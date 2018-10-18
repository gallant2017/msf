package zone.msf.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zone.msf.entity.TopicDto;
import zone.msf.entity.TopicImgDto;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/8.
 */
@Mapper
public interface TopicMapper {

     @Select("select id,title,createdOn from topic where id=#{topic_id} and is_del=0")
     TopicDto getObjById(@Param("topic_id")int topic_id);

     @Select("select id,title,createdOn from topic")
     List<TopicDto> getList();


     @Select("select id,topic_id,url,memo1,view_count,createdOn from topic_img where topic_id=#{topic_id}")
     List<TopicImgDto> GetImgsByTopicId(@Param("topic_id")int topic_id);

    @Select("select id,topic_id,url from topic_img where topic_id=#{topic_id} order by rand() limit 1")
    TopicImgDto GetCoverImgByTopicId(@Param("topic_id")int topic_id);

     @Update("update topic set view_count=view_count+1 where id=#{topic_id}")
     void AddViewCount(@Param("topic_id")int topic_id);

     @Select("select id,title,pub_date,view_count from topic where pub_date<=now() and is_del=0 order by view_count desc limit 5")
     List<TopicDto> GetHotList();


    /**
     * 最新
     * @param offset
     * @param pageSize
     * @return
     */
     @Select("select id,title,category_id,createdOn from topic where is_show_index=1 and is_del=0 and now()>=pub_date " +
             " and id >= (select id from topic where is_show_index=1 and is_del=0 and now()>=pub_date order by id limit #{offset},1) " +
             " order by id  limit #{pageSize}")
     List<TopicDto> getPageList(@Param("offset")int offset,@Param("pageSize")int pageSize);


     /**
      * 最新
      * @param offset
      * @param pageSize
      * @return
      */
     @Select("select id,title,category_id,createdOn from topic where is_del=0 and now()>=pub_date " +
             " and id >= (select id from topic where is_del=0 and now()>=pub_date order by id limit #{offset},1) " +
             " order by id limit #{pageSize}")
     List<TopicDto> getLatestPageList(@Param("offset")int offset,@Param("pageSize")int pageSize);

    /**
     * 最老
     * @param offset
     * @param pageSize
     * @return
     */
     @Select("select id,title,category_id,createdOn from topic where is_del=0 and now()>=pub_date " +
             " and id<=(select id from topic where is_del=0 and now()>=pub_date order by id desc limit #{offset},1) " +
             " order by id desc limit #{pageSize}")
     List<TopicDto> getOldimeyPageList(@Param("offset")int offset,@Param("pageSize")int pageSize);

     /**
      * 根据类别查询 ID降序
      * @param offset
      * @param pageSize
      * @param categoryId
      * @return
      */
     @Select("select id,title,category_id,createdOn from topic where category_id=#{categoryId} and is_del=0 and now()>=pub_date" +
             " and id>=(select id from topic where category_id=#{categoryId} and is_del=0 and now()>=pub_date order by id limit #{offset},1) " +
             " order by id limit #{pageSize}")
     List<TopicDto> getPageListByCategoryId(@Param("offset")int offset,@Param("pageSize")int pageSize,@Param("categoryId")int categoryId);


}
