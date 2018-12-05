package me.maiz.ds.bootdemo.service;

import com.alibaba.dubbo.config.annotation.Service;
import me.maiz.ds.bootdemo.dal.NewsRepo;
import me.maiz.ds.bootdemo.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service(interfaceClass = NewsService.class)
@Component
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepo newsRepo;

    @Override
    public List getNews() {
        System.out.println("调用");
        List<News> result = newsRepo.findAll();
        return result;
    }
}
