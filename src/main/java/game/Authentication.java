package game;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class Authentication {
    // method to log the user in
    public static void logIn(GameSession gS) throws SQLException, InputMismatchException {
        System.out.println("Introduce your username: ");
        String username = Scan.scanString();
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
            String answer = Scan.scanString();
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
        String username = Scan.scanString();
        long timestamp = System.currentTimeMillis();
        Player player = new Player(username);
        DatabaseActions.createPlayer(player.getUuid(), username);
        gS.setUsername(username);
        DatabaseActions.createRecord(gS.getUuid(), player.getUuid(), timestamp);
        System.out.println("Sign up successful");
    }
}
