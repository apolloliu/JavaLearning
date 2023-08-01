package spring.自定义注解.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.自定义注解.AuditLogAspect;

@Configuration
public class CustomizationConfiguration {
    @Bean
    public AuditLogAspect auditLogAspect() {
        return new AuditLogAspect();
    }
}
