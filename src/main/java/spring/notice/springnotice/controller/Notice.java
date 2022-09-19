package spring.notice.springnotice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Notice {

    @RequestMapping("/")
    ModelAndView test(
            ModelAndView modelAndView
    ) {
        modelAndView.setViewName("test");
        modelAndView.addObject("test", "hello");
        return modelAndView;
    }
}
