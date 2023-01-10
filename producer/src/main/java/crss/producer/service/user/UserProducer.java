package crss.producer.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import crss.producer.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

// @Slf4j
@Component
public class UserProducer {

    @Value("${topic.name}")
    private String userTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(User user) throws JsonProcessingException {
        String userAsMessage = objectMapper.writeValueAsString(user);
        kafkaTemplate.send(userTopic, userAsMessage);
        System.out.println("user produced");

        return "message sent";
    }
}
