package gui.student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import classes.Teacher;

import java.awt.event.*;
import java.awt.*;

import gui.teacher.*;
import gui.Home;

// custom imports 
import gui.utilities.*;

public class StudentHome extends JFrame implements ActionListener {

    private JLabel navBar, welcome, courseText;
    private JButton logoutButton, registration, startExam, resultButton;
    private JComboBox courseList;

    private Teacher teacher;
    private JTable table;
    private String columes[] = { "Exam Name", "No. of Questions", "Total Marks", "Time(minute)" };
    private JScrollPane scroll;
    private JPanel panel;

    public StudentHome(Teacher teacher) {

        super("Student Home");
        this.teacher = teacher;
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Regiser button
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

        courseText = new JLabel("Select From registered courses: ");
        courseText.setForeground(MyColor.textColor());
        courseText.setFont(MyFont.smallFont());
        courseText.setBounds(40, 110, 250, 25);
        panel.add(courseText);

        // Course list comboBox
        String[] petStrings = { "Gali 101", "Common Sense 001", "Golpe Golpe bash khawa", "Priciples of manush howa",
                "Introduction to probation" };
        courseList = new JComboBox(petStrings);
        courseList.setFont(MyFont.primaryFont());
        courseList.setBounds(40, 150, 300, 40);
        courseList.addActionListener(this);
        panel.add(courseList);

        courseText = new JLabel("Course teacher: Sadat Jubayer");
        courseText.setForeground(MyColor.textColor());
        courseText.setFont(MyFont.mediumFont());
        courseText.setBounds(355, 153, 450, 25);
        courseText.setVisible(false);
        panel.add(courseText);

        // The table
        String[][] rows = { { "sdfs", "10", "50", "25" }, { "dfsdf", "100", "550", "250" },
                { "sdfs", "10", "50", "25" }, { "dfsdf", "100", "550", "250" }, { "sdfs", "10", "50", "25" },
                { "dfsdf", "100", "550", "250" }, { "sdfs", "10", "50", "25" }, { "dfsdf", "100", "550", "250" },
                { "sdfs", "10", "50", "25" }, { "dfsdf", "100", "550", "250" }, { "sdfs", "10", "50", "25" },
                { "dfsdf", "100", "550", "250" }, { "sdfs", "10", "50", "25" }, { "dfsdf", "100", "550", "250" },
                { "sdfs", "10", "50", "25" }, { "dfsdf", "100", "550", "250" }, { "sdfs", "10", "50", "25" },
                { "dfsdf", "100", "550", "250" }, { "sdfs", "10", "50", "25" }, { "dfsdf", "100", "550", "250" } };

        table = new JTable(rows, columes);
        table.setFont(MyFont.primaryFont());
        Dimension dim = new Dimension(30, 1);
        table.setIntercellSpacing(new Dimension(dim));
        table.getColumnModel().getColumn(0).setPreferredWidth(250);

        JTableHeader header = table.getTableHeader();
        header.setBackground(MyColor.buleGreyColor());
        header.setFont(MyFont.primaryFont());
        header.setForeground(MyColor.whiteColor());
        table.setSelectionBackground(MyColor.primaryColor());

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (table.getSelectedRow() > -1) {
                    // Here we are getting the exam name TODO: Send the exam name to the next page
                    System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
                }
            }
        });

        scroll = new JScrollPane(table);
        scroll.setBounds(40, 210, 900, 300);
        scroll.setVisible(false);
        panel.add(scroll);

        startExam = new JButton("Start Exam");
        startExam.setFocusPainted(false);
        startExam.setFont(MyFont.smallFont());
        startExam.setBackground(MyColor.primaryColor());
        startExam.setForeground(MyColor.whiteColor());
        startExam.setFocusPainted(false);
        startExam.setBounds(40, 550, 350, 50);
        startExam.addActionListener(this);
        startExam.setVisible(false);
        panel.add(startExam);

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

        this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == logoutButton) {
            dispose();
            Home home = new Home();
            home.setVisible(true);
            home.setLocationRelativeTo(null);
        } else if (ae.getSource() == courseList) {
            System.out.println(courseList.getSelectedItem());
            courseText.setVisible(true);
            scroll.setVisible(true);
            startExam.setVisible(true);
            resultButton.setVisible(true);
        }

    }

}
