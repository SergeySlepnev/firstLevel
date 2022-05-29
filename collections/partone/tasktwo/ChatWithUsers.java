package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.tasktwo;

import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.AbstractChat;
import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.Chat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ChatWithUsers extends AbstractChat implements Chat {

    private List<User> users;

    public ChatWithUsers(String name, List<User> users) {
        super(name);
        this.users = users;
    }

    @Override
    public int getNumberOfUsers() {
        return 0;
    }

    @Override
    public int compareTo(Chat o) {
        return getName().compareTo(o.getName());
    }
}
