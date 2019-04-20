package gui;

import gui.student.*;
import gui.teacher.*;

import dbfunctions.Teacherdb;

import gui.components.MyColor;
import gui.components.MyFont;

import gui.utilities.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Homes extends JFrame implements ActionListener, MouseListener {
    private JLabel textLabel, usernameLabel, passwordLabel, singupText, boxOne, boxTwo;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton, homeButton, backButton, tempBtn;
    private JPanel panel;
    private JOptionPane errorMessage, errorPane;

    // Components
    private MyColor color;
    private MyFont font;

    public Homes() {
        super("Home");
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

        // Teacher Login Elements

        textLabel = new JLabel("Sign in");
        textLabel.setBounds(245, 110, 300, 60);
        textLabel.setFont(font.getHeaderFont());
        textLabel.setForeground(Color.black);
        panel.add(textLabel);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(font.getprimaryFont());
        usernameLabel.setBounds(130, 200, 120, 30);
        usernameLabel.setForeground(color.getTextColor());
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 240, 340, 40);
        usernameField.setFont(font.getprimaryFont());
        panel.add(usernameField);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(font.getprimaryFont());
        passwordLabel.setForeground(color.getTextColor());
        passwordLabel.setBounds(130, 290, 120, 40);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(font.getprimaryFont());
        passwordField.setBounds(130, 330, 340, 40);
        panel.add(passwordField);

        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(225, 400, 150, 50);
        loginButton.setFont(font.getprimaryFont());
        loginButton.setForeground(color.getBgColor());
        loginButton.setBackground(color.getsecondaryButtonColor());
        panel.add(loginButton);

        // tempBtn = new JButton("Go to Student Page");
        // tempBtn.setBounds(60, 500, 400, 100);
        // tempBtn.setFont(font.getprimaryFont());
        // tempBtn.setForeground(color.getBgColor());
        // tempBtn.setBackground(color.getButtonColor());
        // tempBtn.addActionListener(this);
        // panel.add(tempBtn);

        singupText = new JLabel("Forget your password?");
        singupText.setFont(font.getSmallFont());
        singupText.setForeground(color.getTextColor());
        singupText.setBounds(225, 500, 300, 40);
        panel.add(singupText);

        textLabel = new JLabel("Hello, there!");
        textLabel.setBounds(583, 200, 300, 60);
        textLabel.setFont(font.getHeaderFont());
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        textLabel = new JLabel("Don't have an account?");
        textLabel.setBounds(590, 280, 300, 60);
        textLabel.setFont(font.getMediumFont());
        textLabel.setForeground(Color.white);
        panel.add(textLabel);

        signupButton = new JButton("SIGN  UP");
        signupButton.setBounds(630, 350, 145, 45);
        signupButton.setBorder(new LineBorder(Color.white));
        signupButton.setFont(font.getprimaryFont());
        signupButton.setForeground(color.getBgColor());
        signupButton.setBackground(color.getsecondaryButtonColor());
        panel.add(signupButton);

        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
        loginButton.addMouseListener(this);
        signupButton.addMouseListener(this);

        boxOne = new JLabel();
        boxOne.setBounds(100, 80, 400, 500);
        boxOne.setFont(font.getHeaderFont());
        boxOne.setOpaque(true);
        boxOne.setBackground(Color.white);
        panel.add(boxOne);

        boxOne = new JLabel();
        boxOne.setBounds(500, 80, 400, 500);
        boxOne.setFont(font.getHeaderFont());
        boxOne.setOpaque(true);
        boxOne.setBackground(color.getsecondaryButtonColor());
        panel.add(boxOne);

        this.add(panel);
    }

    // Action Listeners

    public void actionPerformed(ActionEvent e) {

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