package poc.kafka.configuration.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class ProducerConfigurationServiceTests {

    private static final String SERVER_KEY = "server";
    private static final String SERVER_VALUE = "localhost:9092";

    @InjectMocks
    private ProducerConfigurationService service;

    @Test
    public void whenGet_thenReturnProducerConfiguration() {
        ReflectionTestUtils.setField(service, SERVER_KEY, SERVER_VALUE);
        assertNotNull(service.get());
    }

}
