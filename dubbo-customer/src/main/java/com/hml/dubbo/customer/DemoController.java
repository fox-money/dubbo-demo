package com.hml.dubbo.customer;

import com.hml.dubbo.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huml on 2018/4/26.
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo.htm")
    public void demo(){
        demoService.print("Hello, World!");
    }

    @RequestMapping("/vm.htm")
    public ModelAndView vm(){
        return new ModelAndView("site/success");
    }

}
