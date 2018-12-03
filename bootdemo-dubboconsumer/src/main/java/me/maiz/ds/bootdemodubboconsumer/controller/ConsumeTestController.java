package me.maiz.ds.bootdemodubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import me.maiz.ds.bootdemo.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeTestController {

    @Reference
    private NewsService newsService;

    @GetMapping("/")
    public String cosume(){
        return newsService.getNews().toString();
    }



}
