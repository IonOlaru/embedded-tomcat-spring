package web;

import main.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.Services;
import services.TMService;

/**
 * @author Ion Olaru
 *         Date: 2014/02/10 - 16:42
 */
@Controller
@RequestMapping("/hello-spring")
public class HelloController {

    @Autowired
    TMService tmServiceFromTomcatSpring;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        model.addAttribute("objects1", Services.getTMService().loadAll());
        model.addAttribute("objects2", tmServiceFromTomcatSpring.loadAll());
        return "hello";
    }

}
