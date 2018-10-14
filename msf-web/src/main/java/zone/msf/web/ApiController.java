package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zone.msf.entity.BaseApiResponse;
import zone.msf.entity.TopicDto;
import zone.msf.services.ITopicService;

import java.util.List;

/**
 * Created by huangjunhao on 18/10/10.
 */
@RestController
@RequestMapping(value = "/api/feed")
public class ApiController {

    @Autowired
    ITopicService topicService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseApiResponse<List<TopicDto>> listTopic(int p, int s) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<TopicDto> lst = topicService.getPageList(p, s);
        return new BaseApiResponse<List<TopicDto>>(0, "", lst);
    }
}
