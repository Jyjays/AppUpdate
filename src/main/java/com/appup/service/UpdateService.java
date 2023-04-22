package com.appup.service;

import com.appup.domain.Information;
import com.appup.mapper.UpdateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UpdateService {
    @Resource
    private UpdateMapper updateMapper;

    public boolean Post(Information information) {
        return updateMapper.insert(information)>0;
    }

    public List<String> Get(String platform){
        return updateMapper.select(platform);
    }

    public Information selectVer(String version){
        return updateMapper.selectByVer(version);
    }

    public int check(String token){
        return updateMapper.check(token);
    }

}
