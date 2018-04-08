package com.huazi.generator.test;

import com.huazi.generator.config.BeetlConfig;
import org.beetl.core.GroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huazi on 2018/4/8.
 */
@Controller
@AutoConfigureAfter(value = BeetlConfig.class)
public class Test {
    @Autowired
    private GroupTemplate groupTemplate;

    @RequestMapping("/test")
    public String test1(){
        return groupTemplate.getTemplate("hello.txt").render();
    }
}
