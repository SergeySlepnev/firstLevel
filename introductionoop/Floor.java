package mentoring.levelone.javacoreleveltwo.introductionoop;

public class Floor {

    int floorId;
    Flat[] flats;

    public Floor(int floorId, Flat[] flats) {
        this.floorId = floorId;
        this.flats = flats;
    }

    public void printInformation() {
        System.out.printf("Floor #%d has %d flats. \n", floorId, flats.length);
    }

    public int getNumberOfRoomsOnFloor() {
        int countOfRooms = 0;
        for (Flat flat : flats) {
            countOfRooms += flat.rooms.length;
        }
        return countOfRooms;
    }
}
