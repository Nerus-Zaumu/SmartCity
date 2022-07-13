import java.util.ArrayList;
import java.util.Scanner;

public class Administrator{

    ArrayList<Hotel> hotels = new ArrayList<>();

    public static void main(String[] args){
        adminWork();
    }

    public static void adminWork(){
        Hotel adminHotel = new Hotel();
        System.out.println("Welcome to Smart City where we provide you with the best hotels available");
        System.out.println("What do you want to do? ");
        System.out.println("0: To Exit\n1: To Create new Hotel\n2: To delete Hotel\n3: To Update Hotel\n4: To view hotels");
        try (Scanner input = new Scanner(System.in)) {
            int adminInput = input.nextInt();
            if(adminInput == 1){
                System.out.println("Enter Hotel name: ");
                String name = input.next();
                System.out.println("Enter town: ");
                String town = input.next();
                System.out.println("Enter number of available spaces");
                int spaces = input.nextInt();
                adminHotel.createHotel(name, town, spaces);
            }
            if(adminInput == 2){
                System.out.println("Enter name of hotel to be deleted: ");
                String hotelName = input.next();
                adminHotel.deleteHotel(hotelName);
                adminWork();
            }
            if(adminInput == 3){
                System.out.println("Enter name of hotel to be Updated: ");
                String onUpdate = input.next();
                adminHotel.updateHotel(onUpdate);
            }
            if(adminInput == 4){
                System.out.println("This is the list of available hotels");
                adminHotel.viewHotels();
            }

            if(adminInput == 0){
                System.out.println("Goodbye!!!");
                Hotel.clearConsole();
                Smart.main(null);
            }
            else{
                System.out.println("Wrong input");
                adminWork();
            }

        }
    }

}