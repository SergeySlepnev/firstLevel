package mentoring.levelone.javacoreleveltwo.introductionoop;

public class Home {

    private int homeId;
    private Floor[] floors;

    public Home(int homeId, Floor[] floors) {
        this.homeId = homeId;
        this.floors = floors;
    }

    public void printInformation() {
        System.out.printf("The home #%d has %d floors. \n", homeId, floors.length);
    }

    private int getNumbersOfRoomsInHome() {
        int numberOfRoomInHouse = 0;
        for (Floor floor : floors) {
            numberOfRoomInHouse += floor.getNumberOfRoomsOnFloor();
        }
        return numberOfRoomInHouse;
    }

    private int getNumbersOfFlatInHome() {
        int numbersOfFlat = 0;
        for (Floor floor : floors) {
            numbersOfFlat += floor.flats.length;
        }
        return numbersOfFlat;
    }

    public void printAllInformation(Home home) {
        int numbersOfFlat = getNumbersOfFlatInHome();
        int numbersOfRooms = getNumbersOfRoomsInHome();
        System.out.printf("Home #%d has %d floors, %d flats and %d rooms. \n\n", homeId, floors.length, numbersOfFlat, numbersOfRooms);
        for (Floor floor : home.floors) {
            floor.printInformation();
            for (Flat flat : floor.flats) {
                System.out.print(" -");
                flat.printInformation();
                for (Room room : flat.rooms) {
                    System.out.print("   -");
                    room.printInformation();
                }
                System.out.println();
            }
        }
    }
}
