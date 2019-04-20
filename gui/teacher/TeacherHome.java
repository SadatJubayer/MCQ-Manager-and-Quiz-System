package gui.teacher;

import gui.components.*;
import gui.Home;

import dbfunctions.Coursedb;
import dbfunctions.Teacherdb;
import classes.Course;
import classes.Teacher;

import javax.swing.border.EmptyBorder;
import java.util.List;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TeacherHome extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, boxOne, boxTwo, welcome, title, studentNumber, questionNumber, num1, num2, loginSuccess;
    private JButton addCourse, logoutButton, goToButton, deleteButton;

    private JPanel panel;
    private String teacherId, teacherName;
    private int courseId;
    private String theCourse;
    private String coursess[];

    private List<Course> course;

    // Components
    private MyColor color;
    private MyFont font;

    private JList courseList;

    // NAVIGATION OBJECTS:
    private Teacher teacher;
    private Home home;
    private Course selectedCourse;

    public TeacherHome(Teacher teacher) {

        // got from navigation
        this.home = home;
        this.teacher = teacher;

        // UI Elements
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        color = new MyColor();
        font = new MyFont();

        // Navbar

        welcome = new JLabel("Welcome, " + teacher.getName());
        welcome.setFont(font.getMediumFont());
        welcome.setForeground(color.getBgColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(font.getprimaryFont());
        logoutButton.setBackground(color.getsecondaryButtonColor());
        logoutButton.setForeground(color.getBgColor());
        logoutButton.setFocusPainted(false);
        logoutButton.setBounds(850, 13, 100, 35);
        logoutButton.addActionListener(this);
        panel.add(logoutButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(color.getNavbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Buttons

        addCourse = new JButton("ADD Course");

        addCourse.setFont(font.getMediumFont());
        addCourse.setBackground(color.getButtonColor());
        addCourse.setForeground(color.getBgColor());
        addCourse.setFocusPainted(false);
        addCourse.setBounds(40, 70, 200, 50);
        addCourse.addActionListener(this);
        panel.add(addCourse);

        title = new JLabel("Your Courses:");
        title.setFont(font.getTinyFont());
        title.setBounds(150, 125, 120, 25);
        panel.add(title);

        // Texts

        loginSuccess = new JLabel("Please Select a course");
        loginSuccess.setFont(font.getMediumFont());
        loginSuccess.setForeground(color.getNavbarColor());
        loginSuccess.setBounds(360, 90, 600, 25);
        panel.add(loginSuccess);

        studentNumber = new JLabel("Students");
        studentNumber.setFont(font.getBigFont());
        studentNumber.setForeground(color.getBgColor());
        studentNumber.setBounds(420, 380, 250, 50);
        panel.add(studentNumber);

        num1 = new JLabel();
        num1.setText("00");
        num1.setFont(font.getBigBigFont());
        num1.setForeground(color.getBgColor());
        num1.setBounds(390, 70, 400, 400);
        panel.add(num1);

        questionNumber = new JLabel("Questions");
        questionNumber.setFont(font.getBigFont());
        questionNumber.setForeground(color.getBgColor());
        questionNumber.setBounds(720, 380, 250, 50);
        panel.add(questionNumber);

        num2 = new JLabel();
        num2.setText("00");
        num2.setFont(font.getBigBigFont());
        num2.setForeground(color.getBgColor());
        num2.setBounds(700, 70, 400, 400);
        panel.add(num2);

        // Boxes

        boxOne = new JLabel();
        boxOne.setOpaque(true);
        boxOne.setBackground(color.gettBackgroundColor());
        boxOne.setBounds(360, 150, 290, 300);
        panel.add(boxOne);

        boxTwo = new JLabel();
        boxTwo.setOpaque(true);
        boxTwo.setBackground(color.gettBackgroundColor());
        boxTwo.setBounds(660, 150, 290, 300);
        panel.add(boxTwo);

        // Combobox
        List<Course> course = Coursedb.getCourseList(Integer.toString(teacher.getId()));

        int length = course.size();
        coursess = new String[length];
        int i = 0;
        for (Course c : course) {
            coursess[i] = c.getName(); // c = courseList
            i++;
        }
        courseList = new JList(coursess);
        courseList.setFont(font.getMediumFont());
        courseList.setBorder(new EmptyBorder(10, 10, 10, 10));
        courseList.setForeground(color.getTextColor());

        courseList.addMouseListener(this);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(courseList);
        scrollPane.setBounds(40, 150, 300, 450);

        panel.add(scrollPane);

        goToButton = new JButton("Go to Course");
        goToButton.setBounds(360, 500, 400, 50);
        goToButton.setFont(font.getprimaryFont());
        goToButton.setForeground(color.getBgColor());
        goToButton.setBackground(color.getButtonColor());
        goToButton.setFocusPainted(false);
        goToButton.addActionListener(this);
        goToButton.setEnabled(false);
        panel.add(goToButton);

        deleteButton = new JButton("Delete Course");
        deleteButton.setBounds(780, 500, 170, 50);
        deleteButton.setFont(font.getprimaryFont());
        deleteButton.setForeground(color.getBgColor());
        deleteButton.setBackground(color.getDelteButtonColor());
        deleteButton.addActionListener(this);
        deleteButton.setEnabled(false);
        panel.add(deleteButton);

        this.add(panel);

        // backButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCourse) {
            this.dispose();
            // NAVIGATION
            System.out.println("action performed: add course: " + teacher.getName());
            AddCourse f = new AddCourse(teacher, home);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        } else if (e.getSource() == goToButton) {

            this.dispose();
            // navigation
            CoursePage cc = new CoursePage(teacher, selectedCourse);
            cc.setLocationRelativeTo(null);
            cc.setVisible(true);

        } else if (e.getSource() == logoutButton) {
            this.dispose();
            Home home = new Home();
            home.setLocationRelativeTo(null);
            home.setResizable(false);
            home.setVisible(true);

        } else if (e.getSource() == deleteButton) {
            Coursedb.deleteCourse(courseId);
            dispose();
            // NAVIGATION
            TeacherHome teacherHome = new TeacherHome(teacher);
            teacherHome.setLocationRelativeTo(null);
            teacherHome.setVisible(true);

        }

    }

    public void mouseClicked(MouseEvent e) {

        // String str2 = "123";
        if (e.getSource() == courseList) {

            goToButton.setEnabled(true);
            deleteButton.setEnabled(true);

            int selected = courseList.getSelectedIndex();

            // System.out.println(selected);

            List<Course> c = Coursedb.getCourseList(Integer.toString(teacher.getId()));

            selectedCourse = c.get(selected);

            int indice = c.get(selected).getId();
            courseId = selected;
            theCourse = c.get(selected).getName();

            loginSuccess.setText(theCourse + " is now selected");

            String str = Coursedb.getNumberOfStudents(indice);
            num1.setText(str);

            String str2 = Coursedb.getNumberOfQuestions(indice);
            num2.setText(str2);

        } else {

        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        // try {
        // // print something here
        // Thread.sleep(3000); // sleep for 3 seconds
        // // print something else here
        // loginSuccess.setText("");
        // } catch (InterruptedException ea) {
        // System.out.println("got interrupted!");
        // }
    }

    public void mouseExited(MouseEvent e) {
    }

}
