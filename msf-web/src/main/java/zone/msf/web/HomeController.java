package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zone.msf.services.ITopicService;

/**
 * Created by huangjunhao on 18/10/8.
 */

@Controller
@ResponseBody
public class HomeController extends BaseController {

    @Autowired
    ITopicService topicService;

    /**
     * 首页
     * @return
     */
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        return topicService.test();
    }
}
