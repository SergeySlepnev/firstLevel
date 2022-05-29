package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.tasktwo;

import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.Chat;
import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.ChatUtil;

import java.util.ArrayList;
import java.util.List;

public class ChatWithUsersRunner {

    public static void main(String[] args) {
        List<User> sourceUsersOne = List.of(
                new User(1, "Ivan", 17),
                new User(6, "Misha", 19),
                new User(2, "Lena", 16),
                new User(5, "Vera", 33),
                new User(8, "Kirill", 31),
                new User(9, "Dima", 40)
        );
        List<User> sourceUsersTwo = List.of(
                new User(11, "Olya", 27),
                new User(16, "Lesha", 29),
                new User(12, "Katya", 26),
                new User(13, "Dima", 13),
                new User(18, "Kirill", 17),
                new User(19, "Lena", 25)
        );
        List<User> usersOne = new ArrayList<>(sourceUsersOne);
        List<User> usersTwo = new ArrayList<>(sourceUsersTwo);
        List<Chat> sourceChatWithUsers = List.of(
                new ChatWithUsers("FirstChat", usersOne),
                new ChatWithUsers("SecondChat", usersTwo)
        );
        List<Chat> chatWithUsers = new ArrayList<>(sourceChatWithUsers);
        List<User> users = ChatUtil.convertToListOfUsersOlderEighteen(chatWithUsers);
        double averageAgeOfUsers = ChatUtil.averageAgeOfUsers(users);
    }
}
