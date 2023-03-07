package game;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static String valid_username;

    public static void log_in() throws SQLException {
        System.out.println("Introduce your username: ");
        Scanner scan =  new Scanner(System.in);
        String username = scan.nextLine();
        if (db_actions.check_if_present(username) == 1) {
            System.out.println("Log in successful.");
            valid_username = username;
        } else {
            System.out.println("Invalid username. Try again or create a new account instead? [Try again/Sign up]");
            Scanner scan_1 =  new Scanner(System.in);
            String answer = scan_1.nextLine();
            if (answer.equals("Try again")) {
                log_in();
            } else if (answer.equals("Sign up")) {
                sign_up();
            }
        }
    }

    public static void sign_up () throws SQLException {
        System.out.println("Please create an account by introducing your username: ");
        Scanner scan =  new Scanner(System.in);
        String username = scan.nextLine();
        db_actions.create_player(username);
        valid_username = username;
        System.out.println("Sign up successful");
    }

    public static int score;

    public static void answer_question(Question question, int level) throws InterruptedException {
        System.out.println("Level " + level + " question: " + question.question);
        for (int j = 0; j < question.answersOptions.length; j++) {
            int option_nr = j+1;
            System.out.println(option_nr + ". " + question.answersOptions[j]);
        }
        System.out.println("Introduce the number of the correct answer: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        if (id == question.rightOption) {
            score=score+question.score;
            db_actions.insert(valid_username, score);
            System.out.println("\u001B[32m" + "Congratulations! You have answered this question correctly. Your current score is " + score + " points." + "\u001B[0m");
            if (score == 30) {
                System.out.println("\u001B[33m" + "Congratulations! You have just become a millionaire!" + "\u001B[0m");
                int reset_score = 0;
                db_actions.insert(valid_username, reset_score);
                Thread.sleep(1000);
                System.exit(0);
            }
        } else {
            score=0;
            db_actions.insert(valid_username, score);
            System.out.println("\u001B[31m" + "Unfortunately you have answered incorrectly. You may wish to try the game once again!" + "\u001B[0m");
            Thread.sleep(1000);
            System.exit(0);
        }
    }

    public static void play() throws SQLException, InterruptedException {
        score=0;
        Random rand = new Random();
        // random level 1 question
        int r1 = rand.nextInt(3);
        Question q1 = all_questions.level_1()[r1];
        int l1 = 1;
        answer_question(q1, l1);
        // random level 2 question
        int r2 = rand.nextInt(3);
        Question q2 = all_questions.level_2()[r2];
        int l2 = 2;
        answer_question(q2, l2);
        // random level 3 question
        int r3 = rand.nextInt(3);
        Question q3 = all_questions.level_3()[r3];
        int l3 = 3;
        answer_question(q3, l3);
        // random level 4 question
        int r4 = rand.nextInt(3);
        Question q4 = all_questions.level_4()[r4];
        int l4 = 4;
        answer_question(q4, l4);
        // random level 5 question
        int r5 = rand.nextInt(3);
        Question q5 = all_questions.level_5()[r5];
        int l5 = 5;
        answer_question(q5, l5);
    }

    public static void main(String[] args) throws SQLException, InterruptedException {
        System.out.println("Welcome to the game 'Become a millionaire!'");
        System.out.println("Do you already have an account? [Yes/No]");
        Scanner scan =  new Scanner(System.in);
        String y_n = scan.nextLine();
        if (y_n.equals("Yes")) {
            log_in();
        } else if (y_n.equals("No")) {
            sign_up();
        }
        play();
    }
}
