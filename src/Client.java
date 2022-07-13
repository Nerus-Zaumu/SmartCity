import java.util.Scanner;

public class Client{

    public static void main(String[] args){
        loadHotelsForClient();
        clientWork();
    }

    public static void clientWork(){
        Hotel clientHotel = new Hotel();
        System.out.println("Welcome to Smart City where we provide you with the best hotels available");
        System.out.println("What do you want to do? ");
        System.out.println("0: To Exit\n1: To Book hotel\n2: To search by town\n3: To search by evaluation");
        try(Scanner input = new Scanner(System.in)){
            int clientInput = input.nextInt();
            if(clientInput == 1){
                System.out.println("Enter name of hotel you want to book");
                String name = input.next();
                try {
                    clientHotel.bookHotel(name);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if(clientInput == 2){
                System.out.println("Enter town: ");
                String town = input.next();
                try {
                    clientHotel.searchByTown(town);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if(clientInput == 3){
                System.out.println("Enter evaluation: ");
                int evaluation = input.nextInt();
                try {
                    clientHotel.searchByEval(evaluation);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if(clientInput == 0){
                System.out.println("Goodbye!!!");
                Hotel.clearConsole();
                Smart.main(null);
            }
            else{
                System.out.println("wrong input");
                clientWork();
            }
        }
    }

    public static void loadHotelsForClient(){
        
        Structure tempHotel1 = new Structure();
        Structure tempHotel2 = new Structure();
        Structure tempHotel3 = new Structure();
        Structure tempHotel4 = new Structure();
        Structure tempHotel5 = new Structure();

        tempHotel1.name =  "Mawa";
        tempHotel1.town =  "Bamenda";
        tempHotel1.eval =  0;
        tempHotel1.recommendVal =  0;

        tempHotel2.name =  "Pearl";
        tempHotel2.town =  "Bamenda";
        tempHotel2.eval =  0;
        tempHotel2.recommendVal =  0;

        tempHotel3.name =  "Crystal";
        tempHotel3.town =  "Buea";
        tempHotel3.eval =  0;
        tempHotel3.recommendVal =  0;

        tempHotel4.name =  "Hilton";
        tempHotel4.town =  "Yaounde";
        tempHotel4.eval =  0;
        tempHotel4.recommendVal =  0;

        tempHotel5.name =  "Ville";
        tempHotel5.town =  "Douala";
        tempHotel5.eval =  0;
        tempHotel5.recommendVal =  0;
        Structure.hotels.add(tempHotel1);
        Structure.hotels.add(tempHotel2);
        Structure.hotels.add(tempHotel3);
        Structure.hotels.add(tempHotel4);
        Structure.hotels.add(tempHotel5);
    }
}