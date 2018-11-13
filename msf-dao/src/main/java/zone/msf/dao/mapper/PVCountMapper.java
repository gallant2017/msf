package zone.msf.dao.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import zone.msf.entity.PVDto;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/27.
 */
@Mapper
public interface PVCountMapper {

    @Insert("insert into pv_count(ip,position) values(#{ip},#{position})")
    void AddPV(@Param("ip")String ip,@Param("position")int position);

    @Insert("insert into ck(a,b,c) values(#{a},#{b},'')")
    void AddCK(@Param("a")String a,@Param("b")String b);

    @Select("select * from pv_count order by id desc limit #{count}")
    List<PVDto> GetPVList(@Param("count")int count);

}
