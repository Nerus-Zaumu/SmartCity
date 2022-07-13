import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Hotel{
    String name;
    String town;
    int eval;
    int recommendVal;
    int spaces;
    String messageT;
    Boolean T;
    Boolean E;
    String messageE;

    ArrayList<Structure> hotels = Structure.hotels;

    Administrator administrator = new Administrator();

    public Hotel(String name, String town, int eval, int recommendVal, int spaces){
        this.name = name;
        this.town = town;
        this.eval = eval;
        this.recommendVal = recommendVal;
        this.spaces = spaces;
    }

    public Hotel(){
        this("Mawa", "Bamenda", 0, 0, 25);
    }
   

    public void createHotel(String name, String town, int spaces){
        Structure newHotel = new Structure("", "", 0, 0, 0);
        newHotel.name = name;
        newHotel.town = town;
        newHotel.eval = 0;
        newHotel.recommendVal = 0;
        newHotel.availableLodges = spaces;
        for(Structure hotel: hotels){
            if(Objects.equals(hotel.name, name)){
                System.out.println(hotel.name + " already exists");
                Administrator.adminWork();
            }
        }
        hotels.add(newHotel);
        Administrator.adminWork();
    }

    public void deleteHotel(String name){
        for(Structure hotel: hotels){
            if(Objects.equals(hotel.name, name)){
                hotels.remove(hotel);
                System.out.println("Hotel " + hotel.name + " Has been removed");
            }
            else{
                System.out.println("Whooops!!! You are trying to delete a hotels that probably does not exits yet.");
                Administrator.adminWork();
            }
        }
        System.out.println("These are the remaining hotels");
        Administrator.adminWork();
    }

    public void updateHotel(String name){
        for(Structure hotel: hotels){
            if(Objects.equals(hotel.name, name)){
                try(Scanner input = new Scanner(System.in)){
                    System.out.println("Enter new hotel credentials");
                    try {
                        System.out.print("New Name: ");
                        String newName = input.next();
                        hotel.name = newName;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        updateHotel(name);
                    }
                    try {
                        System.out.print("New town");
                        String newTown = input.next();
                        hotel.town = newTown;
                        Administrator.adminWork();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        updateHotel(name);
                        Administrator.adminWork();
                    }
                }
            }
        }
        Administrator.adminWork();
    }

    public void viewHotels(){
        for(Structure hotel: hotels){
         System.out.println("Hotel Name: " + hotel.name + " Town: " + hotel.town + " Evaluation: " + hotel.eval + " Recommendations: " + hotel.recommendVal + " Available Spots " + hotel.availableLodges);
        }
        Administrator.adminWork();
    }

    public void bookHotel(String name){
        for(Structure hotel: hotels){
            if(Objects.equals(hotel.name, name) && hotel.availableLodges!= 0){
                System.out.println("Hotel " + name + " has been booked");
                hotel.recommendVal += 1;
                hotel.availableLodges--;
            }
            if(hotel.recommendVal > 0 && hotel.recommendVal % 10 == 0 && hotel.eval <= 5){
                hotel.eval += 1;
            }
        }
        Client.clientWork();
    }

    public void searchByTown(String town){
        for(Structure hotel: hotels){
            if(Objects.equals(hotel.town, town)){
                System.out.println("Hotel Name: " + hotel.name + " Town: " + hotel.town + " Evaluation: " + hotel.eval + "Recommendations: " + hotel.recommendVal + " Available Spots " + hotel.availableLodges);
            }
            else{
                this.T = false;
                this.messageT = "No hotel belongs in the town you entered";
        }
        Client.clientWork();
    }
    if(!Boolean.TRUE.equals(this.T)){
        System.out.println(this.messageT);
    }
    }

    public void searchByEval(int evaluation){
        for(Structure hotel: hotels){
            if(hotel.eval == evaluation){
                System.out.println("Hotel Name: " + hotel.name + " Town: " + hotel.town + " Evaluation: " + hotel.eval + " Recommendations: " + hotel.recommendVal + " Available Spots " + hotel.availableLodges);
            }
            else{
                this.E = false;
                this.messageE = "No hotel has this evaluation";
            }
        }
        if(!Boolean.TRUE.equals(this.E)){
            System.out.println(this.messageE);
        }
        Client.clientWork();
    }

    public static void clearConsole(){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
  
}