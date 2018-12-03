package me.maiz.ds.bootdemo.controller;

import me.maiz.ds.bootdemo.dal.NewsRepo;
import me.maiz.ds.bootdemo.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersistentController {

    @Autowired
    private NewsRepo newsRepo;

    @GetMapping("/save")
    public String save(String title ){
        News news = new News();
        news.setTitle(title);
        news.setIntro("asdfasdf");
        news.setUrl("asdfasdf");
        newsRepo.save(news);
        return "saved";
    }

}
