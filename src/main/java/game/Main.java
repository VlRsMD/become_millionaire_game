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

    public static List<Integer> rand_i(int length) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i<length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    public static void play() throws SQLException, InterruptedException {
        List<Integer> list_r = rand_i(all_questions.game_questions().length);
        int score=0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<all_questions.game_questions().length; i++) {
            int index = list_r.get(i);
            Question rand_q = all_questions.game_questions()[index];
            int question_nr = i+1;
            System.out.println("Question " + question_nr + ": " + rand_q.question);
            for (int j = 0; j < rand_q.answersOptions.length; j++) {
                int option_nr = j+1;
                System.out.println(option_nr + ". " + rand_q.answersOptions[j]);
            }
            System.out.println("Introduce the number of the correct answer: ");
            Scanner scan = new Scanner(System.in);
            int id = scan.nextInt();
            if (id == rand_q.rightOption) {
                score++;
                db_actions.insert(valid_username, score);
                System.out.println("\u001B[32m" + "Congratulations! You have answered this question correctly. Your current score is " + score + " points." + "\u001B[0m");
                if (score == all_questions.game_questions().length) {
                    System.out.println("\u001B[33m" + "Congratulations! You have just become a millionaire!" + "\u001B[0m");
                    int reset_score = 0;
                    db_actions.insert(valid_username, reset_score);
                    break;
                }
            } else {
                score=0;
                db_actions.insert(valid_username, score);
                System.out.println("\u001B[31m" + "Unfortunately you have answered incorrectly. You may wish to try the game once again!" + "\u001B[0m");
                Thread.sleep(1000);
                break;
            }
        }
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
