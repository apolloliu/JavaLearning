package Java学习.LLT;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

@SpringBootTest
public class 方法4 {

    @Test
    void testMethod1() {
        // 使用手动创建的 Mock 对象
        SomeService mockService = mock(SomeService.class);
        // 对 mockService 进行适当的配置

        // 执行测试逻辑，使用 mockService
    }

    @Test
    void testMethod2() {
        // 使用手动创建的 Mock 对象
        SomeService mockService = mock(SomeService.class);
        // 对 mockService 进行适当的配置

        // 执行测试逻辑，使用 mockService
    }
}

