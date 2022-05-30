import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class INGCollege
{
    private JFrame jf, Academic_display_jf, NAcademic_display_jf;
    private JPanel WPjpane, ACjpane, NCjpane;
    private JLabel lbl_WP, lbl_WP_to, lbl_WP_m, lbl_WP_f, lbl_WP_CT, lbl_pb, lbl_Academic, lbl_Academic_ID, lbl_Academic_Name, 
                   lbl_Academic_Duration, lbl_Academic_Level, lbl_Academic_Credit, lbl_Academic_NOA, lbl_Academic_Leader, lbl_Academic_Lecturer,
                   lbl_Academic_SDate, lbl_Academic_CDate, lbl_NAcademic, lbl_NAcademic_ID, lbl_NAcademic_Name, lbl_NAcademic_Prerequiste,
                   lbl_NAcademic_Duration, lbl_NAcademic_Leader, lbl_NAcademic_Instructor, lbl_NAcademic_EDate, lbl_NAcademic_SDate, 
                   lbl_NAcademic_CDate;
    private JTextField txt_Academic_ID, txt_Academic_Name, txt_Academic_Duration, txt_Academic_Level, txt_Academic_Credit, txt_Academic_NOA,
                       txt_Academic_Leader, txt_Academic_Lecturer, txt_Academic_SDate, txt_Academic_CDate, txt_NAcademic_ID, txt_NAcademic_Name, 
                       txt_NAcademic_Prerequiste, txt_NAcademic_Duration, txt_NAcademic_Leader, txt_NAcademic_Instructor, txt_NAcademic_EDate,
                       txt_NAcademic_SDate, txt_NAcademic_CDate;      
    private JButton btn_WP_AC, btn_WP_NC, btn_Academic_add, btn_Academic_Register, btn_NAcademic, btn_Academic_Clear, btn_Academic_Display,
                    btn_NAcademic_add, btn_NAcademic_Register, btn_NAcademic_Remove, btn_Academic, btn_NAcademic_Clear, btn_NAcademic_Display; 
    private Font fnt1, fnt2, fnt3, fnt4;
    private Icon ing, islington;
    private JTable Academic_table, NAcademic_table;
    private DefaultTableModel Academic_table_model, NAcademic_table_model;
    private ArrayList<Course> academicCourseList, nonAcademicCourseList;
    
    ///Constructor class starts from here
    public INGCollege()
    {
        ///Creating frame for Course
        jf = new JFrame("Course");
        jf.setBounds(10,10,1400,900);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        
        ///Font for title
        fnt1 = new Font("Areal",Font.BOLD,65);
        
        ///Font for text fields, labels and buttons
        fnt2 = new Font("Areal",Font.PLAIN,28); 
        
        ///Font for Welcome
        fnt3 = new Font("Areal",Font.BOLD,80); 
        
        ///Font for text of welcome page
        fnt4 = new Font("Areal",Font.BOLD,28);
        
        ///Creating pannel for welcome page
        WPjpane = new JPanel();
        WPjpane.setBounds(0,0,1500,1000);
        WPjpane.setLayout(null);
        WPjpane.setBackground(Color.BLACK);
        
        ///Add logo in welcome page
        ing = new ImageIcon(getClass().getResource("ING-Group.png"));
        JLabel img1 = new JLabel(ing);
        img1.setBounds(40,185,250,250);
        WPjpane.add(img1);
        
        islington = new ImageIcon(getClass().getResource("islington-logo.png"));
        JLabel img2 = new JLabel(islington);
        img2.setBounds(40,480,250,250);
        WPjpane.add(img2);
        
        ///For Welcome 
        lbl_WP = new JLabel("Welcome");
        lbl_WP.setBounds(400,170,500,70); //220
        lbl_WP.setFont(fnt1);
        lbl_WP.setForeground(Color.WHITE);
        WPjpane.add(lbl_WP);
        
        ///for To
        lbl_WP_to = new JLabel("To");
        lbl_WP_to.setBounds(400,255,500,90); //290
        lbl_WP_to.setFont(fnt3);
        lbl_WP_to.setForeground(Color.WHITE);
        WPjpane.add(lbl_WP_to);
        
        ///for message
        lbl_WP_m = new JLabel("Course Registration");
        lbl_WP_m.setBounds(530,255,850,90); //290
        lbl_WP_m.setFont(fnt3);
        lbl_WP_m.setForeground(new Color(136,145,51));
        WPjpane.add(lbl_WP_m);
        
        ///for form
        lbl_WP_f = new JLabel("Form");
        lbl_WP_f.setBounds(400,340,500,100); //370
        lbl_WP_f.setFont(fnt3);
        lbl_WP_f.setForeground(new Color(136,145,51));
        WPjpane.add(lbl_WP_f);
        
        ///for Course Type
        lbl_WP_CT = new JLabel("Select your course type");
        lbl_WP_CT.setBounds(400,470,500,100);
        lbl_WP_CT.setFont(fnt4);
        lbl_WP_CT.setForeground(Color.WHITE);
        WPjpane.add(lbl_WP_CT);
        
        ///AC Button
        btn_WP_AC = new JButton("Academic Course");
        btn_WP_AC.setBounds(400,570,260,60);
        btn_WP_AC.setFont(fnt2);
        WPjpane.add(btn_WP_AC);
        
        ///NC Button
        btn_WP_NC = new JButton("Non Academic Course");
        btn_WP_NC.setBounds(670,570,320,60);
        btn_WP_NC.setFont(fnt2);
        WPjpane.add(btn_WP_NC);
        
        ///Powered By
        lbl_pb = new JLabel("Powered By : Sarthak Bikram Rana");
        lbl_pb.setBounds(400,730,550,50);
        lbl_pb.setFont(fnt4);
        lbl_pb.setForeground(Color.WHITE);
        WPjpane.add(lbl_pb);
        
        ///Creating Pannel for AC
        ACjpane = new JPanel();
        ACjpane.setBounds(0,0,1500,1000); 
        ACjpane.setLayout(null);
        ACjpane.setBackground(new Color(255,249,230)); 
            
        ///Creating title Academic Courses
        lbl_Academic = new JLabel("Academic Course");
        lbl_Academic.setBounds(515,55,600,60);
        lbl_Academic.setFont(fnt1);
        lbl_Academic.setForeground(new Color(136,145,51)); 
        ACjpane.add(lbl_Academic);
        
        ///Creating CourseID
        lbl_Academic_ID = new JLabel("Course ID:");
        lbl_Academic_ID.setBounds(145,180,170,50);
        lbl_Academic_ID.setForeground(Color.BLACK);
        lbl_Academic_ID.setFont(fnt2);
        ACjpane.add(lbl_Academic_ID);
        ///Creating CourseID text field
        txt_Academic_ID = new JTextField();
        txt_Academic_ID.setBounds(300,193,200,30);
        txt_Academic_ID.setBackground(Color.WHITE); 
        ACjpane.add(txt_Academic_ID);
        
        ///Creating Course Name
        lbl_Academic_Name = new JLabel("Course Name:");
        lbl_Academic_Name.setBounds(555,180,190,50);
        lbl_Academic_Name.setForeground(Color.BLACK);
        lbl_Academic_Name.setFont(fnt2);
        ACjpane.add(lbl_Academic_Name); 
        ///Creating Course Name text field
        txt_Academic_Name = new JTextField();
        txt_Academic_Name.setBounds(760,193,200,30);
        txt_Academic_Name.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_Name);
        
        ///Creating Duration
        lbl_Academic_Duration = new JLabel("Duration:");
        lbl_Academic_Duration.setBounds(1005,180,130,50);
        lbl_Academic_Duration.setForeground(Color.BLACK);
        lbl_Academic_Duration.setFont(fnt2);
        ACjpane.add(lbl_Academic_Duration);
        ///Creating Duration text field
        txt_Academic_Duration = new JTextField();
        txt_Academic_Duration.setBounds(1145,193,200,30);
        txt_Academic_Duration.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_Duration);
        
        ///Creating Level
        lbl_Academic_Level = new JLabel("Level:");
        lbl_Academic_Level.setBounds(208,250,100,50);
        lbl_Academic_Level.setForeground(Color.BLACK);
        lbl_Academic_Level.setFont(fnt2);
        ACjpane.add(lbl_Academic_Level);
        ///Creating Level text field
        txt_Academic_Level = new JTextField();
        txt_Academic_Level.setBounds(300,263,200,30);
        txt_Academic_Level.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_Level);
        
        ///Creating Credit
        lbl_Academic_Credit = new JLabel("Credit:");
        lbl_Academic_Credit.setBounds(655,250,100,50);
        lbl_Academic_Credit.setForeground(Color.BLACK);
        lbl_Academic_Credit.setFont(fnt2);
        ACjpane.add(lbl_Academic_Credit);
        /// Creating Credit Text field
        txt_Academic_Credit = new JTextField();
        txt_Academic_Credit.setBounds(760,263,200,30);
        txt_Academic_Credit.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_Credit);
        
        ///Creating Number of Assessments
        lbl_Academic_NOA = new JLabel("Number of Assessments:");
        lbl_Academic_NOA.setBounds(409,320,350,50);
        lbl_Academic_NOA.setForeground(Color.BLACK);
        lbl_Academic_NOA.setFont(fnt2);
        ACjpane.add(lbl_Academic_NOA);
        ///Creating Number of Assessments text field
        txt_Academic_NOA = new JTextField();
        txt_Academic_NOA.setBounds(760,333,200,30);
        txt_Academic_NOA.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_NOA);
        
        ///Add Button
        btn_Academic_add = new JButton("Add");
        btn_Academic_add.setBounds(1100,310,75,55);
        btn_Academic_add.setFont(fnt2);
        ACjpane.add(btn_Academic_add);
        
        //Creating Course Leader
        lbl_Academic_Leader = new JLabel("Course Leader:");
        lbl_Academic_Leader.setBounds(83,450,220,50);
        lbl_Academic_Leader.setForeground(Color.BLACK);
        lbl_Academic_Leader.setFont(fnt2);
        ACjpane.add(lbl_Academic_Leader);
        ///Creating Course Leader text field
        txt_Academic_Leader = new JTextField();
        txt_Academic_Leader.setBounds(300,465,200,30);
        txt_Academic_Leader.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_Leader);
        
        //Creating Lecturer Name
        lbl_Academic_Lecturer = new JLabel("Lecturer Name:");
        lbl_Academic_Lecturer.setBounds(540,450,250,50);
        lbl_Academic_Lecturer.setForeground(Color.BLACK);
        lbl_Academic_Lecturer.setFont(fnt2);
        ACjpane.add(lbl_Academic_Lecturer);
        /// Creating Lecturer Name text field
        txt_Academic_Lecturer = new JTextField();
        txt_Academic_Lecturer.setBounds(760,465,200,30);
        txt_Academic_Lecturer.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_Lecturer);
        
        ///Creating Starting Date
        lbl_Academic_SDate = new JLabel("Starting Date:");
        lbl_Academic_SDate.setBounds(104,520,200,50);
        lbl_Academic_SDate.setForeground(Color.BLACK);
        lbl_Academic_SDate.setFont(fnt2);
        ACjpane.add(lbl_Academic_SDate);
        ///Creating Starting Date text field
        txt_Academic_SDate = new JTextField();
        txt_Academic_SDate.setBounds(300,535,200,30);
        txt_Academic_SDate.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_SDate);
        
        ///Creating Completion Date
        lbl_Academic_CDate = new JLabel("Completion Date:");
        lbl_Academic_CDate.setBounds(510,520,240,50);
        lbl_Academic_CDate.setForeground(Color.BLACK);
        lbl_Academic_CDate.setFont(fnt2);
        ACjpane.add(lbl_Academic_CDate);
        ///Creating Course Name text field
        txt_Academic_CDate = new JTextField();
        txt_Academic_CDate.setBounds(760,533,200,30);
        txt_Academic_CDate.setBackground(Color.WHITE);
        ACjpane.add(txt_Academic_CDate);
        
        ///Register Button
        btn_Academic_Register = new JButton("Register");
        btn_Academic_Register.setBounds(1080,510,130,55);
        btn_Academic_Register.setFont(fnt2);
        ACjpane.add(btn_Academic_Register);
        
        //Changing Non AcademicCourse Button
        btn_NAcademic = new JButton("Click here to go to Non Academic Course");
        btn_NAcademic.setBounds(120,720,575,55);
        btn_NAcademic.setFont(fnt2);
        ACjpane.add(btn_NAcademic);
        
        //Clear Button
        btn_Academic_Clear = new JButton("Clear");
        btn_Academic_Clear.setBounds(1040,720,100,55);
        btn_Academic_Clear.setFont(fnt2);
        ACjpane.add(btn_Academic_Clear);

        //Display Button
        btn_Academic_Display = new JButton("Display");
        btn_Academic_Display.setBounds(1140,720,120,55);
        btn_Academic_Display.setFont(fnt2);
        ACjpane.add(btn_Academic_Display);
        ///Academic Course pannel ends here
        
        ///for Non Academic Course
        ///Creating panel for Non Academic Course
        NCjpane = new JPanel();
        NCjpane.setBounds(0,0,1500,1000);
        NCjpane.setLayout(null);
        NCjpane.setBackground(new Color(255,249,230));
        
        //Creating Title Non Academic Coures
        lbl_NAcademic = new JLabel("Non Academic Course");
        lbl_NAcademic.setBounds(480,55,750,60);
        lbl_NAcademic.setFont(fnt1);
        lbl_NAcademic.setForeground(new Color(136,145,51));
        NCjpane.add(lbl_NAcademic);
        
        ///Creating CourseID
        lbl_NAcademic_ID = new JLabel("Course ID:");
        lbl_NAcademic_ID.setBounds(145,180,170,50);
        lbl_NAcademic_ID.setForeground(Color.BLACK);
        lbl_NAcademic_ID.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_ID);
        ///Creating CourseID text field
        txt_NAcademic_ID = new JTextField();
        txt_NAcademic_ID.setBounds(300,193,200,30);
        NCjpane.add(txt_NAcademic_ID);
        
        ///Creating Course Name
        lbl_NAcademic_Name = new JLabel("Course Name:");
        lbl_NAcademic_Name.setBounds(555,180,190,50);
        lbl_NAcademic_Name.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_Name);
        ///Creating Course Name text field
        txt_NAcademic_Name = new JTextField();
        txt_NAcademic_Name.setBounds(760,193,200,30);
        NCjpane.add(txt_NAcademic_Name);
        
        ///Creating Prerequisites
        lbl_NAcademic_Prerequiste = new JLabel("Prerequisites:");
        lbl_NAcademic_Prerequiste.setBounds(103,250,200,50);
        lbl_NAcademic_Prerequiste.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_Prerequiste);
        ///Creating Prerequisites text field
        txt_NAcademic_Prerequiste = new JTextField();
        txt_NAcademic_Prerequiste.setBounds(300,263,200,30); 
        NCjpane.add(txt_NAcademic_Prerequiste);
        
        ///Creating Duration
        lbl_NAcademic_Duration = new JLabel("Duration:");
        lbl_NAcademic_Duration.setBounds(620,250,150,50);
        lbl_NAcademic_Duration.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_Duration);
        ///Creating Duration text field
        txt_NAcademic_Duration = new JTextField();
        txt_NAcademic_Duration.setBounds(760,263,200,30);
        NCjpane.add(txt_NAcademic_Duration);
        
        ///Add Button
        btn_NAcademic_add = new JButton("Add");
        btn_NAcademic_add.setBounds(1080,240,70,50);
        btn_NAcademic_add.setFont(fnt2);
        NCjpane.add(btn_NAcademic_add);
        
        //Creating Course Leader
        lbl_NAcademic_Leader = new JLabel("Course Leader:");
        lbl_NAcademic_Leader.setBounds(83,410,220,50);
        lbl_NAcademic_Leader.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_Leader);
        ///Creating Course Leader text field
        txt_NAcademic_Leader = new JTextField();
        txt_NAcademic_Leader.setBounds(300,423,200,30);
        NCjpane.add(txt_NAcademic_Leader);
        
        //Creating Instructor Name
        lbl_NAcademic_Instructor = new JLabel("Instructor Name:");
        lbl_NAcademic_Instructor.setBounds(525,410,250,50);
        lbl_NAcademic_Instructor.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_Instructor);
        /// Creating Instructor Name text field
        txt_NAcademic_Instructor = new JTextField();
        txt_NAcademic_Instructor.setBounds(760,423,200,30);
        NCjpane.add(txt_NAcademic_Instructor);
        
        ///Creating Exam Date
        lbl_NAcademic_EDate = new JLabel("Exam Date:");
        lbl_NAcademic_EDate.setBounds(990,410,200,50);
        lbl_NAcademic_EDate.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_EDate);
        /// Credit Text field
        txt_NAcademic_EDate = new JTextField();
        txt_NAcademic_EDate.setBounds(1150,423,200,30);
        NCjpane.add(txt_NAcademic_EDate);
        
        ///Creating Starting Date
        lbl_NAcademic_SDate = new JLabel("Starting Date:");
        lbl_NAcademic_SDate.setBounds(104,500,200,50);
        lbl_NAcademic_SDate.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_SDate);
        ///Creating Starting Date text field
        txt_NAcademic_SDate = new JTextField();
        txt_NAcademic_SDate.setBounds(300,515,200,30);
        NCjpane.add(txt_NAcademic_SDate);
        
        /////Creating Completion Date
        lbl_NAcademic_CDate = new JLabel("Completion Date:");
        lbl_NAcademic_CDate.setBounds(510,500,240,50);
        lbl_NAcademic_CDate.setFont(fnt2);
        NCjpane.add(lbl_NAcademic_CDate);
        ///Creating Course Name text field
        txt_NAcademic_CDate = new JTextField();
        txt_NAcademic_CDate.setBounds(760,515,200,30);
        NCjpane.add(txt_NAcademic_CDate);
        
        ///Register Button
        btn_NAcademic_Register = new JButton("Register");
        btn_NAcademic_Register.setBounds(1080,500,130,50);
        btn_NAcademic_Register.setFont(fnt2);
        NCjpane.add(btn_NAcademic_Register);
        
        ///Remove Button
        btn_NAcademic_Remove = new JButton("Remove");
        btn_NAcademic_Remove.setBounds(1210,500,130,50);
        btn_NAcademic_Remove.setFont(fnt2);
        NCjpane.add(btn_NAcademic_Remove);
        
        //Changing Academic Course Button
        btn_Academic = new JButton("Click here to go to Academic Course");
        btn_Academic.setBounds(120,720,520,55);
        btn_Academic.setFont(fnt2);
        NCjpane.add(btn_Academic);
        
        //Clear Button
        btn_NAcademic_Clear = new JButton("Clear");
        btn_NAcademic_Clear.setBounds(1040,720,100,55);
        btn_NAcademic_Clear.setFont(fnt2);
        NCjpane.add(btn_NAcademic_Clear);

        //Display Button
        btn_NAcademic_Display = new JButton("Display");
        btn_NAcademic_Display.setBounds(1140,720,120,55);
        btn_NAcademic_Display.setFont(fnt2);
        NCjpane.add(btn_NAcademic_Display);
        
        ///Adding pannel in frame
        jf.add(ACjpane);
        jf.add(NCjpane);
        jf.add(WPjpane);
        
        //Action Listener
        //For switching pannels form AC to NA
        btn_Academic.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        ACjpane.setVisible(true);
                        NCjpane.setVisible(false);
                        WPjpane.setVisible(false);
                    }
            }    
        );
        
        btn_NAcademic.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        ACjpane.setVisible(false);
                        NCjpane.setVisible(true);
                        WPjpane.setVisible(false);
                    }
            }    
        );
        
        //Action listener for AC button and NC button of welcome page
        btn_WP_AC.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        ACjpane.setVisible(true);
                        NCjpane.setVisible(false);
                        WPjpane.setVisible(false);
                    }
            }    
        );
        
        btn_WP_NC.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        ACjpane.setVisible(false);
                        NCjpane.setVisible(true);
                        WPjpane.setVisible(false);
                    }
            }    
        );
        
        //Creating Array List of Course Class
        academicCourseList = new ArrayList<Course>();
        nonAcademicCourseList = new ArrayList<Course>();
        
        //Action listener for Add button of Academic Course
        btn_Academic_add.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        //try catch for Integer datatype
                        //for duration and number of assesments
                        try
                        {
                            String duration_Academic_temp = txt_Academic_Duration.getText();
                            int duration_Academic = Integer.parseInt(duration_Academic_temp);
                            String numberOfAssesments_Academic_temp = txt_Academic_NOA.getText();
                            int numberOfAssesments_Academic = Integer.parseInt(numberOfAssesments_Academic_temp);
                        }
                        catch(Exception I)
                        {
                            String duration_Academic_temp = txt_Academic_Duration.getText();
                            String numberOfAssesments_Academic_temp = txt_Academic_NOA.getText();
                            if (duration_Academic_temp.isEmpty() || numberOfAssesments_Academic_temp.isEmpty())
                            {
                                JOptionPane.showMessageDialog(jf,"The text field is empty, please fill it up.");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(jf,"You have entered invalid data type.");
                            }
                        }
                        
                        String courseID_Academic = txt_Academic_ID.getText();
                        String courseName_Academic = txt_Academic_Name.getText();
                        String level_Academic = txt_Academic_Level.getText();
                        String credit_Academic = txt_Academic_Credit.getText();
                        String duration_Academic_temp = txt_Academic_Duration.getText();
                        String numberOfAssesments_Academic_temp = txt_Academic_NOA.getText();
                        int duration_Academic = Integer.parseInt(duration_Academic_temp);
                        int numberOfAssesments_Academic = Integer.parseInt(numberOfAssesments_Academic_temp);
                        if (courseID_Academic.isEmpty() || courseName_Academic.isEmpty() || level_Academic.isEmpty() || credit_Academic.isEmpty())
                        {
                            JOptionPane.showMessageDialog(jf,"The text field is empty, please fill it up.");
                        }
                        else 
                        {
                            for (Course w: academicCourseList)
                            {
                                if (courseID_Academic.equals(w.getCourseID()))
                                {
                                    JOptionPane.showMessageDialog(jf,"The given CourseID is already used. Please enter a different one.");
                                    return;
                                }
                            }
                            AcademicCourse a = new AcademicCourse(courseID_Academic, courseName_Academic, duration_Academic, level_Academic, credit_Academic, numberOfAssesments_Academic);
                            academicCourseList.add(a);
                            JOptionPane.showMessageDialog(jf,"All of your records have been added.");
                        }
                    }
            }
        );
        
        //Action listener for Add button of Non Academic Course
        btn_NAcademic_add.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        //try catch for integer datatype
                        //for duration
                        try
                        {
                            String duration_NAcademic_temp = txt_NAcademic_Duration.getText();
                            int duration_NAcademic = Integer.parseInt(duration_NAcademic_temp);
                        }
                        catch(Exception I)
                        {
                            String duration_NAcademic_temp = txt_NAcademic_Duration.getText();
                            if (duration_NAcademic_temp.isEmpty())
                            {
                                JOptionPane.showMessageDialog(jf,"The text field is empty, please fill it up.");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(jf,"You have entered invalid data type.");
                            }
                            JOptionPane.showMessageDialog(jf,"The text field is empty, please fill it up.");
                        }
                        
                        String courseID_NAcademic = txt_NAcademic_ID.getText();
                        String courseName_NAcademic = txt_NAcademic_Name.getText();
                        String prerequisite_NAcademic = txt_NAcademic_Prerequiste.getText();
                        String duration_NAcademic_temp = txt_NAcademic_Duration.getText();
                        int duration_NAcademic = Integer.parseInt(duration_NAcademic_temp);
                        if (courseID_NAcademic.isEmpty() || courseName_NAcademic.isEmpty() || prerequisite_NAcademic.isEmpty())
                        {
                            JOptionPane.showMessageDialog(jf,"The text field is empty, please fill it up.");
                        }
                        else 
                        {
                            for (Course w: nonAcademicCourseList)
                            {
                                if (courseID_NAcademic.equals(w.getCourseID()))
                                {
                                    JOptionPane.showMessageDialog(jf,"The given CourseID is already used. Please enter a different one.");
                                    return;
                                }
                            }
                            NonAcademicCourse a = new NonAcademicCourse(courseID_NAcademic, courseName_NAcademic, duration_NAcademic, prerequisite_NAcademic);
                            nonAcademicCourseList.add(a);
                            JOptionPane.showMessageDialog(jf,"All of your records have been added.");  
    
                        }
                    }
            }
        );
        
        //Action listener for Register button of Academic Course
        btn_Academic_Register.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                    {
                        String courseLeader_Academic = txt_Academic_Leader.getText();
                        String lecturerName_Academic = txt_Academic_Lecturer.getText();
                        String startingDate_Academic = txt_Academic_SDate.getText();
                        String completionDate_Academic = txt_Academic_CDate.getText();
                        
                        if (courseLeader_Academic.isEmpty() || lecturerName_Academic.isEmpty() || startingDate_Academic.isEmpty() || completionDate_Academic.isEmpty())
                        {
                            JOptionPane.showMessageDialog(jf,"The text field is empty, please fill it up.");
                        }
                        else
                        {
                            for (int i=0; i<academicCourseList.size(); i++)
                            {
                                if (academicCourseList.get(i).getCourseID().equals(txt_Academic_ID.getText()))
                                {
                                    AcademicCourse AC = (AcademicCourse) academicCourseList.get(i);
                                    if (!AC.getIsRegistered())
                                    {
                                        AC.register(courseLeader_Academic, lecturerName_Academic, startingDate_Academic, completionDate_Academic);
                                        JOptionPane.showMessageDialog(jf,"Academic Course is registered.");
                                    }
                                    else 
                                    {
                                        JOptionPane.showMessageDialog(jf,"Academic Course is already registered.");
                                    }
                                }
                                else 
                                    {
                                        JOptionPane.showMessageDialog(jf,"The Academic course ID doesn't match.");
                                    }
                            }
                        }
                    }
            }
        );
        
        //Action listener for Register button of Non Academic Course
        btn_NAcademic_Register.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                    {
                        String courseLeader_NAcademic = txt_NAcademic_Leader.getText();
                        String instructorName_NAcademic = txt_NAcademic_Instructor.getText();
                        String startingDate_NAcademic = txt_NAcademic_SDate.getText(); 
                        String completionDate_NAcademic = txt_NAcademic_CDate.getText();
                        String examDate_NAcademic = txt_NAcademic_EDate.getText();
                        
                        if (courseLeader_NAcademic.isEmpty() || instructorName_NAcademic.isEmpty() || startingDate_NAcademic.isEmpty() || completionDate_NAcademic.isEmpty() || examDate_NAcademic.isEmpty())
                        {
                            JOptionPane.showMessageDialog(jf,"The text field is empty, please fill it up.");
                        }
                        else
                        {
                            for (int i=0; i<nonAcademicCourseList.size(); i++)
                            {
                                if (nonAcademicCourseList.get(i).getCourseID().equals(txt_NAcademic_ID.getText()))
                                {
                                    NonAcademicCourse NC = (NonAcademicCourse) nonAcademicCourseList.get(i);
                                    if (!NC.getIsRegistered())
                                    {
                                        NC.register(courseLeader_NAcademic, instructorName_NAcademic, startingDate_NAcademic, completionDate_NAcademic, examDate_NAcademic);
                                        JOptionPane.showMessageDialog(jf,"Non academic Course is registered.");
                                    }
                                    else 
                                    {
                                        JOptionPane.showMessageDialog(jf,"Non academic Course is already registered.");
                                    }
                                }
                                else 
                                    {
                                        JOptionPane.showMessageDialog(jf,"The Non academic course ID doesn't match.");
                                    }
                            }
                        }
                    }
            }
        );
        
        //Action listener for Remove button of Non Academic Course
        btn_NAcademic_Remove.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        String courseLeader_NAcademic = txt_NAcademic_Leader.getText();
                        String instructorName_NAcademic = txt_NAcademic_Instructor.getText();
                        String startingDate_NAcademic = txt_NAcademic_SDate.getText(); 
                        String completionDate_NAcademic = txt_NAcademic_CDate.getText();
                        String examDate_NAcademic = txt_NAcademic_EDate.getText();
                        
                        if (courseLeader_NAcademic.isEmpty() || instructorName_NAcademic.isEmpty() || startingDate_NAcademic.isEmpty() || completionDate_NAcademic.isEmpty() || examDate_NAcademic.isEmpty())
                        {
                            JOptionPane.showMessageDialog(jf,"The text field is empty, please fill it up.");
                        }
                        else
                        {
                            for (int i=0; i<nonAcademicCourseList.size(); i++)
                            {
                                if (nonAcademicCourseList.get(i).getCourseID().equals(txt_NAcademic_ID.getText()))
                                {
                                    NonAcademicCourse NC = (NonAcademicCourse) nonAcademicCourseList.get(i);
                                    if (!NC.getIsRemoved())
                                    {
                                        NC.remove();
                                        JOptionPane.showMessageDialog(jf,"Non academic Course is removed.");
                                    }
                                    else 
                                    {
                                        JOptionPane.showMessageDialog(jf,"Non academic Course is already removed.");
                                    }
                                }
                                else 
                                    {
                                        JOptionPane.showMessageDialog(jf,"The Non academic course ID doesn't match.");
                                    }
                            }
                        }
                    }
            }
        );
        
        //Action listener for Clear button of Academic Course
        btn_Academic_Clear.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        txt_Academic_ID.setText("");
                        txt_Academic_Name.setText("");
                        txt_Academic_Level.setText("");
                        txt_Academic_Credit.setText("");
                        txt_Academic_Duration.setText("");
                        txt_Academic_NOA.setText("");
                        txt_Academic_Leader.setText("");
                        txt_Academic_Lecturer.setText("");
                        txt_Academic_SDate.setText("");
                        txt_Academic_CDate.setText("");
                        JOptionPane.showMessageDialog(jf,"The entered values of text field are cleared.");
                    }
            }
        );
        
        //Action listener for Clear button of Non Academic Course
        btn_NAcademic_Clear.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        txt_NAcademic_ID.setText("");
                        txt_NAcademic_Name.setText("");
                        txt_NAcademic_Prerequiste.setText("");
                        txt_NAcademic_Duration.setText("");
                        txt_NAcademic_Leader.setText("");
                        txt_NAcademic_Instructor.setText("");
                        txt_NAcademic_SDate.setText(""); 
                        txt_NAcademic_CDate.setText("");
                        txt_NAcademic_EDate.setText("");
                        JOptionPane.showMessageDialog(jf,"The entered values of text field are cleared.");
                    }
            }
        );
        
        //Action listener for Display button of Academic Course
        btn_Academic_Display.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        Academic_display_jf= new JFrame("Academic Course");
                        Academic_display_jf.setBounds(10,10,1400,250); 
                
                        DefaultTableModel Academic_table_model= new DefaultTableModel(); 
                        //Creating table
                        Academic_table = new JTable(Academic_table_model); 
                        //Columns in table
                        Academic_table_model.addColumn("Course ID");
                        Academic_table_model.addColumn("Course Name");
                        Academic_table_model.addColumn("Level");
                        Academic_table_model.addColumn("Credit");
                        Academic_table_model.addColumn("Duration");
                        Academic_table_model.addColumn("Number of Asssesments");
                        Academic_table_model.addColumn("Course Leader");
                        Academic_table_model.addColumn("Lecturer Name");
                        Academic_table_model.addColumn("Starting Date");
                        Academic_table_model.addColumn("Completion Date");
                
                        String rowTitleList[] = {"Course ID","Course Name","Level","Credit","Duration","Number of Assesments","Course Leader","Lecturer Name","Starting Date","Completion Date"};
                
                        Academic_table_model.addRow(rowTitleList);
                
                        //Rows of the table
                        for(int i = 0; i < academicCourseList.size(); i++)
                            {
                                AcademicCourse AC = (AcademicCourse) (academicCourseList.get(i));
                                String courseID_Academic = AC.getCourseID();
                                String courseName_Academic = AC.getCourseName();
                                String level_Academic = AC.getLevel();
                                String credit_Academic = AC.getCredit();
                                int duration_Academic_temp = AC.getDuration();
                                String duration_Academic = Integer.toString(duration_Academic_temp);
                                int numberOfAssesments_Academic_temp = AC.getNumberOfAssessments();
                                String numberOfAssesments_Academic = Integer.toString(numberOfAssesments_Academic_temp);
                                String courseLeader_Academic= AC.getCourseLeader();
                                String lecturerName_Academic= AC.getLecturerName();
                                String startingDate_Academic= AC.getStartingDate();
                                String completionDate_Academic= AC.getCompletionDate();
                    
                                String tableRow[] = {courseID_Academic,courseName_Academic,level_Academic,credit_Academic,duration_Academic,numberOfAssesments_Academic,courseLeader_Academic,lecturerName_Academic,startingDate_Academic,completionDate_Academic};
                                Academic_table_model.addRow(tableRow);
                            }             
                        
                        Academic_display_jf.add(Academic_table);
                        Academic_display_jf.setVisible(true);  
                    }
            }
        );
        
        //Action listener for Display button of Non Academic Course
        btn_NAcademic_Display.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                    {
                        NAcademic_display_jf= new JFrame("Non Academic Course");
                        NAcademic_display_jf.setBounds(10,10,1300,250); 
                
                        DefaultTableModel NAcademic_table_model= new DefaultTableModel(); 
                        //Creating table
                        NAcademic_table = new JTable(NAcademic_table_model); 
                        //Columns in table
                        NAcademic_table_model.addColumn("Course ID");
                        NAcademic_table_model.addColumn("Course Name");
                        NAcademic_table_model.addColumn("Prerequisite");
                        NAcademic_table_model.addColumn("Duration");
                        NAcademic_table_model.addColumn("Course Leader");
                        NAcademic_table_model.addColumn("Instructor Name");
                        NAcademic_table_model.addColumn("Starting Date");
                        NAcademic_table_model.addColumn("Completion Date");
                        NAcademic_table_model.addColumn("Exam Date");
                
                        String rowTitleList[] = {"Course ID","Course Name","Prerequisite","Duration","Course Leader","Instructor Name","Starting Date","Completion Date","Exam Date"};
                
                        NAcademic_table_model.addRow(rowTitleList);
                
                        //Rows of the table
                        for(int i = 0; i < nonAcademicCourseList.size(); i++)
                            {
                                NonAcademicCourse NAC = (NonAcademicCourse) (nonAcademicCourseList.get(i));
                                String courseID_NAcademic = NAC.getCourseID();
                                String courseName_NAcademic = NAC.getCourseName();
                                String prerequisite_NAcademic = NAC.getPrerequisite();
                                int duration_NAcademic_temp = NAC.getDuration();
                                String duration_NAcademic = Integer.toString(duration_NAcademic_temp);
                                String courseLeader_NAcademic= NAC.getCourseLeader();
                                String instructorName_NAcademic= NAC.getInstructorName();
                                String startingDate_NAcademic= NAC.getStartingDate();
                                String completionDate_NAcademic= NAC.getCompletionDate();
                                String examDate_NAcademic= NAC.getExamDate();
                    
                                String tableRow[] = {courseID_NAcademic,courseName_NAcademic,prerequisite_NAcademic,duration_NAcademic,courseLeader_NAcademic,instructorName_NAcademic,startingDate_NAcademic,completionDate_NAcademic,examDate_NAcademic};
                                NAcademic_table_model.addRow(tableRow);
                            }             
                        
                        NAcademic_display_jf.add(NAcademic_table);
                        NAcademic_display_jf.setVisible(true);  
                    }
            }
        );
        
        //Set Visible
        jf.setVisible(true);
        WPjpane.setVisible(true);
        ACjpane.setVisible(false);
        NCjpane.setVisible(false);
    }
    
    public static void main(String [] args)
    {
        new INGCollege();
    }
}
