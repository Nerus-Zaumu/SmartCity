import java.util.Scanner;

public class Smart extends Hotel{
    public Smart(){
        super("", "", 0, 0, 25);
    }
    public static void main(String[] args){
        System.out.println("###############WELCOME TO SMART CITY####################");
        System.out.println("######\n1:TO LOGIN AS ADMIN\n2:TO LOGIN IN AS CLIENT\nANYTHING ELSE TO EXIT: #########");
        try {
            try(Scanner input = new Scanner(System.in)){
                int userInput = input.nextInt();
                if(userInput == 1){
                    System.out.println("ENTER ADMIN KEY!: ");
                    int adminKey = input.nextInt();
                    if(adminKey == 666){
                        Administrator.main(args);
                     }
                     else{
                        System.out.println("Wrong admin key!");
                        main(args);
                     }
                }
                if(userInput == 2){
                    Client.main(args);
                }
                else{
                    System.out.println("Goodbye!!!");
                    clearConsole();
                }
    
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 }

