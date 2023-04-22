package com.appup;

import com.appup.filter.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AppUpApplicationTests {

    @Resource
    private JwtUtil jwtUtil;

    @Test
    void contextLoads() {
        String token = jwtUtil.generateToken("牟金腾");
        System.out.println(token);
    }

}
