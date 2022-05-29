package dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.taskone.comaparator;

import dmdev.mentoring.levelone.coreleveltwo.homework.collections.partone.Chat;

import java.util.Comparator;

public class ChatNameComparator implements Comparator<Chat> {

    @Override
    public int compare(Chat chatOne, Chat chatTwo) {
        return chatOne.getName().compareTo(chatTwo.getName());
    }
}
