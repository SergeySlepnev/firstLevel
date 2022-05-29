package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.taskone;

import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.AbstractChat;
import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.Chat;
import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.tasktwo.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ChatWithNumberOfUsers extends AbstractChat implements Chat {

    private int numberOfUsers;

    public ChatWithNumberOfUsers(String name, int numberOfUsers) {
        super(name);
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public int compareTo(Chat o) {
        return getName().compareTo(o.getName());
    }
}
