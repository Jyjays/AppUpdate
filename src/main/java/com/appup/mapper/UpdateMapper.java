package com.appup.mapper;
import com.appup.domain.Information;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UpdateMapper {

    //目前校园网登录用的test，个人用的没有_test

    @Insert("insert into appupdate(version, url, platform,description) VALUES (#{version},#{url},#{platform},#{description})")
    int insert(Information information);

    @Select("select version from appupdate where platform=#{platform}")
    List<String> select(String platform);

    @Select("select * from appupdate where version=#{version} and platform=#{platform}")
    Information selectByVer(String version,String platform);

    @Select("select * from administrator where token=#{token}")
    int check(String token);

    @Delete("delete from appupdate where version=#{version} and platform =#{platform}")
    int delete(String version,String platform);

}
