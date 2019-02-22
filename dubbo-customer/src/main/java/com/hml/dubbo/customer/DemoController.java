package com.hml.dubbo.customer;

import com.hml.dubbo.api.DemoService;
import io.swagger.annotations.*;
import org.itboys.commons.CommonConstants;
import org.itboys.commons.dto.ResultDO;
import org.itboys.commons.dto.ResultPageDOHelper;
import org.itboys.commons.utils.ajax.AjaxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by huml on 2018/4/26.
 */
@RestController
@Api(tags = "banner管理")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/demo.htm")
    @ApiOperation(value = "查询banner",notes = "查询banner")
    public void demo(){
        demoService.print("Hello, World!");
    }

    @PostMapping("/vm.htm")
    @ApiOperation(value = "查询banner1",notes = "查询banner1", response = A.class)
    @ApiResponses({
            @ApiResponse(code = 0, message = "请求成功"),
            @ApiResponse(code = -1, message = "请求失败")
    })
    public void vm(HttpServletResponse response){
        AjaxUtils.renderJsonporJson(response, null, ResultPageDOHelper.getMsgCodeResultDO(0, CommonConstants.SUCCESS));
    }

}
