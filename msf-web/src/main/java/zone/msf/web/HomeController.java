package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zone.msf.entity.TopicDto;
import zone.msf.entity.TopicImgDto;
import zone.msf.services.ITopicService;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
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
        List<TopicDto> lst= topicService.getTopicList();
        model.addAttribute("lst", lst);
        return new ModelAndView("index");
    }

    @RequestMapping(value="/thread", method = RequestMethod.GET)
    public ModelAndView detail(HttpServletRequest request, Model model,
                               @PathParam("_sid") int _sid){
        TopicDto objTopic=topicService.getTopicById(_sid);
        if (objTopic!=null) {
            List<TopicImgDto> lstImg= topicService.GetTopicImgsByTopicId(_sid);
            model.addAttribute("objTopic",objTopic);
            model.addAttribute("lstImg", lstImg);
            return new ModelAndView("detail");
        }
        return new ModelAndView("error");
    }

}
