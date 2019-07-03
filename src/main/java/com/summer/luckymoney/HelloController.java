package com.summer.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@ResponseBody
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/say/{id}")
    public String say(@PathVariable("id") Integer myId){
        return "id:" + myId;
    }
}

