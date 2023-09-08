package com.appup.service;

import com.appup.domain.FeedBack;
import com.appup.mapper.FeedBackMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FeedBackService {


    @Resource
    FeedBackMapper feedBackMapper;

    public boolean write(FeedBack feedBack){
        return feedBackMapper.insertFeed(feedBack)>0;
    }
}
