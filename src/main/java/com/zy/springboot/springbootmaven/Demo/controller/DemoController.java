package com.zy.springboot.springbootmaven.Demo.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.springboot.springbootmaven.Demo.Entity.Emp;
import com.zy.springboot.springbootmaven.Demo.Entity.Person;
import com.zy.springboot.springbootmaven.Demo.service.EmpMapperService;
import com.zy.springboot.springbootmaven.Demo.service.PersonMapperService;
import com.zy.springboot.springbootmaven.annotation.DataSource;
import com.zy.springboot.springbootmaven.annotation.MyLog;
import com.zy.springboot.springbootmaven.datasource.DataSourceType;
import com.zy.springboot.springbootmaven.utils.WeatherHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class DemoController {

    @Autowired
    private PersonMapperService personMapperService;

    @Autowired
    private EmpMapperService empMapperService;

    @RequestMapping("/demohello/{name}")
    public String demo(@PathVariable("name")String name, ModelMap modelMap){
        modelMap.put("name",name);
        return "demo/hello";
    }

    @RequestMapping("/demo")
    public String testVue(){
        return "/demo/vue1";
    }

    @RequestMapping("/personlist/{index}/{page}")
    @ResponseBody
    @MyLog(title = "获取persoinList",businessType = "业务模块",opratorType = "查询")
    public PageInfo getpersonList(@PathVariable("index")int index,@PathVariable("page")int page){
        PageHelper.startPage(index,page);
        List<Person> personList = personMapperService.selectAll();
        PageInfo pageInfo = new PageInfo(personList);

        return pageInfo;
    }

    @RequestMapping("/emplist/{index}/{page}")
    @ResponseBody
   // @DataSource(DataSourceType.SLAVE)
    @MyLog(title = "获取empList",businessType = "业务模块",opratorType = "查询")
    public PageInfo getempList(@PathVariable("index")int index,@PathVariable("page")int page){
        PageHelper.startPage(index,page);
        List<Emp> empList = empMapperService.selectAll();
        PageInfo pageInfo = new PageInfo(empList);

        return pageInfo;
    }

    @GetMapping("/editTest")
    public String  toEditor(HttpServletRequest request ,Model model) throws Exception{
        String ip = request.getRemoteHost();
        String dateTime = DateUtil.format(new Date(),"yyyy-MM-dd");
        Map weatherMap = WeatherHelper.getWeather("101120301");
        model.addAttribute("weather",weatherMap);
        model.addAttribute("host",ip);
        model.addAttribute("date",dateTime);
        return "demo/editTest";
    }

    @GetMapping("/weixinlogin")
    public String toweixinLogin(){
        return "demo/weixinlogin";
    }
}
