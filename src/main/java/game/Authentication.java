package game;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class Authentication {
    public void handleInvalidUsername(GameSession gS) throws SQLException {
        StringScanner scanner = new StringScanner();
        String answer = scanner.scanString();
        // try to log in once again
        if ("Try again".equals(answer)) {
            System.out.println("Introduce your username: ");
            logIn(gS);
        }
        // switch to the signup procedure
        else if ("Sign up".equals(answer)) {
            System.out.println("Please create an account by introducing your username: ");
            signUp(gS);
        } else {
            System.out.println("Invalid input. Try again or create a new account instead? [Try again/Sign up]");
            handleInvalidUsername(gS);
        }
    }

    // method to log the user in
    public void logIn(GameSession gS) throws SQLException, InputMismatchException {
        StringScanner scanner = new StringScanner();
        String username = scanner.scanString();
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
            handleInvalidUsername(gS);
        }
    }

    // method to create a new account
    public void signUp(GameSession gS) throws SQLException, InputMismatchException {
        // create a new account given the new player's username
        StringScanner scanner = new StringScanner();
        String username = scanner.scanString();
        if (DatabaseActions.checkPresence(username) == 1) {
            System.out.println("A user with such a username already exists. Try another username: ");
            signUp(gS);
        } else {
            long timestamp = System.currentTimeMillis();
            Player player = new Player(username);
            DatabaseActions.createPlayer(player.getUuid(), username);
            gS.setUsername(username);
            DatabaseActions.createRecord(gS.getUuid(), player.getUuid(), timestamp);
            System.out.println("Sign up successful");
        }
    }
}
