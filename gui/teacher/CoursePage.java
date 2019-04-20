package gui.teacher;

import gui.Home;
import gui.components.*;
import dbfunctions.Questiondb;
import dbfunctions.Coursedb;
import classes.Course;
import classes.Question;

//navigation
import classes.Teacher;

import java.util.List;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CoursePage extends JFrame implements ActionListener, MouseListener {

    private JLabel navBar, titleBar, welcome, boxOne, title, oneLabel, twoLabel, threeLabel, fourLabel;
    private JButton addQuestion, addExam, studentListButton, requests, logoutButton, updateButton, deleteBtn,
            backButton;
    private JTextField theQuestion, choice1, choice2, choice3, choice4;
    private JCheckBox checkOne, checkTwo, checkThree, checkFour;
    private ButtonGroup boxCombo;

    private JScrollPane scrollPane;

    private JList questionList;
    JOptionPane confirmDelete;

    private JPanel panel;

    private List<Question> courseQuestion;
    // Components
    private MyColor color;
    private MyFont font;

    private int questionId;
    private Question question;

    // navigation
    private Teacher teacher;
    // private Home home;
    private Course course;

    public CoursePage(Teacher teacher, Course course) {

        super("Course page");

        // got from navigation
        // this.home = home;
        this.teacher = teacher;
        this.course = course;

        // this.teacherId = Integer.toString(courseId);

        // UI Elements
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        color = new MyColor();
        font = new MyFont();

        // Navbar

        welcome = new JLabel("Welcome " + teacher.getName());
        welcome.setFont(font.getMediumFont());
        welcome.setForeground(color.getBgColor());
        welcome.setBounds(40, 18, 400, 25);
        panel.add(welcome);

        backButton = new JButton("Back");
        backButton.setFont(font.getprimaryFont());
        backButton.setBackground(color.getsecondaryButtonColor());
        backButton.setForeground(color.getBgColor());
        backButton.setFocusPainted(false);
        backButton.setBounds(850, 13, 100, 35);
        backButton.addActionListener(this);
        panel.add(backButton);

        navBar = new JLabel();
        navBar.setOpaque(true);
        navBar.setBackground(color.getNavbarColor());
        navBar.setBounds(5, 5, 975, 50);
        panel.add(navBar);

        // Input boxes

        theQuestion = new JTextField();
        theQuestion.setBounds(620, 110, 312, 60);
        theQuestion.setBackground(color.getBgColor());
        theQuestion.setFont(font.getMediumFont());
        panel.add(theQuestion);

        choice1 = new JTextField();
        choice1.setBounds(650, 200, 200, 35);
        choice1.setBackground(color.getBgColor());
        choice1.setFont(font.getMediumFont());
        panel.add(choice1);

        choice2 = new JTextField();
        choice2.setBounds(650, 250, 200, 35);
        choice2.setBackground(color.getBgColor());
        choice2.setFont(font.getMediumFont());
        panel.add(choice2);

        choice3 = new JTextField();
        choice3.setBounds(650, 300, 200, 35);
        choice3.setBackground(color.getBgColor());
        choice3.setFont(font.getMediumFont());
        panel.add(choice3);

        choice4 = new JTextField();
        choice4.setBounds(650, 350, 200, 35);
        choice4.setBackground(color.getBgColor());
        choice4.setFont(font.getMediumFont());
        panel.add(choice4);

        checkOne = new JCheckBox();
        checkTwo = new JCheckBox();
        checkThree = new JCheckBox();
        checkFour = new JCheckBox();

        checkOne.setBounds(950, 250, 50, 30);
        panel.add(checkOne);
        checkTwo.setBounds(950, 300, 50, 30);
        panel.add(checkTwo);
        checkThree.setBounds(950, 350, 50, 30);
        panel.add(checkThree);
        checkFour.setBounds(950, 400, 50, 30);
        panel.add(checkFour);

        boxCombo = new ButtonGroup();
        boxCombo.add(checkOne);
        boxCombo.add(checkTwo);
        boxCombo.add(checkThree);
        boxCombo.add(checkFour);

        oneLabel = new JLabel("1)");
        oneLabel.setBounds(620, 200, 30, 20);
        oneLabel.setFont(font.getprimaryFont());
        oneLabel.setForeground(color.getBgColor());
        panel.add(oneLabel);

        twoLabel = new JLabel("2)");
        twoLabel.setBounds(620, 250, 30, 20);
        twoLabel.setFont(font.getprimaryFont());
        twoLabel.setForeground(color.getBgColor());
        panel.add(twoLabel);

        threeLabel = new JLabel("3)");
        threeLabel.setBounds(620, 300, 30, 20);
        threeLabel.setFont(font.getprimaryFont());
        threeLabel.setForeground(color.getBgColor());
        panel.add(threeLabel);

        fourLabel = new JLabel("4)");
        fourLabel.setBounds(620, 350, 30, 20);
        fourLabel.setFont(font.getprimaryFont());
        fourLabel.setForeground(color.getBgColor());
        panel.add(fourLabel);

        // Buttons

        addQuestion = new JButton("ADD Question");
        addQuestion.setFont(font.getMediumFont());
        addQuestion.setBackground(color.getButtonColor());
        addQuestion.setForeground(color.getBgColor());
        addQuestion.setFocusPainted(false);
        addQuestion.setBounds(30, 100, 200, 80);
        addQuestion.addActionListener(this);
        panel.add(addQuestion);

        addExam = new JButton("Exam");
        addExam.setFont(font.getMediumFont());
        addExam.setBackground(color.getButtonColor());
        addExam.setForeground(color.getBgColor());
        addExam.setFocusPainted(false);
        addExam.setBounds(30, 240, 200, 80);
        addExam.addActionListener(this);
        panel.add(addExam);

        studentListButton = new JButton("Student List");
        studentListButton.setFont(font.getMediumFont());
        studentListButton.setBackground(color.getButtonColor());
        studentListButton.setForeground(color.getBgColor());
        studentListButton.setFocusPainted(false);
        studentListButton.setBounds(30, 380, 200, 80);
        studentListButton.addActionListener(this);
        panel.add(studentListButton);

        requests = new JButton("Requests");
        requests.setFont(font.getMediumFont());
        requests.setBackground(color.getButtonColor());
        requests.setForeground(color.getBgColor());
        requests.setFocusPainted(false);
        requests.setBounds(30, 520, 200, 80);
        requests.addActionListener(this);
        panel.add(requests);

        titleBar = new JLabel();
        titleBar.setOpaque(true);
        titleBar.setBackground(color.gettitleBarColor());
        titleBar.setBounds(255, 100, 2, 500);
        panel.add(titleBar);

        title = new JLabel("Available Questions");
        title.setFont(font.getSmallFont());
        title.setBounds(280, 75, 300, 25);
        panel.add(title);

        courseQuestion = Questiondb.getAllQuestionList(course.getId());

        int length = courseQuestion.size();
        String questionBak[] = new String[length];
        int i = 0;
        for (Question c : courseQuestion) {
            questionBak[i] = c.getDescription();
            i++;
        }

        questionList = new JList(questionBak);
        questionList.setFont(font.getMediumFont());
        questionList.setForeground(color.getTextColor());
        questionList.setBounds(280, 100, 300, 500);
        questionList.addMouseListener(this);
        panel.add(questionList);

        boxOne = new JLabel();
        boxOne.setOpaque(true);
        boxOne.setBackground(color.gettBackgroundColor());
        boxOne.setBounds(600, 100, 355, 320);
        panel.add(boxOne);

        updateButton = new JButton("Update");

        updateButton.setFont(font.getMediumFont());
        updateButton.setBackground(color.getEditButtonColor());
        updateButton.setForeground(color.getBgColor());
        updateButton.setFocusPainted(false);
        updateButton.setEnabled(false);
        updateButton.setBounds(652, 450, 100, 50);
        updateButton.addActionListener(this);
        panel.add(updateButton);

        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(font.getMediumFont());
        deleteBtn.setBackground(color.getEditButtonColor());
        deleteBtn.setForeground(color.getBgColor());
        deleteBtn.setFocusPainted(false);
        deleteBtn.setEnabled(false);
        deleteBtn.setBounds(850, 450, 100, 50);
        deleteBtn.addActionListener(this);
        panel.add(deleteBtn);

        this.add(panel);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {

            this.dispose();
            // navigation
            TeacherHome f = new TeacherHome(teacher);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } else if (e.getSource() == addQuestion) {

            System.out.println("Add Question Clicked");
            this.dispose();
            AddQuestion f = new AddQuestion(teacher, course);
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        } else if (e.getSource() == addExam) {
            System.out.println("Add Exam Clicked");

            this.dispose();
            ExamPage exam = new ExamPage(teacher, course);
            exam.setLocationRelativeTo(null);
            exam.setVisible(true);

        } else if (e.getSource() == requests) {
            System.out.println("Requests Clicked");
        } else if (e.getSource() == studentListButton) {

            this.dispose();
            StudentList sl = new StudentList(teacher, course);
            sl.setLocationRelativeTo(null);
            sl.setVisible(true);

        } else if (e.getSource() == updateButton) {

            String correctChoice = null;

            if (checkOne.isSelected()) {
                correctChoice = choice1.getText();
            } else if (checkTwo.isSelected()) {
                correctChoice = choice2.getText();
            } else if (checkThree.isSelected()) {
                correctChoice = choice3.getText();
            } else if (checkFour.isSelected()) {
                correctChoice = choice4.getText();
            }

            // TODO: set selected item and check empty

            Question q = new Question(question.getId(), theQuestion.getText(), choice1.getText(), choice2.getText(),
                    choice3.getText(), choice4.getText(), correctChoice);
            Questiondb.updateQuestion(q);
        }

        else if (e.getSource() == deleteBtn) {
            System.out.println("Delete question Clicked");

            confirmDelete = new JOptionPane();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = confirmDelete.showConfirmDialog(null, "Are you sure to delete the course?", "Warning",
                    dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                Questiondb.deleteQuestion(courseQuestion.get(questionId).getId());
                this.dispose();
                CoursePage cp = new CoursePage(teacher, course);
                cp.setLocationRelativeTo(null);
                cp.setVisible(true);
            } else {
            }

        }

    }

    public void mouseClicked(MouseEvent e) {

        System.out.println("Mouse clicked");

        if (e.getSource() == questionList) {

            updateButton.setEnabled(true);
            deleteBtn.setEnabled(true);

            int selected = questionList.getSelectedIndex();

            System.out.println(selected);

            List<Question> c = Questiondb.getAllQuestionList(course.getId());

            String myQuestion = c.get(selected).getDescription();
            String choiceOne = c.get(selected).getChoiceOne();
            String choiceTwo = c.get(selected).getChoiceTwo();
            String choiceThree = c.get(selected).getChoiceThree();
            String choiceFour = c.get(selected).getChoiceFour();
            String currectChoice = c.get(selected).getCorrectChoice();
            questionId = selected;
            question = c.get(selected);

            System.out.println(currectChoice);

            theQuestion.setText(myQuestion);
            choice1.setText(choiceOne);
            choice2.setText(choiceTwo);
            choice3.setText(choiceThree);
            choice4.setText(choiceFour);

        } else {

        }

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
