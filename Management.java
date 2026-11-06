import java.util.ArrayList;
import java.util.Scanner;

abstract class Management{
    protected String id;
    protected String name;
    Scanner sc = new Scanner(System.in);

    public abstract void register();
    public abstract void view();
    public abstract void display();
}

/*class Club extends Management{
    public void register(){

    }
    public void view(){

    }
}*/

class Membership extends Management{
    private String programme;
    private String email;
    private String gender;
    private boolean status;

    private ArrayList<Student> studentList = new ArrayList<>();

    public boolean duplicateValidation(String id){
        for(Student student: studentList){
            if(student.getStudentId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    public void register() {
        /*
        -----Constrain for each input information.-----
        Firstly, all data should not be empty [use isEmpty() method].
        Secondly, no duplicated student ID (unique).
        Thirdly, limit the length of character.
        ---------------------End-----------------------
        */
        String confirmation;

        do{
        System.out.println("Please enter your student ID: ");
        id = sc.nextLine();
            while(id.isEmpty() || duplicateValidation(id)){
                if(id.isEmpty()){
                    System.out.println("Student ID cannot be empty. Please enter again: ");
                    id = sc.nextLine().trim();
                }
                else{
                    System.out.println("Duplicated student ID. Please enter again: ");
                    id = sc.nextLine().trim();
                }
            }

        System.out.println("Please enter your name: ");
        name = sc.nextLine().trim().toUpperCase();
            while(name.isEmpty()){
                System.out.println("Student name cannot be empty. Please try again: ");
                name = sc.nextLine().trim();
            }

        System.out.println("Please enter your student email: ");
        email = sc.nextLine().trim();
            while(email.isEmpty()){
                System.out.println("Student email cannot be empty. Please try again: ");
                email = sc.nextLine().trim();
            }
        System.out.println("Please enter your programme: ");
        programme = sc.nextLine().trim();
            while(programme.isEmpty()){
                System.out.println("Programme cannot be empty. Please try again: ");
                programme = sc.nextLine().trim();
            }

        System.out.println("Please enter your gender (Male/Female): ");
        gender = sc.nextLine().trim().toUpperCase();
            while(gender.isEmpty() || (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")))){
                if(gender.isEmpty()) {
                    System.out.println("Gender cannot be empty. Please try again: ");
                    gender = sc.nextLine().trim();
                }
                else{
                    System.out.println("Invalid gender. Please enter again: ");
                    gender = sc.nextLine().trim();
                }
            }

        Student student = new Student(id, name, email, programme, gender);
        studentList.add(student);

        System.out.println("Member registered successfully!");
        System.out.println("------Registered member------");
        System.out.print("Student ID: " + id + "\nStudent Name: " + name + "\nStudent Email: " + email + "\nProgramme: " + programme + "\nGender: " + gender + "\n");
        System.out.println("-----------------------------");

        System.out.println("Do you want to continue your registration(Y/N)? : ");
        confirmation = sc.nextLine().trim();

            while (!(confirmation.equalsIgnoreCase("Y") || confirmation.equalsIgnoreCase("N"))) {
                System.out.println("Invalid input, please try again(Y/N): ");
                confirmation = sc.nextLine().trim();
            }
        } while(confirmation.equalsIgnoreCase("Y"));
    }

    public void remove(){
        System.out.print("Enter a student ID that want to remove: ");
        id = sc.nextLine().trim();
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getStudentId().equalsIgnoreCase(id)){
                studentList.remove(i);
                System.out.println("Member remove successfully.");
            }
            else{
                System.out.println("Student ID not found!");
            }
        }
    }
    public void view(){
        System.out.println("\t<<<<<<<<<< \tClub List Members\t >>>>>>>>>\t");
        for(Student student: studentList){
            System.out.print(
                "Student ID: " + student.getStudentId() + "\t |" +
                "Student Name: " + student.getStudentName() + "\t |" +
                "Student Email: " + student.getStudentEmail() + "\t |" +
                "Programme: " + student.getStudentProgramme() + "\t |" +
                "Gender: " + student.getStudentGender() + " |\n"
            );
        }
    }

    public void search(){
        System.out.println("Search member by entering student ID");
    }

    public void checkMemberStatus(){

        System.out.println("Enter student ID to check status:");
        id = sc.nextLine().trim();

        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getStudentId().equalsIgnoreCase(id)){
                System.out.println("Membership status: Active");
            }
            else{
                System.out.println("Membership status: Deactivate/Not exist");
            }
        }

    }

    public void display() {
        String option;
        do{
        System.out.println("<-----Membership Management------>");

            System.out.print(" 1.Register\n 2.Remove\n 3.View\n 4.Search\n 5.Check Status\n 6.Exit to previous page\n");

            System.out.println("Choose the features that you would like to access: ");
            option = sc.nextLine();

                switch(option) {
                    case "1": register(); break;
                    case "2": remove(); break;
                    case "3": view(); break;
                    case "4": search(); break;
                    case "5": checkMemberStatus(); break;
                    case "6": System.out.println("Returning to previous page..."); break;
                    default: System.out.println("Invalid option, please try again!");
                }
            }while(!(option.equals("6")));
        }
    }
