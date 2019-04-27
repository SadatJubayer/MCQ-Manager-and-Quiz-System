import java.util.Scanner;

import classes.*;
import dbfunctions.*;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

//TODO: it will take, student and exam parameter, for the time being I am just working with id
//TODO: gui willc omome here as well
public class RunExam {

    private LocalTime endTime;
    private List<Question> questions;
    private List<Question> doneAnswering = new ArrayList<Question>();
    private int marks;

    // remove scanner class after gui has ben added
    Scanner sc = new Scanner(System.in);

    public RunExam(int studentId, int examId) {

        // the duration will comefrom Exam objects
        // TODO: first take the system time, then add duration in minutes with it
        endTime = LocalTime.now().plusMinutes(2);
        System.out.println("endtime::::" + endTime);
        questions = Examdb.getExamQuestions(examId);
        Collections.shuffle(questions);

        run();

    }

    public void run() {
        System.out.println("timeleft():: " + timeLeft());

        for (Question q : questions) {

            if (timeLeft() == 0) {
                System.out.println("time is up!!!!");
                // FIXME: will be done with marks
                // database insertion will happen here
                System.out.println("you got " + marks + " marks");
            }

            System.out.println("questionLength:::" + questions.size());

            // description
            System.out.println(q.getDescription());
            // choices
            System.out.println(q.getChoiceOne());
            System.out.println(q.getChoiceTwo());
            System.out.println(q.getChoiceThree());
            System.out.println(q.getChoiceFour());
            // get answer
            System.out.println("enter choice: ");

            String choice = sc.nextLine();

            // it will be replaced by pass
            // the action will happen upon clicking on the next button
            // when user will not select any answer and click next, the they are NOT done
            // answering the question
            if (q.isCorrect(choice)) {
                System.out.println("correct!!!!!!!!!!!!!!!!!!!");
                doneAnswering.add(q);
                marks++;
            }

        }
        removeDoneAnswering();

        if (questions.size() != 0)
            run();

    }

    // when it will return 0, there is no time
    public long timeLeft() {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        long elapsedMinutes = Duration.between(time, endTime).toMinutes();
        return elapsedMinutes;
    }

    public void removeDoneAnswering() {
        for (Question q : doneAnswering) {
            questions.remove(q);
            System.out.println("int done answering: " + questions.size());
        }
    }

    public static void main(String args[]) {
        RunExam runExam = new RunExam(1, 36);
    }
}
