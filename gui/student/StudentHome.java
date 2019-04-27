package gui.student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.List;

import classes.Teacher;
import classes.Student;
import classes.Course;
import classes.Exam;
import dbfunctions.*;

import java.awt.event.*;
import java.awt.*;

import gui.teacher.*;
import gui.Home;

// custom imports 
import gui.utilities.*;

public class StudentHome extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, welcome, teacherNameText, text, examDurationText, noOfExamText, totalTimeText, titleOne,
            titleTwo, titleThree;
    private JButton logoutButton, registration, startExam, resultButton;
    private JComboBox courseList;

    private Teacher teacher;
    private String coursess[];
    // private String exams[];
    private Exam selectedExam;
    private List<Exam> exam;
    // for course list and selection
    private List<Course> course;
    private JScrollPane scroll;
    private JPanel panel;
    private Course selectedCourse;
    private JList courseJList, examList;
    private JScrollPane scrollPane;

    // navigation
    private Student student;

    public StudentHome(Student student) {

        super("Student Home");
        System.out.println("came here");
        this.student = student;
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Register button
        registration = new JButton("Register for Courses");
        registration.setFocusPainted(false);
        registration.setFont(MyFont.smallFont());
        registration.setBackground(MyColor.primaryColor());
        registration.setForeground(MyColor.whiteColor());
        registration.setFocusPainted(false);
        registration.setBounds(400, 60, 200, 50);
        registration.addActionListener(this);
        panel.add(registration);

        // Navbar
        welcome = new JLabel("Welcome Sadat");
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        logoutButton = new JButton("Logout");
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(MyFont.primaryFont());
        logoutButton.setBackground(MyColor.lightColor());
        logoutButton.setForeground(MyColor.dangerColor());
        logoutButton.setBounds(850, 13, 100, 35);
        logoutButton.addActionListener(this);
        panel.add(logoutButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        teacherNameText = new JLabel("Registered courses: ");
        teacherNameText.setForeground(MyColor.textColor());
        teacherNameText.setFont(MyFont.smallFont());
        teacherNameText.setBounds(40, 110, 250, 25);
        panel.add(teacherNameText);

        // Getting student course list
        course = Coursedb.getEnrolledCourseList(student.getId());

        int length = course.size();
        coursess = new String[length];
        int i = 0;
        for (Course c : course) {
            coursess[i] = c.getName(); // c = courseList
            i++;
        }

        if (length == 0) {
            teacherNameText.setText("You have no registered course! Go to Registration");
            teacherNameText.setForeground(MyColor.dangerColor());
        }

        courseJList = new JList(coursess);
        courseJList.setFont(MyFont.smallFont());
        courseJList.setBorder(new EmptyBorder(10, 10, 10, 10));
        courseJList.setForeground(MyColor.textColor());
        courseJList.addMouseListener(this);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(courseJList);
        scrollPane.setBounds(40, 150, 280, 450);
        panel.add(scrollPane);
        // List done

        titleOne = new JLabel("TeacherName: ");
        titleOne.setForeground(MyColor.textColor());
        titleOne.setFont(MyFont.smallFont());
        titleOne.setBounds(365, 150, 250, 25);
        panel.add(titleOne);

        titleTwo = new JLabel("No of students: ");
        titleTwo.setForeground(MyColor.textColor());
        titleTwo.setFont(MyFont.smallFont());
        titleTwo.setBounds(365, 200, 250, 25);
        panel.add(titleTwo);

        titleThree = new JLabel("Available Exams:");
        titleThree.setForeground(MyColor.textColor());
        titleThree.setFont(MyFont.smallFont());
        titleThree.setBounds(365, 250, 250, 25);
        panel.add(titleThree);

        // Exam List

        // Exam list done

        resultButton = new JButton("Percentage: 20%");
        resultButton.setFocusPainted(false);
        resultButton.setFont(MyFont.smallFont());
        resultButton.setBackground(MyColor.primaryColor());
        resultButton.setForeground(MyColor.whiteColor());
        resultButton.setFocusPainted(false);
        resultButton.setBounds(590, 550, 350, 50);
        resultButton.addActionListener(this);
        resultButton.setVisible(false);
        panel.add(resultButton);

        examDurationText = new JLabel("00");
        examDurationText.setForeground(MyColor.whiteColor());
        examDurationText.setBounds(820, 280, 280, 50);
        examDurationText.setFont(MyFont.bigFont());
        panel.add(examDurationText);

        noOfExamText = new JLabel("00");
        noOfExamText.setForeground(MyColor.whiteColor());
        noOfExamText.setBounds(800, 350, 280, 50);
        noOfExamText.setFont(MyFont.bigFont());
        panel.add(noOfExamText);

        totalTimeText = new JLabel("00");
        totalTimeText.setForeground(MyColor.whiteColor());
        totalTimeText.setBounds(750, 420, 280, 50);
        totalTimeText.setFont(MyFont.bigFont());
        panel.add(totalTimeText);

        text = new JLabel("   Exam Duration(minutes): ");
        text.setOpaque(true);
        text.setBackground(MyColor.defaultColor());
        text.setForeground(MyColor.whiteColor());
        text.setBounds(660, 280, 280, 50);
        panel.add(text);

        text = new JLabel("   Number of Question: ");
        text.setForeground(MyColor.whiteColor());
        text.setOpaque(true);
        text.setBackground(MyColor.defaultColor());
        text.setBounds(660, 350, 280, 50);
        panel.add(text);

        text = new JLabel("   Total Marks: ");
        text.setOpaque(true);
        text.setBackground(MyColor.defaultColor());
        text.setForeground(MyColor.whiteColor());
        text.setBounds(660, 420, 280, 50);
        panel.add(text);

        startExam = new JButton("Start Exam");
        startExam.setFocusPainted(false);
        startExam.setFont(MyFont.bigFont());
        startExam.setBackground(MyColor.darkColor());
        startExam.setForeground(MyColor.whiteColor());
        startExam.setFocusPainted(false);
        startExam.setBounds(660, 500, 280, 80);
        startExam.addActionListener(this);
        panel.add(startExam);

        examList = new JList();
        examList.setFont(MyFont.smallFont());
        examList.setBorder(new EmptyBorder(10, 10, 10, 10));
        examList.setForeground(MyColor.textColor());
        examList.addMouseListener(this);
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(examList);
        scrollPane.setBounds(365, 280, 255, 313);
        panel.add(scrollPane);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == logoutButton) {
            dispose();
            Home home = new Home();
            home.setVisible(true);
            home.setResizable(false);
            home.setLocationRelativeTo(null);
        } else if (ae.getSource() == courseList) {
            System.out.println(courseList.getSelectedIndex());

            selectedCourse = course.get(courseList.getSelectedIndex());

            int tId = selectedCourse.getTeacherId();

            // teacherNameText.setVisible(true);
            // teacherNameText.setText("Teacher name: " + Teacherdb.getTeacherName(tId));
            // scroll.setVisible(true);
            // startExam.setVisible(true);
            // resultButton.setVisible(true);
        } else if (ae.getSource() == registration) {
            dispose();
            CourseRegistration registerPage = new CourseRegistration(student);
            registerPage.setVisible(true);
            registerPage.setResizable(false);
            registerPage.setLocationRelativeTo(null);
        } else if (ae.getSource() == startExam) {
            dispose();
            ParticularExam examPage = new ParticularExam(student, selectedExam);
            examPage.setResizable(false);
            examPage.setVisible(true);
            examPage.setLocationRelativeTo(null);
        }

    }

    public void mouseClicked(MouseEvent e) {

        // click on a particular exam

        if (e.getSource() == examList) {

            System.out.println("Clicked on exam");
            int selected = examList.getSelectedIndex();
            selectedExam = exam.get(selected);
            System.out.println(selectedExam.getDuration());
            examDurationText.setText(Integer.toString(selectedExam.getDuration()));
            // noOfExamText.setText(selectedCourse.getNumberOfQuestions());

        }

        if (e.getSource() == courseJList) {

            int selected = courseJList.getSelectedIndex();
            selectedCourse = course.get(selected);

            String numberOfStudents = Coursedb.getNumberOfStudents(selectedCourse.getId());
            String teacherName = Teacherdb.getTeacherName(selectedCourse.getTeacherId());

            titleOne.setText("Teacher name: " + teacherName);
            titleTwo.setText("No of Students: " + numberOfStudents);

            String arr[] = loadExams();
            for (String s : arr) {
                System.out.println(s);
            }
            examList.setListData(loadExams());
            // Exam list

        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {
    }

    public String[] loadExams() {
        exam = Examdb.getPublishedExamList(selectedCourse.getId());
        String exams[] = new String[exam.size()];
        int i = 0;
        for (Exam e : exam) {
            exams[i] = e.getDescription();
            i++;
        }
        return exams;
    }

}
