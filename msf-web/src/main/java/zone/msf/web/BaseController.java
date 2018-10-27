package zone.msf.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangjunhao on 18/10/8.
 */

public class BaseController {

    @Value("${spring.profiles.js-version}")
    protected String jsVersion;

    @Value("${spring.profiles.css-version}")
    protected String cssVersion;

    @Value("${keyvalue.static-url}")
    protected String staticUrl;

    @ModelAttribute
    public final void init(HttpServletRequest request, Model model) {
        model.addAttribute("jsVersion", jsVersion);
        model.addAttribute("cssVersion", cssVersion);
        model.addAttribute("staticUrl", staticUrl);
    }

    public boolean IsPc(HttpServletRequest request) {
        return request.getRequestURL().indexOf("m.msf.zone") < 0;
    }

    /**
     * 获取客户端ip
     * @param request
     * @return
     */
    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }
}
