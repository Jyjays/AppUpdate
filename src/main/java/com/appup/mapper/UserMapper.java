package com.appup.mapper;

import com.appup.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from linkuser where school = #{school} and account = #{account}")
    User selectUser(String school, String account);

    @Insert("insert into linkuser (school, account, method) VALUES (#{school}, #{account}, #{method})")
    int insertUser(User user);

}
