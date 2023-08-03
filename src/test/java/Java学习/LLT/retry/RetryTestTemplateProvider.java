package Java学习.LLT.retry;

import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class RetryTestTemplateProvider implements TestTemplateInvocationContextProvider {

    private static final int MAX_RETRIES = 5;
    private static final long RETRY_DELAY = 3000;

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        return Stream.of(createInvocationContext(context));
    }

    private TestTemplateInvocationContext createInvocationContext(ExtensionContext context) {
        return new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return "Retry #" + invocationIndex + " : " + context.getDisplayName();
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return Collections.singletonList(new RetryTestExecutionExtension(MAX_RETRIES, RETRY_DELAY));
            }
        };
    }
}

