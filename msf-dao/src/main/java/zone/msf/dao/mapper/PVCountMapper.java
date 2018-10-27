package zone.msf.dao.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huangjunhao on 18/10/27.
 */
@Mapper
public interface PVCountMapper {

    @Insert("insert into pv_count(ip,position) values(#{ip},#{position})")
    void AddPV(@Param("ip")String ip,@Param("position")int position);

}
