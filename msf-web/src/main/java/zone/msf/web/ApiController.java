package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
public class ApiController extends BaseController{

    @Autowired
    ITopicService topicService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseApiResponse<List<TopicDto>> listTopic(HttpServletRequest request,int p, int s, int c) {
        List<TopicDto> lst=topicService.getPageListByCategoryId(p, s, c,super.IsPc(request));
        return new BaseApiResponse<List<TopicDto>>(0, "", lst);
    }
}
