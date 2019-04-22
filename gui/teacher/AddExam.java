package gui.teacher;

import gui.utilities.*;

import dbfunctions.Examdb;

import classes.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class AddExam extends JFrame implements ActionListener {

    private String teacherName, teacherId;
    private int courseId;

    private JLabel navBar, headerOne, examName, examDuration, welcome, numberOfQuestion;
    private JTextField examNameField, examDurationField, numberOfQuestionField;
    private JButton createExam, backButton;
    private JPanel panel;
    private JOptionPane errorMessage, errorPane, successPane;
    JToggleButton toggleButton;

    // navigation
    private Teacher teacher;
    private Course course;

    public AddExam(Teacher teacher, Course course) {

        super("Add Exam");

        this.teacher = teacher;
        this.course = course;
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(MyColor.whiteBg());
        panel.setLayout(null);

        // Navbar
        welcome = new JLabel("Course: " + course.getName());
        welcome.setFont(MyFont.primaryFont());
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(700, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.dangerColor());
        backButton.setForeground(MyColor.whiteColor());
        backButton.setFocusPainted(false);
        backButton.setBounds(40, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Teacher Login Elements

        headerOne = new JLabel("Create Exam here");
        headerOne.setBounds(372, 120, 400, 40);
        headerOne.setFont(MyFont.headerFont());
        headerOne.setForeground(MyColor.textColor());
        panel.add(headerOne);

        examName = new JLabel("Exam Name: ");
        examName.setFont(MyFont.smallFont());
        examName.setBounds(300, 200, 200, 20);
        examName.setForeground(MyColor.textColor());
        panel.add(examName);

        examNameField = new JTextField();
        examNameField.setBounds(300, 230, 400, 40);
        examNameField.setFont(MyFont.primaryFont());
        panel.add(examNameField);

        examDuration = new JLabel("Exam Duration: (in minutes)");
        examDuration.setFont(MyFont.smallFont());
        examDuration.setBounds(300, 300, 400, 20);
        examDuration.setForeground(MyColor.textColor());
        panel.add(examDuration);

        examDurationField = new JTextField();
        examDurationField.setBounds(300, 330, 400, 40);
        examDurationField.setFont(MyFont.primaryFont());
        panel.add(examDurationField);

        numberOfQuestion = new JLabel("Number of Questions:");
        numberOfQuestion.setFont(MyFont.smallFont());
        numberOfQuestion.setBounds(300, 400, 200, 20);
        numberOfQuestion.setForeground(MyColor.textColor());
        panel.add(numberOfQuestion);

        numberOfQuestionField = new JTextField();
        numberOfQuestionField.setBounds(300, 430, 400, 40);
        numberOfQuestionField.setFont(MyFont.primaryFont());
        panel.add(numberOfQuestionField);

        createExam = new JButton("Create Exam");
        createExam.setBounds(300, 530, 400, 40);
        createExam.setFont(MyFont.primaryFont());
        createExam.setForeground(MyColor.whiteColor());
        createExam.setBackground(MyColor.primaryColor());
        createExam.addActionListener(this);
        panel.add(createExam);

        this.add(panel);
    }

    // Action Listeners

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createExam) {

            if (examNameField.getText().equals("") || examDurationField.getText().equals("")
                    || numberOfQuestionField.getText().equals("")) {
                errorMessage = new JOptionPane();
                errorMessage.setFont(MyFont.primaryFont());
                errorMessage.showMessageDialog(null, "All fields are required!", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {

                // TODO: add hh:MM
                String descripton = examNameField.getText();
                int duration = Integer.parseInt(examDurationField.getText());
                int numberOfQuestion = Integer.parseInt(numberOfQuestionField.getText());

                // Database checking here
                Examdb.createExam(course.getId(), descripton, numberOfQuestion, duration);

                examNameField.setText("");
                examDurationField.setText("");
                numberOfQuestionField.setText("");

                // Go back to home
                successPane = new JOptionPane();
                successPane.setFont(MyFont.primaryFont());
                successPane.showMessageDialog(null, "Exam Created Successfully!", "Success!",
                        JOptionPane.WARNING_MESSAGE);

            }

        } else if (e.getSource() == backButton) {
            dispose();
            ExamPage tm = new ExamPage(teacher, course);
            tm.setLocationRelativeTo(null);
            tm.setVisible(true);
        }

    }
}