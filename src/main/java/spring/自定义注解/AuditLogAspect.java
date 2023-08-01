package spring.自定义注解;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLogAspect {
    @Before("@annotation(auditLog)")
    public void beforeMethodExecution(JoinPoint joinPoint, AuditLog auditLog) {
        String methodName = joinPoint.getSignature().getName();
        String logMessage = "Executing method: " + methodName;
        if (!auditLog.value().isEmpty()) {
            logMessage += ".Custom message: " + auditLog.value();
        }
        System.out.println(logMessage);
    }
}
