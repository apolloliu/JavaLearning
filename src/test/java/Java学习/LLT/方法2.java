package Java学习.LLT;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
public class 方法2 {

    @MockBean
    private SomeService someService; // 被 @MockBean 修饰的 Mock 对象

    @Test
    void testMethod1() {
        // 使用 lenient() 方法对 someService 进行 Mock 方法的行为
        lenient().when(someService.someMethod()).thenReturn("Mocked Result 1");

        // 执行测试逻辑，使用 mock 的方法
        // ...
    }

    @Test
    void testMethod2() {
        // 使用 lenient() 方法对 someService 进行 Mock 方法的行为
        lenient().when(someService.someMethod()).thenReturn("Mocked Result 2");

        // 执行测试逻辑，使用 mock 的方法
        // ...
    }
}

