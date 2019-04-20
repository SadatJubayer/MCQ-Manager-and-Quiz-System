package gui;

import gui.student.*;
import gui.teacher.*;

import dbfunctions.Teacherdb;
//for navigation
import classes.Teacher;

import gui.components.MyColor;
import gui.components.MyFont;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener, MouseListener {
    private JLabel headerOne, usernameLabel, passwordLabel, singupText;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton, homeButton, backButton, tempBtn;
    private JPanel panel;
    private JSeparator separator;
    private JOptionPane errorMessage, errorPane;

    // Components
    private MyColor color;
    private MyFont font;

    // navigation
    private Teacher teacher;

    public Home() {
        super("Teacher Login");
        initJFrame();
    }

    public void initJFrame() {
        color = new MyColor();
        font = new MyFont();

        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        // myColor = new Color(48, 95, 114, 40);
        panel.setBackground(color.getBgColor());
        panel.setOpaque(false);
        // panel.setBackground(myColor);
        panel.setLayout(null);

        // Separator
        separator = new JSeparator(JSeparator.VERTICAL);
        separator.setBounds(499, 50, 2, 550);
        panel.add(separator);

        // Teacher Login Elements

        headerOne = new JLabel("Teacher Login");
        headerOne.setBounds(200, 110, 300, 40);
        headerOne.setFont(font.getHeaderFont());
        headerOne.setForeground(color.getTextColor());
        panel.add(headerOne);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(font.getprimaryFont());
        usernameLabel.setBounds(60, 200, 120, 40);
        usernameLabel.setForeground(color.getTextColor());
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(160, 200, 300, 40);
        usernameField.setFont(font.getprimaryFont());
        panel.add(usernameField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(font.getprimaryFont());
        passwordLabel.setForeground(color.getTextColor());
        passwordLabel.setBounds(60, 260, 120, 40);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(font.getprimaryFont());
        passwordField.setBounds(160, 260, 300, 40);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(60, 330, 400, 40);
        loginButton.setFont(font.getprimaryFont());
        loginButton.setForeground(color.getBgColor());
        loginButton.setBackground(color.getButtonColor());
        panel.add(loginButton);

        tempBtn = new JButton("Go to Student Page");
        tempBtn.setBounds(60, 500, 400, 100);
        tempBtn.setFont(font.getprimaryFont());
        tempBtn.setForeground(color.getBgColor());
        tempBtn.setBackground(color.getButtonColor());
        tempBtn.addActionListener(this);
        panel.add(tempBtn);

        singupText = new JLabel("Don't have an account?");
        singupText.setFont(font.getSmallFont());
        singupText.setForeground(color.getTextColor());
        singupText.setBounds(60, 400, 300, 40);
        panel.add(singupText);

        signupButton = new JButton("Sign up");
        signupButton.setBounds(250, 400, 210, 40);
        signupButton.setFont(font.getprimaryFont());
        signupButton.setForeground(color.getBgColor());
        signupButton.setBackground(color.getsecondaryButtonColor());
        panel.add(signupButton);

        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
        loginButton.addMouseListener(this);
        signupButton.addMouseListener(this);

        this.add(panel);
    }

    // Action Listeners

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tempBtn) {
            dispose();
            StudentHome sh = new StudentHome(this);
            sh.setLocationRelativeTo(null);
            sh.setVisible(true);
        }

        else if (e.getSource() == loginButton) {

            if (usernameField.getText().equals("") || passwordField.getText().equals("")) {
                errorMessage = new JOptionPane();
                errorMessage.setFont(font.getprimaryFont());
                errorMessage.showMessageDialog(null, "username or password can not be empty", "Wrong Input!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {

                String username = usernameField.getText();
                String password = passwordField.getText();

                Teacher teacher = Teacherdb.login(username, password);

                if (teacher == null) {
                    errorPane = new JOptionPane();
                    errorPane.setFont(font.getprimaryFont());
                    errorPane.showMessageDialog(null, "Username or Password is incorrect", "Wrong Information!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    dispose();
                    System.out.println("in home: "+teacher.getName());
                    TeacherHome teacherHome = new TeacherHome(teacher);
                    teacherHome.setLocationRelativeTo(null);
                    teacherHome.setVisible(true);
                }
            }

        } else if (e.getSource() == signupButton) {

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
        if (e.getSource() == loginButton) {
            loginButton.setBackground(color.getPrimaryHoverColor());
        } else if (e.getSource() == signupButton) {
            signupButton.setBackground(color.getsecondaryHoverColor());
        } else {

        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == loginButton) {
            loginButton.setBackground(color.getButtonColor());
        } else if (e.getSource() == signupButton) {
            signupButton.setBackground(color.getsecondaryButtonColor());
        } else {

        }
    }

}