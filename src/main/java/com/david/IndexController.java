package com.david;

import com.david.collectionTest.comparableTest.User;
import com.david.exportTest.FilePortUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class IndexController {

    /*
     * @Description
     * @Author DavidPeng
     * @Date 2019/7/12 22:37
     **/
    @RequestMapping(value="index")
    public String index(){
        return "这是首页";
    }

    @RequestMapping(value = "/fileExport", method = RequestMethod.GET)
    @ResponseBody
    public void fileExport(HttpServletResponse response) {
        //导出的表名
        String title = "人员信息表";
        //表中第一行表头字段
        String[] headers = {"姓名", "性别", "地址", "学校"};
        //实际数据结果集
        List<User> listObject = new ArrayList<>();
        User u1 = new User();
        u1.setName("张三");
        u1.setAddress("长沙");
        u1.setSchool("中南大学");
        u1.setSex("男");
        User u2 = new User();
        u2.setName("李四");
        u2.setAddress("北京");
        u2.setSchool("清华大学");
        u2.setSex("男");
        User u3 = new User();
        u3.setName("王五");
        u3.setAddress("上海");
        u3.setSchool("复旦大学");
        u3.setSex("男");
        listObject.add(u1);
        listObject.add(u2);
        listObject.add(u3);
        //具体需要写入excel需要哪些字段，这些字段取自UserReward类，也就是上面的实际数据结果集的泛型
        List<String> listColumn = Arrays.asList("name", "sex", "address", "school");
        try {
            FilePortUtil.exportExcel(response, title, headers, listObject, listColumn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
