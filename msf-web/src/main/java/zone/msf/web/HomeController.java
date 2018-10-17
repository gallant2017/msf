package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

        if (super.IsPc(request)) {
            List<TopicDto> mainLst = topicService.getPageList(1, 15);
            List<TopicDto> hotLst = topicService.getHotList();
            model.addAttribute("mainLst", mainLst);
            model.addAttribute("hotLst", hotLst);
            return new ModelAndView("pc/index");
        } else {
            model.addAttribute("categoryId", 0);
            return new ModelAndView("m/index");
        }
    }

    @RequestMapping(value = "/{category}/", method = RequestMethod.GET)
    public ModelAndView indexByCategory(HttpServletRequest request, @PathVariable("category") String category,
                                        Model model) {
        model.addAttribute("categoryId", getCategoryId(category));
        model.addAttribute("categoryName",getCategoryName(category));
        return new ModelAndView("m/index");
    }

    private int getCategoryId(String category) {
        String categoryStr = category.toLowerCase();
        if ("shaofu".equals(categoryStr)) {
            return 2;
        } else if ("zhifu".equals(categoryStr)) {
            return 3;
        } else if ("heisi".equals(categoryStr)) {
            return 4;
        } else if ("meitui".equals(categoryStr)) {
            return 5;
        } else if ("qingchun".equals(categoryStr)) {
            return 6;
        } else if ("duanfa".equals(categoryStr)) {
            return 7;
        } else if ("yushi".equals(categoryStr)) {
            return 8;
        } else {
            return 0;
        }
    }

    private String getCategoryName(String category) {
        String categoryStr = category.toLowerCase();
        if ("shaofu".equals(categoryStr)) {
            return "美少妇";
        } else if ("zhifu".equals(categoryStr)) {
            return "制服";
        } else if ("heisi".equals(categoryStr)) {
            return "黑丝";
        } else if ("meitui".equals(categoryStr)) {
            return "美腿";
        } else if ("qingchun".equals(categoryStr)) {
            return "清纯";
        } else if ("duanfa".equals(categoryStr)) {
            return "短发";
        } else if ("yushi".equals(categoryStr)) {
            return "浴室";
        } else {
            return "";
        }
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
            if (super.IsPc(request)) {
                List<TopicDto> hotLst = topicService.getHotList();
                model.addAttribute("hotLst", hotLst);
                return new ModelAndView("pc/detail");
            } else {
                return new ModelAndView("m/detail");
            }
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
