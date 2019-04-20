package gui.teacher;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;

import gui.teacher.*;
import gui.Home;

// custom imports 
import gui.utilities.MyColor;
import gui.utilities.MyFont;

// Navigations
import classes.Course;
import classes.Teacher;
import classes.Student;

// database
import dbfunctions.*;

public class StudentList extends JFrame implements ActionListener {

    private JLabel navBar, welcome, courses;
    private JButton backButton;

    private JPanel panel;

    private Teacher teacher;
    private Course course;
    private List<Student> students;

    public StudentList(Teacher teacher, Course course) {

        super("Student List page");

        this.teacher = teacher;
        this.course = course;

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Navbar

        welcome = new JLabel("Welcome");
        welcome.setForeground(MyColor.textColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFocusPainted(false);
        backButton.setBounds(850, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        courses = new JLabel("Enrolled Student list: ");
        courses.setBackground(MyColor.successColor());
        courses.setFont(MyFont.mediumFont());
        courses.setBounds(40, 70, 120, 25);
        panel.add(courses);

        // creating string array for list

        students = Coursedb.getEnrolledStudentList(course.getId());

        int length = students.size();
        String studentsString[] = new String[length];
        int i = 0;
        for (Student s : students) {
            studentsString[i] = s.getName();
            i++;
        }

        JScrollPane scrollPane = new JScrollPane();
        JList list = new JList(studentsString);
        list.setForeground(MyColor.primaryColor());

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(list);
        scrollPane.setBounds(10, 200, 250, 400);
        panel.add(scrollPane);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();

        if (action.equals(backButton.getText())) {
            dispose();
            CoursePage cp = new CoursePage(teacher, course);
            cp.setLocationRelativeTo(null);
            cp.setVisible(true);
        } else {

        }
    }

}
