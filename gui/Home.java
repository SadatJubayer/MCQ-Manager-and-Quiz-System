package gui;

import gui.student.*;
import gui.teacher.*;

import classes.*;
import dbfunctions.Teacherdb;

import gui.utilities.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Home extends JFrame implements ActionListener, MouseListener {
    private JLabel textLabel, usernameLabel, passwordLabel, singupText, boxOne, boxTwo;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton, tempBtn;
    private JPanel panel;
    private JOptionPane errorMessage, errorPane;

    private Teacher teacher;

    public Home() {
        super("Home");

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(MyColor.whiteBg());
        panel.setOpaque(false);
        panel.setLayout(null);

        // Teacher Login Elements

        textLabel = new JLabel("Sign in");
        textLabel.setBounds(245, 110, 300, 60);
        textLabel.setFont(MyFont.headerFont());
        textLabel.setForeground(Color.black);
        panel.add(textLabel);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(MyFont.primaryFont());
        usernameLabel.setBounds(130, 200, 120, 30);
        usernameLabel.setForeground(MyColor.textColor());
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 240, 340, 40);
        usernameField.setFont(MyFont.primaryFont());
        panel.add(usernameField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(MyFont.primaryFont());
        passwordLabel.setForeground(MyColor.textColor());
        passwordLabel.setBounds(130, 290, 120, 40);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(MyFont.primaryFont());
        passwordField.setBounds(130, 330, 340, 40);
        panel.add(passwordField);

        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(225, 410, 150, 45);
        loginButton.setFont(MyFont.primaryFont());
        loginButton.setForeground(MyColor.whiteColor());
        loginButton.setBackground(MyColor.redColor());
        panel.add(loginButton);

        tempBtn = new JButton("Go to Student Page");
        tempBtn.setBounds(60, 650, 400, 100);
        tempBtn.setFont(MyFont.primaryFont());
        tempBtn.addActionListener(this);
        panel.add(tempBtn);

        singupText = new JLabel("Forget your password?");
        singupText.setFont(MyFont.smallFont());
        singupText.setForeground(MyColor.textColor());
        singupText.setBounds(220, 480, 300, 40);
        panel.add(singupText);

        textLabel = new JLabel("Hello, there!");
        textLabel.setBounds(600, 200, 300, 60);
        textLabel.setFont(MyFont.headerFont());
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        textLabel = new JLabel("Don't have an account?");
        textLabel.setBounds(590, 280, 300, 60);
        textLabel.setFont(MyFont.mediumFont());
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        signupButton = new JButton("SIGN  UP");
        signupButton.setBounds(630, 350, 145, 45);
        signupButton.setBorder(new LineBorder(Color.white));
        signupButton.setFont(MyFont.primaryFont());
        signupButton.setForeground(MyColor.whiteColor());
        signupButton.setBackground(MyColor.redColor());
        panel.add(signupButton);

        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
        loginButton.addMouseListener(this);
        signupButton.addMouseListener(this);

        boxOne = new JLabel();
        boxOne.setBounds(100, 80, 400, 500);
        boxOne.setFont(MyFont.headerFont());
        boxOne.setOpaque(true);
        boxOne.setBackground(Color.white);
        panel.add(boxOne);

        boxOne = new JLabel();
        boxOne.setBounds(500, 80, 400, 500);
        boxOne.setFont(MyFont.headerFont());
        boxOne.setOpaque(true);
        boxOne.setBackground(MyColor.redColor());
        panel.add(boxOne);

        this.add(panel);
    }

    // Action Listeners

    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();

        if (actionCommand.equals(signupButton.getText())) {
            this.dispose();
            SignupPage sp = new SignupPage();
            sp.setLocationRelativeTo(null);
            sp.setResizable(false);
            sp.setVisible(true);
        }

        else if (actionCommand.equals(loginButton.getText())) {

            if (usernameField.getText().equals("") || passwordField.getText().equals("")) {
                errorMessage = new JOptionPane();
                errorMessage.setFont(MyFont.primaryFont());
                errorMessage.showMessageDialog(null, "username or password can not be empty", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {

                String username = usernameField.getText();
                String password = passwordField.getText();

                teacher = Teacherdb.login(username, password);

                if (teacher == null) {
                    errorPane = new JOptionPane();
                    errorPane.setFont(MyFont.primaryFont());
                    errorPane.showMessageDialog(null, "Username or Password is incorrect", "Wrong Information!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    dispose();
                    System.out.println("in home: " + teacher.getName());
                    TeacherHome teacherHome = new TeacherHome(teacher);
                    teacherHome.setLocationRelativeTo(null);
                    teacherHome.setVisible(true);
                }
            }

        } else if (actionCommand.equals(tempBtn.getText())) {
            dispose();
            StudentHome sh = new StudentHome(teacher);
            sh.setLocationRelativeTo(null);
            sh.setVisible(true);
        }
    }

    // Mouse listeners

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