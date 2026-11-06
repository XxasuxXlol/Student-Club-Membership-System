public class Student{
    private String studentID;
    private String studentName;
    private String studentEmail;
    private String studentProgramme;
    private String studentGender;

    public Student(String id,String name,String email,String programme,String gender){
        setStudent(id,name,email,programme,gender);
    }

    public void setStudent(String id, String name, String email, String programme, String gender){
        studentID = id;
        studentName = name;
        studentEmail = email;
        studentProgramme = programme;
        studentGender = gender;
    }

    public String getStudentId(){
        return studentID;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getStudentEmail(){
        return studentEmail;
    }
    public String getStudentProgramme(){
        return studentProgramme;
    }
    public String getStudentGender(){
        return studentGender;
    }

}
