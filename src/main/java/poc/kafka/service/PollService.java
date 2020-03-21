package poc.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.kafka.configuration.service.ConsumerConfigurationService;

import java.time.Duration;
import java.util.Arrays;

@Service
@Slf4j
public class PollService {

    private ConsumerConfigurationService consumerConfigurationService;

    @Autowired
    public PollService(ConsumerConfigurationService consumerConfigurationService) {
        this.consumerConfigurationService = consumerConfigurationService;
    }

    public void receive(String... topic) {
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerConfigurationService.get())) {
            consumer.subscribe(Arrays.asList(topic));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                records.forEach(r -> log.info(r.value()));
            }
        }
    }

}
