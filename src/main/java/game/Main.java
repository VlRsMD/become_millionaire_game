package game;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static String valid_username;

    // method to log the user in
    public static void log_in() throws SQLException {
        System.out.println("Introduce your username: ");
        Scanner scan =  new Scanner(System.in);
        String username = scan.nextLine();
        // in case the username introduced is valid
        if (db_actions.check_if_present(username) == 1) {
            System.out.println("Log in successful.");
            valid_username = username;
        }
        // in case the username introduced is invalid
        else {
            System.out.println("Invalid username. Try again or create a new account instead? [Try again/Sign up]");
            Scanner scan_1 =  new Scanner(System.in);
            String answer = scan_1.nextLine();
            // try to log in once again
            if (answer.equals("Try again")) {
                log_in();
            }
            // switch to the signup procedure
            else if (answer.equals("Sign up")) {
                sign_up();
            }
        }
    }

    // method to create a new account
    public static void sign_up () throws SQLException {
        // create a new account given the new player's username
        System.out.println("Please create an account by introducing your username: ");
        Scanner scan =  new Scanner(System.in);
        String username = scan.nextLine();
        db_actions.create_player(username);
        valid_username = username;
        System.out.println("Sign up successful");
    }

    public static int score;

    public static void answer_question(Question question, int level) throws InterruptedException {
        // print out the level of current question and the question itself
        System.out.println("Level " + level + " question: " + question.question);
        // print out answer options
        for (int j = 0; j < question.answersOptions.length; j++) {
            int option_nr = j+1;
            System.out.println(option_nr + ". " + question.answersOptions[j]);
        }
        System.out.println("Introduce the number of the correct answer: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        // in case the answer introduced is correct
        if (id == question.rightOption) {
            score=score+question.score;
            db_actions.insert(valid_username, score);
            System.out.println("\u001B[32m" + "Congratulations! You have answered this question correctly. Your current score is " + score + " points." + "\u001B[0m");
            // if the score of 30 points is reached, player becomes a millionaire
            if (score == 30) {
                // print out congratulation message
                System.out.println("\u001B[33m" + "Congratulations! You have just become a millionaire!" + "\u001B[0m");
                // reset the player's score to 0 so that the player can play the game once again from the beginning
                int reset_score = 0;
                db_actions.insert(valid_username, reset_score);
                Thread.sleep(1000);
                // terminate game
                System.exit(0);
            }
        }
        // in case the answer introduced is incorrect
        else {
            // score becomes 0
            score=0;
            db_actions.insert(valid_username, score);
            System.out.println("\u001B[31m" + "Unfortunately you have answered incorrectly. You may wish to try the game once again!" + "\u001B[0m");
            Thread.sleep(1000);
            // terminate game
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
