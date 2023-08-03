package Java学习.LLT;

import Java学习.LLT.retry.RetryTestTemplateProvider;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

//@RetryConfig(retries = 3, delay = 1000)
//@ExtendWith(RetryExtension.class)
//@RetryTestTemplate
//@RetryExtension.RetryConfig(retries = 3, delay = 3000)
@ExtendWith(RetryTestTemplateProvider.class)
public class MyClassTest {

    @BeforeEach
    public void setUp() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("afterEach");
    }
//    @Test
    @TestTemplate
//    @Test
    public void test() throws Exception {
        System.out.println("test");
        boolean test = false;
        Assertions.assertTrue(test);
//        throw new Exception("test");
    }

    @TestTemplate
    public void test2() throws Exception {
        System.out.println("test2");
        boolean test = true;
        Assertions.assertTrue(test);
    }

    @Test
    public void test3() throws Exception {
        System.out.println("test3");
        boolean test = true;
        Assertions.assertTrue(test);
    }

}