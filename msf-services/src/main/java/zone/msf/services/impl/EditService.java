package zone.msf.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.msf.dao.mapper.PVCountMapper;
import zone.msf.entity.PVDto;
import zone.msf.services.IEditService;

import java.util.List;

/**
 * Created by huangjunhao on 18/11/13.
 */
@Service
public class EditService implements IEditService {

    @Autowired
    PVCountMapper pvCountMapper;

    @Override
    public List<PVDto> GetPVList(int count) {
        return pvCountMapper.GetPVList(count);
    }
}
