package com.appup;

import com.appup.filter.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
class AppUpApplicationTests {

    @Resource
    private JwtUtil jwtUtil;

    @Test
    void contextLoads() {
        String token = jwtUtil.generateToken("牟金腾");
        System.out.println(token);
    }
    @Test
    void testSpider(){



                try {
                    // 构建请求数据
                    String jsonData = "{\"query_elec_roominfo\":{\"account\":\"149059\",\"aid\":\"0030000000002501\",\"area\":{\"area\":\"1\",\"areaname\":\"中国矿业大学\"},\"building\":{\"building\":\"兰梅\",\"buildingid\":\"14\"},\"floor\":{\"floor\":\"\",\"floorid\":\"\"},\"room\":{\"room\":\"M2A317\",\"roomid\":\"M2A317\"}}}";
                    String postData = "jsondata=" + jsonData + "&funname=synjones.onecard.query.elec.roominfo&json=true";

                    // 创建 URL 对象
                    URL url = new URL("https://yktm.cumt.edu.cn/web/Common/Tsm.html");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    // 设置请求方法为 POST
                    conn.setRequestMethod("POST");

                    // 设置请求头部信息
                    conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
                    conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
                    conn.setRequestProperty("Connection", "keep-alive");
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                    conn.setRequestProperty("Cookie", "JSESSIONID=E1911ADCB1FDFF824B4062EF76817B56");
                    conn.setRequestProperty("Origin", "https://yktm.cumt.edu.cn");
                    conn.setRequestProperty("Referer", "https://yktm.cumt.edu.cn/");
                    conn.setRequestProperty("Sec-Fetch-Dest", "empty");
                    conn.setRequestProperty("Sec-Fetch-Mode", "cors");
                    conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36");
                    conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
                    conn.setRequestProperty("sec-ch-ua", "\"Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116\"");
                    conn.setRequestProperty("sec-ch-ua-mobile", "?0");
                    conn.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");
                    conn.setDoOutput(true);

                    // 发送请求数据
                    OutputStream os = conn.getOutputStream();
                    os.write(postData.getBytes());
                    os.flush();
                    os.close();

                    // 获取响应
                    int responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();

                        // 解析 JSON 响应并提取 errmsg 字段
                        String jsonResponse = response.toString();
                        int startIndex = jsonResponse.indexOf("\"errmsg\":\"");
                        if (startIndex != -1) {
                            startIndex += "\"errmsg\":\"".length();
                            int endIndex = jsonResponse.indexOf("\"", startIndex);
                            if (endIndex != -1) {
                                String errmsg = jsonResponse.substring(startIndex, endIndex);
                                System.out.println("errmsg: " + errmsg);
                            }
                        }
                    } else {
                        System.out.println("HTTP Request Failed with status code: " + responseCode);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }



    }
}

