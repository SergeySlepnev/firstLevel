package mentoring.levelone.javacoreleveltwo.introductionoop;

public class Room {

    int roomId; // я знаю, что по условию у комнаты нет id, но без него криво как-то.
    boolean isPassage;

    public Room(int roomId, boolean isPassage) {
        this.isPassage = isPassage;
        this.roomId = roomId;
    }

    public void printInformation() {
        if (isPassage) {
            System.out.printf("Room #%d is passage. \n", roomId);
        } else {
            System.out.printf("Room #%d is not passage. \n", roomId);
        }
    }
}
