package crss.producer.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import crss.producer.entity.User;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }
}
