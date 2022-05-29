package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone;

import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.tasktwo.User;

import java.util.List;

/**
 * я тут попытался в ООП, чтобы можно было работать со всеми классами, которые реализуют
 * Chat, но возникли проблемы с методами  int getNumberOfUsers() и ist<User> getUsers().
 * Первый используется в ChatWithNumberOfUsers,  но не используется в ChatWithUsers и наоброт.
 */
public interface Chat extends Comparable<Chat> {

    String toString();

    int getNumberOfUsers();
    List<User> getUsers();

    String getName();

    int compareTo(Chat chat);
}