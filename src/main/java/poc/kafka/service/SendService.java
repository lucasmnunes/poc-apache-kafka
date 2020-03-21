package poc.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.kafka.configuration.service.ProducerConfigurationService;

@Service
@Slf4j
public class SendService {

    private ProducerConfigurationService producerConfigurationService;

    @Autowired
    public SendService(ProducerConfigurationService producerConfigurationService) {
        this.producerConfigurationService = producerConfigurationService;
    }

    public void send(String topic, String message) {
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(producerConfigurationService.get())) {
            producer.send(new ProducerRecord<>(topic, message));
        }
    }

}
