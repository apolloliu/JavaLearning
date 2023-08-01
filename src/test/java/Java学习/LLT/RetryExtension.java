package Java学习.LLT;

//import org.junit.gen5.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.*;
//import org.junit.jupiter.api.extension.ConditionEvaluationResult;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Optional;

public class RetryExtension implements TestExecutionExceptionHandler {

    private int maxRetries;
    private long retryDelay;

    public RetryExtension(int maxRetries, long retryDelay) {
        this.maxRetries = maxRetries;
        this.retryDelay = retryDelay;
    }

//    @Override
//    public void handleTestExecutionException(TestExtensionContext context, Throwable throwable) throws Throwable {
//        if (maxRetries > 0) {
//            maxRetries--;
//            Thread.sleep(retryDelay);
//            context.getTestMethod().ifPresent(method -> method.invoke(context.getTestInstance()));
//        } else {
//            throw throwable;
//        }
//    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("handleTestExecutionException retry: " + maxRetries);
        if (maxRetries > 0) {
            maxRetries--;
            Thread.sleep(retryDelay);
            Optional<Method> testMethod = context.getTestMethod();
            if (testMethod.isPresent()) {
                testMethod.get().invoke(context.getTestInstance());
            }
//            context.getTestMethod().ifPresent(method -> method.invoke(context.getTestInstance()));
        } else {
            throw throwable;
        }

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface RetryConfig {
        int retries() default 1;
        long delay() default 1000;
    }
}
