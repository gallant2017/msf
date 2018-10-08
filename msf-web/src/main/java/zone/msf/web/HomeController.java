package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zone.msf.entity.TopicDto;
import zone.msf.services.ITopicService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public ModelAndView index(HttpServletRequest request, Model model){
        List<TopicDto> lst= topicService.test();
        model.addAttribute("lst", lst);
        return new ModelAndView("index");
    }
}
