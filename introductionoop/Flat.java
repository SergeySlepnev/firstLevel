package mentoring.levelone.javacoreleveltwo.introductionoop;

public class Flat {

    int flatId;
    Room[] rooms;

    public Flat(int flatId, Room[] rooms) {
        this.flatId = flatId;
        this.rooms = rooms;
    }

    public void printInformation() {
        System.out.printf("Flat #%d has %d rooms. \n", flatId, rooms.length);
    }

}
