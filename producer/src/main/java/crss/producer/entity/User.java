package crss.producer.entity;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String surnames;
    private String id;

    public User(String name, String surnames) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surnames = surnames;
    }

    public User() {
        this.id = UUID.randomUUID().toString();
    }
}
