package game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseActions {
    // establish connection to database
    public static Connection getConnection() {
        String url = "jdbc:sqlite:game.sqlite";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("An error occurred while connecting to database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // update the score of player in the corresponding game session
    public static void updateScore(String recordID, int score) throws SQLException {
        String sql = "UPDATE record SET score=? WHERE id=?";
        try (Connection conn = DatabaseActions.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, score);
            pstmt.setString(2, recordID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // create a new player account
    public static void createPlayer(String id, String username) {
        String sql = "INSERT INTO player(id, username) VALUES(?, ?)";
        try (Connection conn = DatabaseActions.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            Statement stmt = conn.createStatement();
            pstmt.setString(1, id);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // check if player with a particular username can be found in the database
    public static int checkPresence(String username) throws SQLException {
        Connection conn = DatabaseActions.getConnection();
        String sql = "SELECT id FROM player WHERE username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet res = pstmt.executeQuery();
        boolean presence = res.next();
        if(presence == true) {
            pstmt.close();
            conn.close();
            return 1;
        } else {
            pstmt.close();
            conn.close();
            return 0;
        }
    }

    // create a new game session record
    public static void createRecord(String recordID, String playerID, long timestamp) {
        String sql = "INSERT INTO record(id, player_id, score, timestamp) VALUES(?, ?, ?, ?)";
        try (Connection conn = DatabaseActions.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, recordID);
            pstmt.setString(2, playerID);
            pstmt.setInt(3, 0);
            pstmt.setLong(4, timestamp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPlayerID(String username) throws SQLException {
        Connection conn = DatabaseActions.getConnection();
        String sql = "SELECT id FROM player WHERE username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        ResultSet res = pstmt.executeQuery();
        String id = res.getString(1);
        pstmt.close();
        conn.close();
        return id;
    }
}
