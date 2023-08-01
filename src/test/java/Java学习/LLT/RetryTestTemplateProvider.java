//package Java学习.LLT;
//
//import org.junit.jupiter.api.extension.*;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//public class RetryTestTemplateProvider implements TestTemplateInvocationContextProvider {
//
//    private static final int MAX_RETRIES = 3;
//    private static final long RETRY_DELAY = 1000;
//
//    @Override
//    public boolean supportsTestTemplate(ExtensionContext context) {
//        return true;
//    }
//
//    @Override
//    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
//        return Stream.of(createInvocationContext());
//    }
//
//    private TestTemplateInvocationContext createInvocationContext() {
//        return new TestTemplateInvocationContext() {
//            @Override
//            public String getDisplayName(int invocationIndex) {
//                return "Retry #" + invocationIndex;
//            }
//
//            @Override
//            public List<Extension> getAdditionalExtensions() {
//                return List.of(new RetryTestExecutionExtension(MAX_RETRIES, RETRY_DELAY));
//            }
//        };
//    }
//}
