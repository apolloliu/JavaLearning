package Java学习.LLT;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
public class 方法3 {

    @MockBean
    private SomeService someService; // 被 @MockBean 修饰的 Mock 对象

    @Test
    void testMethod1() {
        // 对 someService 进行适当的配置和 Mock 方法的行为
        when(someService.someMethod()).thenReturn("Mocked Result 1");

        // 执行测试逻辑，使用 mock 的方法
        // ...
    }

    @Test
    void testMethod2() {
        // 对 someService 进行适当的配置和 Mock 方法的行为
        when(someService.someMethod()).thenReturn("Mocked Result 2");

        // 执行测试逻辑，使用 mock 的方法
        // ...
    }

    @AfterEach
    void resetMocks() {
        // 在每个测试方法结束后重置 Mock 对象
        reset(someService);
    }
}
