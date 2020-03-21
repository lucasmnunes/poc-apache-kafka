package poc.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import poc.kafka.service.PollService;
import poc.kafka.service.SendService;

@SpringBootApplication
public class POCApacheKafkaApplication implements CommandLineRunner {

    @Value("${kafka.topic}")
    private String topic;

    private SendService sendService;
    private PollService pollService;

    @Autowired
    POCApacheKafkaApplication(SendService sendService, PollService pollService) {
        this.sendService = sendService;
        this.pollService = pollService;
    }

    public static void main(String[] args)  {
        SpringApplication.run(POCApacheKafkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //sendService.send(topic, "Test message!");
        //pollService.receive(topic);
    }

}
