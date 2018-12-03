package me.maiz.ds.bootdemo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.util.List;

public interface NewsRepo extends JpaRepository<News,Integer> {

    void save(List newsList) throws IOException;

}
