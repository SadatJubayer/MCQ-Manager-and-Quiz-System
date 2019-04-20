package gui.student;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import gui.teacher.*;
import gui.Home;

// custom imports 
import gui.utilities.MyColor;
import gui.utilities.MyFont;

public class StudentHome extends JFrame implements ActionListener {

    private JLabel navBar, welcome, courses;
    private JButton logoutButton, registration;

    private JPanel panel;

    private Home teacher;

    public StudentHome(Home teacher) {

        super("Student Home");
        this.teacher = teacher;
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Navbar

        welcome = new JLabel("Welcome");
        welcome.setForeground(MyColor.textColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        logoutButton = new JButton("Logout");
        logoutButton.setFocusPainted(false);
        logoutButton.setBounds(850, 13, 100, 35);
        logoutButton.addActionListener(this);
        panel.add(logoutButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        courses = new JLabel("My Courses:");
        courses.setBackground(MyColor.successColor());
        courses.setFont(MyFont.mediumFont());
        courses.setBounds(40, 70, 120, 25);
        panel.add(courses);

        String subject[] = { "Math", " fdgfsd", "SQL", "   java", "  c ", " c++ ", " cobol ", "this is a test", "Math",
                " English", "SQL", "   java", "  c ", " c++ ", " cobol ", "this is a test", "Math", " English", "SQL",
                "   java", "  c ", " c++ ", " cobol ", "this is a test", "Math", " English", "SQL", "   java", "  c ",
                " c++ ", " cobol ", "this is a test" };

        JScrollPane scrollPane = new JScrollPane();
        JList list = new JList(subject);
        list.setBackground(MyColor.infoColor());
        list.setForeground(MyColor.primaryColor());

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(list);
        scrollPane.setBounds(10, 200, 250, 400);
        panel.add(scrollPane);

        registration = new JButton("Registration for Courses");
        registration.setFocusPainted(false);
        registration.setFont(MyFont.primaryFont());
        registration.setBackground(MyColor.dangerColor());
        registration.setForeground(MyColor.textColor());
        registration.setBounds(400, 100, 250, 45);
        registration.addActionListener(this);
        panel.add(registration);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();

        if (action.equals(logoutButton.getText())) {
            dispose();
            teacher.setLocationRelativeTo(null);
            teacher.setVisible(true);
        } else {

        }
    }

}
