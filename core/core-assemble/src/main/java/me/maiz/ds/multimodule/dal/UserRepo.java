package me.maiz.ds.multimodule.dal;

import me.maiz.ds.multimodule.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {


}
