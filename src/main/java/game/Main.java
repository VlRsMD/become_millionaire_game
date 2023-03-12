package game;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static String scanString() {
        Scanner scan =  new Scanner(System.in);
        String str = scan.nextLine();
        return str;
    }

    // method to log the user in
    public static void logIn(GameSession gS) throws SQLException, InputMismatchException {
        System.out.println("Introduce your username: ");
        String username = scanString();
        // in case the username introduced is valid
        if (DatabaseActions.checkPresence(username) == 1) {
            long timestamp = System.currentTimeMillis();
            gS.setUsername(username);
            String playerID = DatabaseActions.getPlayerID(username);
            DatabaseActions.createRecord(gS.getUuid(), playerID, timestamp);
            System.out.println("Log in successful.");
        }
        // in case the username introduced is invalid
        else {
            System.out.println("Invalid username. Try again or create a new account instead? [Try again/Sign up]");
            String answer = scanString();
            // try to log in once again
            if (answer.equals("Try again")) {
                logIn(gS);
            }
            // switch to the signup procedure
            else if (answer.equals("Sign up")) {
                signUp(gS);
            } else {
                System.out.println("Invalid input");
                System.exit(0);
            }
        }
    }

    // method to create a new account
    public static void signUp(GameSession gS) throws SQLException, InputMismatchException {
        // create a new account given the new player's username
        System.out.println("Please create an account by introducing your username: ");
        String username = scanString();
        long timestamp = System.currentTimeMillis();
        Player player = new Player(username);
        DatabaseActions.createPlayer(player.getUuid(), username);
        gS.setUsername(username);
        DatabaseActions.createRecord(gS.getUuid(), player.getUuid(), timestamp);
        System.out.println("Sign up successful");
    }

    public static void correctAnswer(GameSession gS, Question question) throws SQLException {
        // update the player's score
        gS.setScore(gS.getScore()+question.getScore());
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        System.out.println("\u001B[32m" + "Congratulations! You have answered this question correctly. Your current score is " + gS.getScore() + " points." + "\u001B[0m");
        // if the score of 30 points is reached, player becomes a millionaire
        if (gS.getScore() == 30) {
            // print out congratulation message
            System.out.println("\u001B[33m" + "Congratulations! You have just become a millionaire!" + "\u001B[0m");
            // terminate game
            System.exit(0);
        }
    }

    public static void incorrectAnswer(GameSession gS) throws SQLException {
        gS.setScore(0);
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        System.out.println("\u001B[31m" + "Unfortunately you have answered incorrectly. You may wish to try the game once again!" + "\u001B[0m");
        // terminate game
        System.exit(0);
    }

    public static int useHelp;

    public static void phoneFriend (GameSession gS, Question question, List<Answer> list) throws SQLException {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrectness() == true) {
                int id = i+1;
                System.out.println("\u001B[34m" + "The right answer is nr. " + id + ": " + list.get(i).getAnswer()+"."  + "\u001B[0m");
                break;
            }
        }
        gS.setScore(gS.getScore()+question.getScore());
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        System.out.println("\u001B[32m" + "Your current score is " + gS.getScore() + " points." + "\u001B[0m");
        useHelp ++;
    }

    public static void askAudience (GameSession gS, Question question, List<Answer> list) throws SQLException, InterruptedException, InputMismatchException {
        for(int i=0; i<list.size(); i++) {
            int id = i+1;
            System.out.println("\u001B[34m" + id + ". " + list.get(i).getAnswer() + " - " + list.get(i).getDistributionPercentage()+"%" + "\u001B[0m");
        }
        System.out.println("Choose an option from the above");
        String id = scanString();
        if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
            // in case the answer introduced is correct
            if (list.get(Integer.parseInt(id) - 1).isCorrectness() == true) {
                correctAnswer(gS, question);
            } else {
                incorrectAnswer(gS);
            }
        } else {
            System.out.println("Invalid input.");
            System.exit(0);
        }
        useHelp ++;
    }

    public static void fiftyFifty (GameSession gS, Question question, List<Answer> list) throws SQLException, InterruptedException, InputMismatchException {
        int rightAnswerIndex = 0;
        int wrongAnswerIndex = 0;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).isCorrectness() == true) {
                rightAnswerIndex = i;
                break;
            }
        }
        List<Answer> wrongAnswersList = new ArrayList<Answer>();
        for (int i=0; i<list.size(); i++) {
            if(list.get(i).isCorrectness() == false) {
                wrongAnswersList.add(list.get(i));
            }
        }
        Random rand = new Random();
        int r = rand.nextInt(3);
        Answer wrongAnswer = wrongAnswersList.get(r);
        for (int i=0; i<= list.size(); i++) {
            if(list.get(i).getAnswer() == wrongAnswer.getAnswer()) {
                wrongAnswerIndex = i;
                break;
            }
        }
        int rightAnswerID = rightAnswerIndex+1;
        int wrongAnswerID = wrongAnswerIndex+1;
        List<List<String>> twoOptions = new ArrayList<List<String>>();
        List<String> rightOption = new ArrayList<String>();
        rightOption.add(String.valueOf(rightAnswerID));
        rightOption.add(list.get(rightAnswerIndex).getAnswer());
        List<String> wrongOption = new ArrayList<String>();
        wrongOption.add(String.valueOf(wrongAnswerID));
        wrongOption.add(list.get(wrongAnswerIndex).getAnswer());
        twoOptions.add(rightOption);
        twoOptions.add(wrongOption);
        Collections.shuffle(twoOptions);
        for (int i=0; i<twoOptions.size(); i++) {
            System.out.println("\u001B[34m" + twoOptions.get(i).get(0) + ". " + twoOptions.get(i).get(1) + "\u001B[0m");
        }
        System.out.println("Choose an option from the above");
        String id = scanString();
        if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
            // in case the answer introduced is correct
            if (list.get(Integer.parseInt(id) - 1).isCorrectness() == true) {
                correctAnswer(gS, question);
            } else {
                incorrectAnswer(gS);
            }
        } else {
            System.out.println("Invalid input.");
            System.exit(0);
        }
        useHelp ++;
    }


    public static void answerQuestion(GameSession gS, Question question, int level) throws InterruptedException, SQLException, InputMismatchException {
        // print out the level of current question and the question itself
        System.out.println("Level " + level + " question: " + question.getQuestion());
        List<Answer> answersList = new ArrayList<Answer>();
        for (int i = 0; i < question.getAnswersOptions().length; i++) {
            answersList.add(question.getAnswersOptions()[i]);
        }
        Collections.shuffle(answersList);
        // print out answer options
        for (int j = 0; j < answersList.size(); j++) {
            int option_nr = j+1;
            System.out.println(option_nr + ". " + answersList.get(j).getAnswer());
        }
        if (useHelp == 0) {
            System.out.println("Introduce the number of the correct answer. You can also use once one of the following help options: 'Ask the Audience', 'Phone a Friend', '50/50'. In order to choose the 'Ask the Audience' option type 'a'. In order to choose the 'Phone a Friend' option type 'p'. In order to choose the '50/50' option type 'f'.");
            String id = scanString();
            if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
                // in case the answer introduced is correct
                if (answersList.get(Integer.parseInt(id)-1).isCorrectness() == true) {
                    correctAnswer(gS, question);
                }
                // in case the answer introduced is incorrect
                else {
                    incorrectAnswer(gS);
                }
            } else if (id.equals("a")) {
                askAudience(gS, question, answersList);
            } else if (id.equals("p")) {
                phoneFriend(gS, question, answersList);
            } else if (id.equals("f")) {
                fiftyFifty(gS, question, answersList);
            } else {
                System.out.println("Invalid input.");
                System.exit(0);
            }
        } else {
            System.out.println("Introduce the number of the correct answer: ");
            String id = scanString();
            if (id.equals("1") || id.equals("2") || id.equals("3") || id.equals("4")) {
                // in case the answer introduced is correct
                if (answersList.get(Integer.parseInt(id)-1).isCorrectness() == true) {
                    correctAnswer(gS, question);
                }
                // in case the answer introduced is incorrect
                else {
                    incorrectAnswer(gS);
                }
            } else {
                System.out.println("Invalid input.");
                System.exit(0);
            }
        }

     }

    public static void play(GameSession gS) throws SQLException, InterruptedException {
        gS.setScore(0);
        DatabaseActions.updateScore(gS.getUuid(), gS.getScore());
        for (int i = 0; i<QuestionsBank.questions().size(); i++) {
            int level = i+1;
            Random rand = new Random();
            int r = rand.nextInt(3);
            Question question = QuestionsBank.questions().get(i)[r];
            answerQuestion(gS, question, level);
        }
    }

    public static void main(String[] args) throws SQLException, InterruptedException, InputMismatchException {
        GameSession gS = new GameSession();
        System.out.println("Welcome to the game 'Become a millionaire!'");
        System.out.println("Do you already have an account? [Yes/No]");
        String y_n = scanString();
        if (y_n.equals("Yes")) {
            logIn(gS);
            play(gS);
        } else if (y_n.equals("No")) {
            signUp(gS);
            play(gS);
        } else {
            System.out.println("Invalid input.");
            System.exit(0);
        }
    }
}
