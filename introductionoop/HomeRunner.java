package mentoring.levelone.javacoreleveltwo.introductionoop;

public class HomeRunner {

    public static void main(String[] args) {
        Room firstRoom = new Room(1, true);
        Room secondRoom = new Room(2, false);
        Room thirdRoom = new Room(3, false);
        Room[] rooms = {firstRoom, secondRoom, thirdRoom};
        System.out.println("Testing printInformation method for room:");
        firstRoom.printInformation();
        System.out.println("-------------------------");

        Flat firstFlat = new Flat(1, rooms);
        Flat secondFlat = new Flat(2, rooms);
        Flat thirdFlat = new Flat(3, rooms);
        Flat fourthFlat = new Flat(4, rooms);
        Flat[] flats = {firstFlat, secondFlat, thirdFlat, fourthFlat};
        System.out.println("Testing printInformation method for flat:");
        firstFlat.printInformation();
        System.out.println("-------------------------");

        Floor firstFloor = new Floor(1, flats);
        Floor secondFloor = new Floor(2, flats);
        Floor thirdFloor = new Floor(3, flats);
        Floor[] floors = {firstFloor, secondFloor, thirdFloor};
        System.out.println("Testing printInformation method for floor:");
        firstFloor.printInformation();
        System.out.println("-------------------------");

        Home home = new Home(4, floors);
        System.out.println("Testing printInformation method for home:");
        home.printInformation();
        System.out.println("-------------------------");
        System.out.println("Testing printAllInformation method for home: \n");
        home.printAllInformation(home);
    }

}
