package zone.msf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huangjunhao on 18/10/8.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController extends BaseController {

    @RequestMapping(value="/")
    public String index(){
        return "hello, msf..";
    }
}
