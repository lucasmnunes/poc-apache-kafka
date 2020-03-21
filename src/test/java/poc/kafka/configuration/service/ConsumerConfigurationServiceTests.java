package poc.kafka.configuration.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class ConsumerConfigurationServiceTests {

    private static final String SERVER_KEY = "server";
    private static final String SERVER_VALUE = "localhost:9092";
    private static final String GROUP_KEY = "group";
    private static final String GROUP_VALUE = "group1";

    @InjectMocks
    private ConsumerConfigurationService service;

    @Test
    public void whenGet_thenReturnConsumerConfiguration() {
        ReflectionTestUtils.setField(service, SERVER_KEY, SERVER_VALUE);
        ReflectionTestUtils.setField(service, GROUP_KEY, GROUP_VALUE);
        assertNotNull(service.get());
    }

}
