
//*The NonAcademiCourse class is a child class of the Course class.
public class NonAcademicCourse extends Course {
    //Creating instance variables
    private String instructorName;
    private String startingDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private boolean isRegistered;
    private boolean isRemoved;
    
    /*Creating a Constructor which calls the super class then accepts four instance variables. The parent class and
    parameter variable are assigned to the instance variable and the remaining variables are set to "" or False. */
    public NonAcademicCourse(String courseID, String courseName, int duration, String prerequisite) {

        //A call to the parent class is formed with arguments.
        super(courseID, courseName, duration);

        //Assigning instance variables.
        this.prerequisite = prerequisite;
        
        //The default values are declared ("") or False.
        this.startingDate = "";
        this.completionDate = "";
        this.examDate = "";
        this.isRegistered = false;
        this.isRemoved = false;
    }
    
    //Getter and Setter methods to return and initialize of a variable.
    //Getter method for all instance variable starts from here.
    public String getInstructorName() {
        return this.instructorName;
    }

    public String getStartingDate() {
        return this.startingDate;
    }

    public String getCompletionDate() {
        return this.completionDate;
    }

    public String getExamDate() {
        return this.examDate;
    }

    public String getPrerequisite() {
        return this.prerequisite;
    }

    public boolean getIsRegistered() {
        return this.isRegistered;
    }

    public boolean getIsRemoved() {
        return this.isRemoved;
    }
    //Getter methods ends here.
    
    //Setter method starts from here.
    //Setter method for instructorName which puts a new value of instructorName.
    public void setInstructorName(String instructorName) {
        if (getIsRegistered())
            System.out.println("The instructor name is already registered and cannot be changed.");
        else
            this.instructorName = instructorName;
    }
    //Setter method ends here.
    
    //This methods takes four arguments that helps to register the particular course.
    public void register(String courseLeader, String instructorName, String startingDate, String completionDate, String examDate){
        if (getIsRegistered()){
            System.out.println("The course is already registered.");
        }
        else {
            this.setInstructorName(instructorName);
            this.isRegistered = true;
            this.startingDate = startingDate;
            super.setCourseLeader(courseLeader);
            this.completionDate = completionDate;
            this.examDate = examDate;
        }
    }

    //If it is not removed, this method removes a new course, and if it is removed, it displays correct information.
    public void remove(){
        if (getIsRemoved()){
            System.out.println("The course is already removed.");
        }
        else {
            super.setCourseLeader("");
            this.instructorName = "";
            this.startingDate = "";
            this.completionDate = "";
            this.examDate = "";
            this.isRegistered = false;
            this.isRemoved = true;
        }
    }
    
    //The display method is established where all the instance variables gives certain string output.
    public void display(){
        String toDisplay = "\nInstructor Name = " +getInstructorName() + "\nStarting Date = " + getStartingDate() + "\nCompletion Date" + getCompletionDate() + "\nExamination Date = " + getExamDate();
        if (getIsRegistered()){
            super.display();
            System.out.print(toDisplay);
        }else
            super.display();
    }
}
