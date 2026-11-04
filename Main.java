import java.util.*;

public class Main{
    public static void main(String[] args) {
        final String username = "ADMIN";
        final String password = "A1234";
        final String exitOption = "4";

        String attemptUsername = null, attemptPassword = null;
        Scanner sc = new Scanner(System.in);

        System.out.println(" \t < This is Student Club Membership System V1 > \n");

// User Validation - Start
        do {
            System.out.println("Please enter your username and password> ");

            while(!(attemptUsername != null && attemptUsername.equalsIgnoreCase(username) && attemptPassword.equalsIgnoreCase(password))){
                System.out.print("Username: ");
                attemptUsername = sc.nextLine();

                System.out.print("Password: ");
                attemptPassword = sc.nextLine();

                if(!(attemptUsername.equalsIgnoreCase(username) && attemptPassword.equalsIgnoreCase(password))){
                    System.out.println("Incorrect username or password, please try again.");
                }
            }
                if(attemptUsername.equalsIgnoreCase(username) && attemptPassword.equalsIgnoreCase(password)){
                    System.out.println("----------------------------------");
                    System.out.println("Welcome to Student Club Membership System!");
                    break;
                }
            }while(attemptUsername.equalsIgnoreCase(username) && attemptPassword.equalsIgnoreCase(password));
// User validation -- End

// Main System interface -- Start
        String attemptOption = "0";

        while(!(attemptOption.equalsIgnoreCase(exitOption))){
        System.out.print(" 1. Club Management \n 2. Membership Management \n 3. Reporting \n");
        System.out.print("Please select the features options (1/2/3): ");
        attemptOption = sc.nextLine();

            switch(attemptOption){
                case "1": System.out.println("Obj Club Management..."); break;
                case "2": System.out.println("Obj Membership Management..."); break;
                case "3": System.out.println("Obj Reporting..."); break;
                case "4": System.out.println("System Exit..."); break;
                default: System.out.println("Invalid options, please try again.");
            }
        }
// Main System Interface -- End

    }
}

