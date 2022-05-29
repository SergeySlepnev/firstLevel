package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.taskone.comaparator;

import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.Chat;

import java.util.Comparator;

public class ChatNumberOfUsersComparator implements Comparator<Chat> {

    @Override
    public int compare(Chat chatOne, Chat chatTwo) {
        return Integer.compare(chatOne.getNumberOfUsers(), chatTwo.getNumberOfUsers());
    }
}
