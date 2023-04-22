package com.appup.mapper;
import com.appup.domain.Information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UpdateMapper {

    @Insert("insert into appupdate_test(version, url, platform,description) VALUES (#{version},#{url},#{platform},#{description})")
    int insert(Information information);

    @Select("select version from appupdate_test where platform=#{platform}")
    List<String> select(String platform);

    @Select("select * from appupdate_test where version=#{version}")
    Information selectByVer(String version);

    @Select("select * from administrator_test where token=#{token}")
    int check(String token);

}
