package com.appup.controller;

import com.appup.domain.*;
import com.appup.service.FeedBackService;
import com.appup.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@RestController
@Api(value = "校园网连接")
@RequestMapping("/schoollink")
public class SchoolLink {

    @Resource
    private UserService userService;

    @Resource
    private FeedBackService feedBackService;

    @PutMapping("/login")
    @ApiOperation(value = "数据收集")
    public String Login(@RequestBody UserDto userDto){

        if (userService.selectUser(userDto.getSchool(), userDto.getAccount())){
            return "existed";
        }else{
            User user = new User(0,userDto.getSchool(),userDto.getAccount(), userDto.getMethod());
            if(userService.insertUser(user)){
                return "OK";
            }else{
                return "error";
            }
        }
    }

    @PutMapping("/feed")
    @ApiOperation(value = "反馈收集")
    public String Feed(@RequestBody FeedDto feedDto){
        // 获取前端发送的base64编码的图片数据
//        String base64Image = feedDto.getImageCode();
//        String imageName = feedDto.getTitle()+".png"; // 图片文件名
//        String imagePath = "/usr/javawork/images/"+ imageName; // 图片保存路径
//        // 解码base64数据并保存为图片文件
//        try {
//            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
//
//            // 将解码后的字节数组写入图片文件
//            try (FileOutputStream imageOutputStream = new FileOutputStream(imagePath)) {
//                imageOutputStream.write(imageBytes);
//            }
//
//        } catch (IOException e) {
//            // 处理异常
//            e.printStackTrace();
//            return "Failed to upload image!";
//        }
        FeedBack feedBack = new FeedBack(0,feedDto.getTitle(), feedDto.getContent(), "1");
        if (feedBackService.write(feedBack)){
            return "OK";
        }else{
            return "ERROR";
        }

    }



}
