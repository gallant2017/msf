package zone.msf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import zone.msf.entity.PVDto;
import zone.msf.services.IEditService;

import java.util.List;

/**
 * Created by huangjunhao on 18/11/13.
 */
@Controller
public class EditController extends BaseController {

    @Autowired
    IEditService editService;

    /**
     * 管理帖子,编辑标题
     *
     * @return
     */
    @RequestMapping(value = "/edit/2fb13922-d386-454d-9181-44e457c13fd3/topicList", method = RequestMethod.GET)
    public ModelAndView TopicList() {

        return new ModelAndView("edit/index");
    }

    /**
     * 管理帖子,编辑标题
     *
     * @return
     */
    @RequestMapping(value = "/edit/2fb13922/pvlst", method = RequestMethod.GET)
    public ModelAndView PvList(Model model,String key,int count) {

        if ("2fb13922-d386-454d-9181-44e457c1345454-5345dfdf-eeejgdf".equals(key)) {
            List<PVDto> pvLst = editService.GetPVList(count);
            model.addAttribute("pvLst", pvLst);
            return new ModelAndView("edit/pvlst");
        }
        return null;
    }
}
