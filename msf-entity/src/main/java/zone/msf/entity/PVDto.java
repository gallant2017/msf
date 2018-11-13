package zone.msf.entity;

import java.util.Date;

/**
 * PV 实体
 * Created by huangjunhao on 18/11/13.
 */
public class PVDto {

    private int Id;
    private String ip;
    private int position;
    private String createdOn;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
