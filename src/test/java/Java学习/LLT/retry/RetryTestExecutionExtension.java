package Java学习.LLT.retry;

import org.junit.jupiter.api.extension.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RetryTestExecutionExtension implements TestExecutionExceptionHandler, BeforeEachCallback, AfterEachCallback {

    private final int maxRetries;
    private final long retryDelay;

    private Method beforeEachMethod;

    private Method afterEachMethod;

    public RetryTestExecutionExtension(int maxRetries, long retryDelay) {
        this.maxRetries = maxRetries;
        this.retryDelay = retryDelay;
    }

//    public RetryTestExecutionExtension(int maxRetries, long retryDelay) {
//        this.maxRetries = maxRetries;
//        this.retryDelay = retryDelay;
//    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        int currentRetries = maxRetries;
        while (currentRetries > 0) {
            System.out.println("handleTestExecutionException retry: " + currentRetries);
            currentRetries--;
            Thread.sleep(retryDelay);
            try {
                if (beforeEachMethod != null) {
                    beforeEachMethod.invoke(context.getTestInstance().orElseThrow());
                }
                context.getTestInstance().ifPresent(testInstance -> invokeTestMethod(context));
                break;
            } catch (Throwable e) {
//                throw new RuntimeException(e);
            } finally {
                try {
                    if (afterEachMethod != null) {
                        afterEachMethod.invoke(context.getTestInstance().orElseThrow());
                    }
                } catch (Throwable ignored) {}
            }
            if (currentRetries == 0) {
                throw throwable;
            }
        }
//        if (maxRetries > 0) {
//            maxRetries--;
//            Thread.sleep(retryDelay);
//            try {
//                if (beforeEachMethod != null) {
//                    beforeEachMethod.invoke(context.getTestInstance().orElseThrow());
//                }
//                context.getTestMethod().ifPresent(method -> invokeTestMethod(context));
//            } catch (Throwable e) {
//                if (maxRetries == 0) {
//                    throw throwable;
//                }
//            }
//        } else {
//            throw throwable;
//        }
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public void beforeEach(ExtensionContext context) throws InvocationTargetException, IllegalAccessException {
        // 获取测试类中的 @BeforeEach 方法
        Class<?> testClass = context.getRequiredTestClass();
        Method setupMethod = findSetupMethod(testClass, org.junit.jupiter.api.BeforeEach.class);
        this.beforeEachMethod = setupMethod;

//        if (setupMethod != null) {
//            // 调用 @BeforeEach 方法
//            setupMethod.invoke(context.getTestInstance().orElseThrow());
//        }
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // 可以在此处添加 AfterEach 的逻辑
        Class<?> testClass = context.getRequiredTestClass();
        Method setupMethod = findSetupMethod(testClass, org.junit.jupiter.api.AfterEach.class);
        this.afterEachMethod = setupMethod;

//        if (setupMethod != null) {
//            // 调用 @BeforeEach 方法
//            setupMethod.invoke(context.getTestInstance().orElseThrow());
//        }
    }

    private Method findSetupMethod(Class<?> testClass, Class<? extends Annotation> annotation) {
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotation)) {
                return method;
            }
        }
        return null;
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

