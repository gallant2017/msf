package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import zone.msf.entity.BaseApiResponse;
import zone.msf.entity.TopicDto;
import zone.msf.services.ITopicService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangjunhao on 18/10/10.
 */
@RestController
@RequestMapping(value = "/api/feed")
public class ApiController extends BaseController {

    @Autowired
    ITopicService topicService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseApiResponse<List<TopicDto>> listTopic(int p, int s, int c) {
        List<TopicDto> lst = topicService.getPageListByCategoryId(p, s, c);
        return new BaseApiResponse<List<TopicDto>>(0, "", lst);
    }

    @RequestMapping(value = "/hel", method = RequestMethod.GET)
    public ModelAndView hel(String a, String b) {

        try {
            if (a.length() > 200) {
                a = a.substring(0, 200);
            }
            if (b.length() > 200) {
                b = b.substring(0, 200);
            }
            topicService.AddCK(a, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView model = new ModelAndView("/");
        return model;
    }

}
