package gui.student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.List;

import java.util.Timer;
import java.util.TimerTask;

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

public class ParticularExam extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, welcome, ques, choice1, choice2, choice3, choice4, timerLabel;
    private JButton backButton, finishButton, startExam, resultButton, nextButton;
    private JComboBox courseList;
    private ButtonGroup boxCombo;
    private JCheckBox checkOne, checkTwo, checkThree, checkFour;
    private Exam exam;
    private JPanel panel;

    private int timerTime;
    private int timeLeft;
    static Timer timer;

    // navigation
    private Student student; 
    

    public ParticularExam(Student student, Exam exam) {

        super("Particular Exam Page");
        System.out.println("came here");
        this.student = student;
        this.exam = exam;
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        // Register button
        finishButton = new JButton("Finish Exam");
        finishButton.setFocusPainted(false);
        finishButton.setFont(MyFont.smallFont());
        finishButton.setBackground(MyColor.dangerColor());
        finishButton.setForeground(MyColor.whiteColor());
        finishButton.setFocusPainted(false);
        finishButton.setBounds(600, 600, 200, 50);
        finishButton.addActionListener(this);
        panel.add(finishButton);

        // Navbar
        welcome = new JLabel("Welcome Sadat");
        welcome.setForeground(MyColor.whiteColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFocusPainted(false);
        backButton.setFont(MyFont.primaryFont());
        backButton.setBackground(MyColor.lightColor());
        backButton.setForeground(MyColor.dangerColor());
        backButton.setBounds(850, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(MyColor.navbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Questions here:

        ques = new JLabel("Question: ");
        ques.setFont(MyFont.primaryFont());
        ques.setBounds(180, 210, 200, 20);
        ques.setForeground(MyColor.textColor());
        panel.add(ques);

        choice1 = new JLabel("Option one: ");
        choice1.setFont(MyFont.primaryFont());
        choice1.setBounds(180, 282, 150, 20);
        choice1.setForeground(MyColor.textColor());
        panel.add(choice1);

        choice2 = new JLabel("Option two: ");
        choice2.setFont(MyFont.primaryFont());
        choice2.setBounds(180, 332, 200, 20);
        choice2.setForeground(MyColor.textColor());
        panel.add(choice2);

        choice3 = new JLabel("Option three: ");
        choice3.setFont(MyFont.primaryFont());
        choice3.setBounds(180, 382, 200, 20);
        choice3.setForeground(MyColor.textColor());
        panel.add(choice3);

        choice4 = new JLabel("Option four: ");
        choice4.setFont(MyFont.primaryFont());
        choice4.setBounds(180, 432, 200, 20);
        choice4.setForeground(MyColor.textColor());
        panel.add(choice4);

        // Check Boxes

        checkOne = new JCheckBox();
        checkTwo = new JCheckBox();
        checkThree = new JCheckBox();
        checkFour = new JCheckBox();

        boxCombo = new ButtonGroup();
        boxCombo.add(checkOne);
        boxCombo.add(checkTwo);
        boxCombo.add(checkThree);
        boxCombo.add(checkFour);

        checkOne.setOpaque(false);
        checkTwo.setOpaque(false);
        checkThree.setOpaque(false);
        checkFour.setOpaque(false);

        timerLabel = new JLabel("200");
        timerLabel.setBounds(100, 100, 100, 30);
        timerLabel.setFont(MyFont.bigFont());
        panel.add(timerLabel);

        checkOne.setBounds(720, 280, 50, 30);
        panel.add(checkOne);
        checkTwo.setBounds(720, 330, 50, 30);
        panel.add(checkTwo);
        checkThree.setBounds(720, 380, 50, 30);
        panel.add(checkThree);
        checkFour.setBounds(720, 430, 50, 30);
        panel.add(checkFour);

        // Button

        nextButton = new JButton("Next");
        nextButton.setBounds(300, 520, 400, 40);
        nextButton.setFont(MyFont.primaryFont());
        nextButton.setForeground(MyColor.whiteColor());
        nextButton.setBackground(MyColor.primaryColor());
        nextButton.addActionListener(this);
        panel.add(nextButton);

        // Set time here
        timerTime = 2000;

        CountDown cd = new CountDown(10);
        while (true) {
            timerLabel.setText(Integer.toString(CountDown.staticSecond));
            System.out.println("ddddL:" + CountDown.staticSecond);
            if (cd.staticSecond == 0)
                break;
        }

        // Timer showing on GUI

        // timer for changing gui or reloading gui*
        // Timer timerTwo = new Timer(1000, al);
        // timerTwo.setRepeats(false);
        // timerTwo.start();

        this.add(panel);
    }

    ActionListener al = new ActionListener() {

        public void actionPerformed(ActionEvent e) { // reload page
            ParticularExam sh = new ParticularExam(student, exam);
            dispose();
            sh.setVisible(true);
            sh.setLocationRelativeTo(null);
        }
    };

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            StudentHome sh = new StudentHome(student);
            dispose();
            sh.setVisible(true);
            sh.setLocationRelativeTo(null);
        }

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {
    }

}
