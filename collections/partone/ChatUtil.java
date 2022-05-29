package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone;

import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.tasktwo.User;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@UtilityClass
public final class ChatUtil {

    public static final int TARGET_VALUE = 1000;
    public static final int TARGET_AGE = 18;

    public static void removeIfLessThousand(List<Chat> chats) {
        ListIterator<Chat> chatListIterator = chats.listIterator();
        while (chatListIterator.hasNext()) {
            Chat next = chatListIterator.next();
            if (next.getNumberOfUsers() < TARGET_VALUE) {
                chatListIterator.remove();
            }
        }
    }

    public static List<User> getListOfUsers(List<Chat> chats) {
        List<User> resultList = new ArrayList<>();
        for (Chat chat : chats) {
            List<User> users = chat.getUsers();
            resultList.addAll(users);
        }
        return resultList;
    }

    public static List<User> convertToListOfUsersOlderEighteen(List<Chat> chats) {
        List<User> resultList = new ArrayList<>();
        List<User> users = getListOfUsers(chats);
        for (User user : users) {
            if (user.getAge() > TARGET_AGE) {
                resultList.add(user);
            }
        }
        return resultList;
    }

    public static double averageAgeOfUsers(List<User> users) {
        int age = 0;
        ListIterator<User> iterator = users.listIterator();
        while (iterator.hasNext()) {
            age += iterator.next().getAge();
        }
        return age / (double) users.size();
    }
}





