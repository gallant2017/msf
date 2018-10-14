package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class HomeController extends BaseController {

    @Autowired
    ITopicService topicService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, Model model) {
        return new ModelAndView("m/index");
    }

    /**
     * 帖子详情
     * @param request
     * @param model
     * @param _sid
     * @return
     */
    @RequestMapping(value = "/thread", method = RequestMethod.GET)
    public ModelAndView detail(HttpServletRequest request, Model model,
                               @PathParam("_sid") int _sid) {
        TopicDto objTopic = topicService.getObjById(_sid);
        if (objTopic != null) {
            List<TopicImgDto> lstImg = topicService.getImgsByTopicId(_sid);
            model.addAttribute("objTopic", objTopic);
            model.addAttribute("lstImg", lstImg);
            return new ModelAndView("m/detail");
        }
        return new ModelAndView("error");
    }

    /**
     * 品味
     * @return
     */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView category() {
        return new ModelAndView("m/category");
    }

    /**
     * 段子
     * @return
     */
    @RequestMapping(value = "/novel", method = RequestMethod.GET)
    public ModelAndView novel() {
        return new ModelAndView("m/novel");
    }
    /**
     * 收藏
     * @return
     */
    @RequestMapping(value = "/collecting", method = RequestMethod.GET)
    public ModelAndView collecting() {
        return new ModelAndView("m/collecting");
    }
}
