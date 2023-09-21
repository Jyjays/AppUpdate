package com.appup.controller;


import com.appup.domain.ImageInformation;
import com.appup.domain.Results;
import com.appup.domain.Roominfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@Api(value = "爬虫")
@RequestMapping("/spider")
public class Spider {

    @ApiOperation(value = "获取电量")
    @PostMapping("/elc")
    public String getRoomInfo(@RequestBody Roominfo request) {
        // 构建请求数据
        MultiValueMap<String, String> requestData = new LinkedMultiValueMap<>();
        requestData.add("jsondata", getJson(request));
        requestData.add("funname", "synjones.onecard.query.elec.roominfo");
        requestData.add("json", "true");
       // System.out.println(requestData);
        // 创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.add("Accept-Language", "zh-CN,zh;q=0.9");
        headers.add("Connection", "keep-alive");
        headers.add("Cookie", "JSESSIONID=E1911ADCB1FDFF824B4062EF76817B56");
        headers.add("Origin", "https://yktm.cumt.edu.cn");
        headers.add("Referer", "https://yktm.cumt.edu.cn/");
        headers.add("Sec-Fetch-Dest", "empty");
        headers.add("Sec-Fetch-Mode", "cors");
        headers.add("Sec-Fetch-Site", "same-origin");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36");
        headers.add("X-Requested-With", "XMLHttpRequest");
        headers.add("sec-ch-ua", "\"Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116\"");
        headers.add("sec-ch-ua-mobile", "?0");
        headers.add("sec-ch-ua-platform", "\"Windows\"");

        // 构建请求实体
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestData, headers);

        // 发送POST请求
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://yktm.cumt.edu.cn/web/Common/Tsm.html", requestEntity, String.class);

        // 解析JSON响应并提取errmsg字段
        String jsonResponse = responseEntity.getBody();
        int startIndex = jsonResponse.indexOf("\"errmsg\":\"");
        if (startIndex != -1) {
            startIndex += "\"errmsg\":\"".length();
            int endIndex = jsonResponse.indexOf("\"", startIndex);
            if (endIndex != -1) {
                String errmsg = jsonResponse.substring(startIndex, endIndex);

                return "errmsg: " + errmsg;
            }
        }
        //System.out.println("JSON Response: " + jsonResponse);

        return "errmsg not found in response.";
    }
    @ApiOperation(value = "获取图标")
    @GetMapping("/getIcon")
    public String searchAppByName(@RequestParam String name) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://itunes.apple.com/search?term=" + name + "&country=us&entity=software&limit=12&callback=jsonp_1695208077236_88151";

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String responseBody = responseEntity.getBody();

        // 去掉 JSONP 包装
        int jsonStart = responseBody.indexOf("{");
        int jsonEnd = responseBody.lastIndexOf("}") + 1;

        if (jsonStart >= 0 && jsonEnd > jsonStart) {
            String jsonData = responseBody.substring(jsonStart, jsonEnd);

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                ImageInformation imageInformation = objectMapper.readValue(jsonData, ImageInformation.class);
                // 在循环中查找包含 name 的数据
                for (Results result : imageInformation.getResults()) {
                    if (result.getTrackCensoredName().contains(name)) {
                        return "trackCensoredName: " + result.getTrackCensoredName() + ", artworkUrl512: " + result.getArtworkURL512();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }

        return "not found";
    }


    private String getJson(Roominfo request) {
        // 构建JSON数据
        Map<String, Object> jsonData = new HashMap<>();
        Map<String, Object> queryElecRoomInfo = new HashMap<>();
        Map<String, Object> area = new HashMap<>();
        Map<String, Object> building = new HashMap<>();
        Map<String, Object> floor = new HashMap<>();
        Map<String, Object> room = new HashMap<>();
        Map<String, String> buildingMap = new HashMap<>();
        buildingMap.put("兰梅","14");
        buildingMap.put("南湖体育馆","571");
        buildingMap.put("松竹","12" );
        buildingMap.put("桃苑","11" );
        buildingMap.put("杏苑","13");
        buildingMap.put( "用电单位","614");
        buildingMap.put( "科创10","221");
        buildingMap.put("行健楼","311" );
        buildingMap.put("学02楼","214" );
        buildingMap.put("学04楼","189" );
        buildingMap.put("学05楼","190" );
        buildingMap.put("学06楼","191" );
        buildingMap.put("学07楼","192" );
        buildingMap.put("学08楼","181" );
        buildingMap.put("学13楼","318" );
        buildingMap.put("学14楼","319" );
        buildingMap.put("学15楼","320" );
        buildingMap.put("学16楼","321" );
        buildingMap.put("学17楼","1" );
        area.put("area", "1");
        area.put("areaname", "中国矿业大学");
        building.put("building", request.getBuilding());
        building.put("buildingid", buildingMap.get(request.getBuilding()));
        floor.put("floor", "");
        floor.put("floorid", "");
        room.put("roomid", request.getRoomID());
        room.put("room", request.getRoom());

        queryElecRoomInfo.put("account", "149059");
        queryElecRoomInfo.put("aid", "0030000000002501");
        queryElecRoomInfo.put("area", area);
        queryElecRoomInfo.put("building", building);
        queryElecRoomInfo.put("floor", floor);
        queryElecRoomInfo.put("room", room);

        jsonData.put("query_elec_roominfo", queryElecRoomInfo);

        // 使用 Jackson 或其他 JSON 库将 Map 转为 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(jsonData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
