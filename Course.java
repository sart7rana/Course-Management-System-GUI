//Course is a parent class.
public class Course{
    //Creating instance variables.
    private String courseID;
    private String courseName;
    private String courseLeader;
    private int duration;
    
    
    //Creating a Constructor which accepts three instance variables and the courseLeader is initialized with empty string ("")
    public Course(String courseID, String courseName, int duration){
        this.courseID = courseID;
        this.courseName = courseName;
        this.duration = duration;
        this.courseLeader = "";
    }
    
    //Getter and Setter methods to return and initialize of a variable.
    //Getter method for all instance variable starts from here.
    public String getCourseID(){
        return this.courseID;
    }
    
    public String getCourseName(){
        return this.courseName;
    }
    
    public String getCourseLeader(){
        return this.courseLeader;
    }
    
    public int getDuration(){
        return this.duration;
    }
    //Getter method ends here.
    
    //Setter method starts from here.
    //Setter method for courseLeader which puts a new value of courseLeader.
    public void setCourseLeader(String courseLeader){
        this.courseLeader = courseLeader;
    }
    //Setter method ends here.
    
    //The display method is established where all the instance variables gives certain string output.
    public void display(){
        String toDisplay = "Course ID = " + getCourseID() + "\nCourse Name = " + getCourseName() + "\nDuration = " + getDuration();
        if(getCourseLeader().equals(""))
            System.out.print(toDisplay);
        else
            System.out.print(toDisplay + "\nCourse Leader = " + getCourseLeader());
    }
}

