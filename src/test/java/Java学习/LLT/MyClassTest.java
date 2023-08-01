package Java学习.LLT;

import Java学习.LLT.retry.RetryTestTemplateProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

//@RetryConfig(retries = 3, delay = 1000)
//@ExtendWith(RetryExtension.class)
//@RetryTestTemplate
//@RetryExtension.RetryConfig(retries = 3, delay = 3000)
@ExtendWith(RetryTestTemplateProvider.class)
class MyClassTest {

//    @Test
    @TestTemplate
//    @Test
    public void test() throws Exception {
        System.out.println("test");
        boolean test = false;
        Assertions.assertTrue(test);
//        throw new Exception("test");
    }
}