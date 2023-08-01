package Java学习.LLT.retry;

import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Method;
import java.util.Optional;

public class RetryTestExecutionExtension implements TestExecutionExceptionHandler {

    private int maxRetries;
    private long retryDelay;

    public RetryTestExecutionExtension(int maxRetries, long retryDelay) {
        this.maxRetries = maxRetries;
        this.retryDelay = retryDelay;
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        while (maxRetries > 0) {
            System.out.println("handleTestExecutionException retry: " + maxRetries);
            if (maxRetries > 0) {
                maxRetries--;
                Thread.sleep(retryDelay);
                try {

                    context.getTestInstance().ifPresent(testInstance -> invokeTestMethod(context));
                } catch (Throwable e) {
//                throw new RuntimeException(e);
                }
            } else {
                throw throwable;
            }
        }
    }

    private void invokeTestMethod(ExtensionContext context) {
        try {
            context.getTestMethod().ifPresent(method -> {
                try {
                    method.invoke(context.getTestInstance().orElseThrow());
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
    }
}
//public class RetryTestExecutionExtension implements TestExecutionExceptionHandler {
//
//    private int maxRetries;
//    private final long retryDelay;
//
//    public RetryTestExecutionExtension(int maxRetries, long retryDelay) {
//        this.maxRetries = maxRetries;
//        this.retryDelay = retryDelay;
//    }
//
//    @Override
//    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
//        System.out.println("handleTestExecutionException retry: " + maxRetries);
//        while(maxRetries > 0) {
//            if (maxRetries > 0) {
//                maxRetries--;
//                Thread.sleep(retryDelay);
//                Optional<Method> testMethod = context.getTestMethod();
//                if (testMethod.isPresent()) {
//                    invokeTestMethod(context);
//                }
////            context.getTestMethod().ifPresent(method -> invokeTestMethod(context));
//            } else {
//                throw throwable;
//            }
//        }
//
//    }
//
//    private void invokeTestMethod(ExtensionContext context) {
//        try {
//            Object requiredTestInstance = context.getRequiredTestInstance();
//            if (Optional.ofNullable(context.getRequiredTestMethod()).isPresent()) {
//                try {
//                    context.getRequiredTestMethod().invoke(requiredTestInstance);
////                    context.getRequiredTestMethod().invoke(testInstance);
//                } catch (Throwable e) {
//                    throw new RuntimeException(e);
//                }
//            }
////            context.getRequiredTestInstance().ifPresent(testInstance -> {
////                try {
////                    context.getRequiredTestMethod().invoke(testInstance);
////                } catch (Throwable e) {
////                    throw new RuntimeException(e);
////                }
////            });
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

