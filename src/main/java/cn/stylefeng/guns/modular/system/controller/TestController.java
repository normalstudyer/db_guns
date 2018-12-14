package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import com.xhs.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.system.model.Test;
import cn.stylefeng.guns.modular.system.service.ITestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * test控制器
 *
 * @author fengshuonan
 * @Date 2018-12-05 09:24:01
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    private String PREFIX = "/system/test/";

    @Autowired
    private ITestService testService;


    /**
     * 跳转到test首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "test.html";
    }

    /**
     * 跳转到添加test
     */
    @RequestMapping("/test_add")
    public String testAdd() {
        return PREFIX + "test_add.html";
    }

    /**
     * 跳转到修改test
     */
    @RequestMapping("/test_update/{testId}")
    public String testUpdate(@PathVariable Integer testId, Model model) {
        Test test = testService.selectById(testId);
        model.addAttribute("item",test);
        LogObjectHolder.me().set(test);
        return PREFIX + "test_edit.html";
    }
    /**
     * 跳转到图片上传
     */
    @RequestMapping("/test_image")
    public String testImage() {
        return PREFIX + "test_image.html";
    }
    /**
     * 获取test列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return testService.selectList(null);
    }

    /**
     * 新增test
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Test test) {
        testService.insert(test);
        return SUCCESS_TIP;
    }

    /**
     * 删除test
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer testId) {
        testService.deleteById(testId);
        return SUCCESS_TIP;
    }

    /**
     * 修改test
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Test test) {
        testService.updateById(test);
        return SUCCESS_TIP;
    }

    /**
     * test详情
     */
    @RequestMapping(value = "/detail/{testId}")
    @ResponseBody
    public Object detail(@PathVariable("testId") Integer testId) {
        return testService.selectById(testId);
    }

    /**
     * 测试下载jar
     */
    @RequestMapping(value = "/downloadJar")
    @ResponseBody
    public void downloadJar(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String file = "E:\\db_download\\guns开源框架\\guns\\src\\main\\webapp\\static\\keeprisk-common-0.0.1-RELEASE.jar";
        WebUtil.downLoad(file,"down.jar", response,request);
        //testService.deleteById(testId);
        //return SUCCESS_TIP;
    }
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadUserImage( @RequestParam(value = "image",required = true) String base64Code,
                                     @RequestParam(value = "x1",required = true) int x1,
                                     @RequestParam(value = "y1",required = true) int y1,
                                     @RequestParam(value = "x2",required = true) int x2,
                                     @RequestParam(value = "y2",required = true) int y2) throws IOException{
        String result = testService.uploadUserImage(base64Code, x1, y1, x2, y2);
        if(result.equals("")){
            return SUCCESS_TIP;
        }else{
            return SUCCESS_TIP;
        }
    }
    @RequestMapping(value = "/uploadImage1",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadUserImage1( @RequestParam(value = "image",required = true) String base64Code) throws IOException{
        String result = testService.uploadUserImage1(base64Code);
        if(result.equals("")){
            return SUCCESS_TIP;
        }else{
            return SUCCESS_TIP;
        }
    }
}
