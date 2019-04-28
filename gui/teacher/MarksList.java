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
import classes.Marks;

// database
import dbfunctions.*;

public class MarksList extends JFrame implements ActionListener {

    private JLabel navBar, welcome, courses;
    private Object tableHeaders[] = { "Student ID", "Student Name", "Marks" };
    private JTable table;
    private JButton backButton;

    private JPanel panel;

    private List<Marks> marksList;

    private Teacher teacher;
    private Course course;
    private int examId;

    public MarksList(Teacher teacher, Course course, int examId) {

        super("Marks Page");

        this.teacher = teacher;
        this.course = course;
        this.examId = examId;

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

        courses = new JLabel("Marks of Enrolled Students: ");
        courses.setForeground(MyColor.textColor());
        courses.setFont(MyFont.primaryFont());
        courses.setBounds(300, 70, 200, 25);
        panel.add(courses);

        marksList = Examdb.getMarks(examId);

        for (Marks mark : marksList) {
            System.out.println(mark.getMarks());
            System.out.println(Studentdb.getStudentName(mark.getStudentId()));
        }

        // TODO: Marks table will be implemented here

        // table = new JTable(rows, tableHeaders);
        // JScrollPane scrollPane = new JScrollPane();
        // table.setFont(MyFont.tinyFont());
        // table.setForeground(MyColor.textColor());
        // table.setBorder(new EmptyBorder(10, 10, 10, 10));
        // table.setForeground(MyColor.textColor());

        // scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        // scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // scrollPane.setViewportView(table);
        // scrollPane.setBounds(40, 110, 500, 480);
        // panel.add(scrollPane);

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
        }
    }

}
