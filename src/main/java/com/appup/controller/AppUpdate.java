package com.appup.controller;

import com.appup.domain.Information;
import com.appup.service.UpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@Api(value = "软件更新")
@RequestMapping("/update")
public class AppUpdate {
    @Resource
    private UpdateService updateService;

    @PostMapping("/publish")
    @ApiOperation("上传版本")
    public String  Publish(@RequestBody Information information,@RequestHeader("Authorization") String token){
        int count = updateService.check(token);
        if (count>0) {
            boolean flag = updateService.Post(information);
            return (flag ? "message:上传成功" : "message:上传失败");
        }
        else return "没有访问权限";
    }

    @GetMapping("/check")
    @ApiOperation("检测更新")
    public Result Check(@RequestParam String version,String platform) {
        List<String> list = updateService.Get(platform);
        String latestVersion = "";
        int[] curVersion = Arrays.stream(version.split("\\."))
                .mapToInt(Integer::parseInt).toArray();

        for (String version2 : list) {
            int[] newVersion = Arrays.stream(version2.split("\\."))
                    .mapToInt(Integer::parseInt).toArray();
            boolean isNewerVersion = false;

            for (int i = 0; i < Math.min(curVersion.length, newVersion.length); i++) {
                if (newVersion[i] > curVersion[i]) {
                    isNewerVersion = true;
                    break;
                } else if (newVersion[i] < curVersion[i]) {
                    break;
                }
            }

            if (isNewerVersion) {
                latestVersion = version2;
                curVersion = newVersion;
            }
        }


        if (latestVersion.isEmpty()) {
            return new Result("没有可用的更新");
        } else {
            Information information = updateService.selectVer(latestVersion,platform);

            return new Result(latestVersion, information.getUrl(), information.getDescription(),information.getPlatform()
                    ,"False");

        }
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除更新")
    public String deleteVersion(@RequestParam("version") String version,@RequestParam("platform") String platform,@RequestHeader("Authorization") String token){
        int count = updateService.check(token);
        if (count>0) {
            Information information = updateService.selectVer(version,platform);
            if(information==null){return "不存在此版本";}
            boolean flag = updateService.delete(version,platform);
            return (flag ? "message:删除成功" : "message:删除失败");
        }
        else return "没有访问权限";


       // return new Result(information.getVersion(),information.getUrl(),flag?"删除成功":"删除失败",information.getPlatform(),null);

    }


}
