package demo.spring.boot.mapper;

import demo.spring.boot.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    public List<User> getAllUsers();

}
