package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.taskone;

import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.Chat;
import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.ChatUtil;
import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.taskone.comaparator.ChatNameComparator;
import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.taskone.comaparator.ChatNumberOfUsersComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatWithNumberOfUsersRunner {

    public static void main(String[] args) {
        List<Chat> source = List.of(
                new ChatWithNumberOfUsers("Friends", 1300),
                new ChatWithNumberOfUsers("Work", 100),
                new ChatWithNumberOfUsers("Hobby", 1000),
                new ChatWithNumberOfUsers("Relatives", 30),
                new ChatWithNumberOfUsers("News", 1020),
                new ChatWithNumberOfUsers("Funny", 4000),
                new ChatWithNumberOfUsers("Art", 1000),
                new ChatWithNumberOfUsers("Cars", 1000)
        );
        ArrayList<Chat> chats = new ArrayList<>(source);
        ChatUtil.removeIfLessThousand(chats);
        chats.sort(new ChatNumberOfUsersComparator().reversed().thenComparing(new ChatNameComparator()));
        Collections.sort(chats);
    }
}
