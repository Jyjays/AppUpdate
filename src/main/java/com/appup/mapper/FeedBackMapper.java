package com.appup.mapper;

import com.appup.domain.FeedBack;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedBackMapper {
    @Insert("insert into link_feedback (id, title, content, image_path) VALUES (#{id},#{title},#{content},#{imagePath})")
    int insertFeed(FeedBack feedBack);
}
