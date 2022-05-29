package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractChat {

    protected String name;

    public AbstractChat(String name) {
        this.name = name;
    }
}
