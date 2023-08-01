package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import spring.自定义注解.AuditLog;

@SpringBootTest
class Demo4ApplicationTests {
    
    @Test
    void contextLoads() {
    }

    @Test
    @AuditLog("测试")
    public void testAudit() {

    }

}
