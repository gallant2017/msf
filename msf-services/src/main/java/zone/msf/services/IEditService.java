package zone.msf.services;

import zone.msf.entity.PVDto;
import java.util.List;

/**
 * Created by huangjunhao on 18/11/13.
 */
public interface IEditService {

    List<PVDto> GetPVList(int count);
}
