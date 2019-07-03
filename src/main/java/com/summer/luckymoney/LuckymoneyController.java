package com.summer.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@RestController
public class LuckymoneyController {
    @Autowired
    private LuckymoneyRepository repository;
    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return repository.findAll();
    }
    /**
     * 创建红包
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    /**
     * 通过ID查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return  repository.findById(id).orElse(null);
    }
}
