package zone.msf.entity;

/**
 * Created by huangjunhao on 18/10/10.
 */
public class BaseApiResponse<T> {

    public BaseApiResponse() {
    }

    public BaseApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseApiResponse(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.obj = t;
    }

    private int code;
    private String msg;
    public T obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
