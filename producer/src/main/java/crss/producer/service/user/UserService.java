package crss.producer.service.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import crss.producer.entity.User;
import crss.producer.repository.UserRepository;

@Service
public class UserService {

    // Java Annotations
    // 1. @Autowired: Inject the dependencies with constructor
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    public String addUser(User user) throws JsonProcessingException {
        userRepository.addUser(user);
        return userProducer.sendMessage(user);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
