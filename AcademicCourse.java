//*The AcademiCourse class is a child class of the Course class.
public class AcademicCourse extends Course{
    //Creating instance variables.
    private String lecturerName;
    private String level;
    private String credit;
    private String startingDate;
    private String completionDate;
    private int numberOfAssessments;
    private boolean isRegistered;
    
    /*Creating a Constructor which calls the super class then accepts six instance variables. The parent class and
    parameter variable are assigned to the instance variable and the remaining variables are set to "" or False. */
    public AcademicCourse(String courseID, String courseName, int duration, String level, String credit, int numberOfAssesments){
        
        //A call to the parent class is formed with arguments.
        super(courseID, courseName, duration);
        
        //Assigning instance variables
        this.level = level;
        this.credit = credit;
        this.numberOfAssessments = numberOfAssesments;
        
        //The default values are declared ("") or False.
        this.startingDate = "";
        this.completionDate = "";
        this.lecturerName = "";
        this.isRegistered = false; 
    }
    
    //Getter and Setter methods to return and initialize of a variable
    //Getter method for all instance variable starts from here
    public String getLecturerName(){
        return this.lecturerName;
    }
    
    public String getLevel() {
        return this.level;
    }

    public String getCredit() {
        return this.credit;
    }

    public String getStartingDate() {
        return this.startingDate;
    }

    public String getCompletionDate() {
        return this.completionDate;
    }

    public int getNumberOfAssessments() {
        return this.numberOfAssessments;
    }

    public boolean getIsRegistered() {
        return this.isRegistered;
    }
    //Getter methods ends here.
    
    //Setter method starts from here.
    //Setter method for lecturerName which puts a new value of lecturerName.
    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    //Setter method for numberOfAssesments ehich puts a new value of numberOfAssesments.
    public void setNumberOfAssessments(int numberOfAssessments) {
        this.numberOfAssessments = numberOfAssessments;
    }
    //Setter method ends here.
    
    //If it is not registered, this method creates a new course, and if it is registered, it displays correct information.
    public void register(String courseLeader, String lecturerName, String startingDate, String completionDate) {
        if (getIsRegistered()){
            System.out.println("The course is already registered.");
        }else{
        //courseLeader in parent class is set.
        super.setCourseLeader(courseLeader);
        this.lecturerName = lecturerName;
        this.startingDate = startingDate;
        this.completionDate = completionDate;
        this.isRegistered = true; 
        }
    }
    
    //The display method is established where all the instance variables gives certain string output.
    public void display(){
        String toDisplay = "\nLecturer Name = " + getLecturerName() + "\nLevel = " + getLevel() + "\nCredit = " + getCredit() + "\nStarting Date = " + getStartingDate() + "\nCompletion Date = " + getCompletionDate() + "\nTotal Assessments = " +  getNumberOfAssessments();
        if (getIsRegistered()){
            super.display();
            System.out.print(toDisplay);
        }else
            super.display();
    }
}

