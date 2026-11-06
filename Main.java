import java.util.Scanner;

public class Main{
    Scanner sc = new Scanner(System.in);

    public void validation(){ //login validate
        final String username = "ADMIN";
        final String password = "A1234";

        String attemptUsername = null, attemptPassword = null;
        System.out.println(" \t < This is Student Club Membership System V2 > \n");

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
    }

    public void systemInterface(){
        final String exitOption = "4";
        String attemptOption = "0";

        while(!(attemptOption.equalsIgnoreCase(exitOption))){
            System.out.println("<-----System----->");
            System.out.print(" 1. Club Management \n 2. Membership Management \n 3. Reporting \n 4. Exit\n");
            System.out.print("Please select the features options (1/2/3) or exit: ");

            attemptOption = sc.nextLine();

//Create object
//Club club = new Club();
Membership member = new Membership();
ReportManagement rm = new ReportManagement();

            switch(attemptOption){
                //case "1": club.display(); break;
                case "2": member.display(); break;
                case "3": rm.display(); break;
                case "4": System.out.println("System Exit..."); break;
                default: System.out.println("Invalid options, please try again.");
            }
        }
    }

    public static void main(String[] args) {
// Create objects
        Main main = new Main();

// Main objects
        main.validation(); //Admin login validation
        main.systemInterface(); //Main User-Interface


    }
}

