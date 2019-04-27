package gui.teacher;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.border.EmptyBorder;

import gui.teacher.*;
import gui.Home;
import gui.utilities.*;

// Navigations
import classes.Course;
import classes.Teacher;
import classes.Student;

// database
import dbfunctions.*;

public class RequestedStudent extends JFrame implements ActionListener {

    private JLabel navBar, welcome, courses;
    private JButton backButton;

    private JPanel panel;

    private Teacher teacher;
    private Course course;
    private List<Student> students;

    public RequestedStudent(Teacher teacher, Course course) {

        super("Requested Student");

        this.teacher = teacher;
        this.course = course;

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Navbar

        welcome = new JLabel("Course: " + course.getName());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setFont(MyFont.primaryFont());
        welcome.setBounds(600, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFocusPainted(false);
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.dangerColor());
        backButton.setForeground(MyColor.whiteColor());
        backButton.setBounds(40, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        courses = new JLabel("Requested Students: ");
        courses.setForeground(MyColor.textColor());
        courses.setFont(MyFont.primaryFont());
        courses.setBounds(40, 70, 200, 25);
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
        list.setFont(MyFont.tinyFont());
        list.setForeground(MyColor.textColor());
        list.setBorder(new EmptyBorder(10, 10, 10, 10));
        list.setForeground(MyColor.textColor());

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(list);
        scrollPane.setBounds(40, 110, 280, 450);
        panel.add(scrollPane);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();

        if (action.equals(backButton.getText())) {
            dispose();
            CoursePage cp = new CoursePage(teacher, course);
            cp.setLocationRelativeTo(null);
            cp.setResizable(false);
            cp.setVisible(true);
        } else {

        }
    }

}
