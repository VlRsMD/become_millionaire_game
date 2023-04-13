package game;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws SQLException, InputMismatchException, IOException {
        Game game = new Game();
        GameSession gS = new GameSession();
        System.out.println("Welcome to the game 'Become a millionaire!'");
        System.out.println("Do you already have an account? [Yes/No]");
        game.startGame(gS);
    }
}
