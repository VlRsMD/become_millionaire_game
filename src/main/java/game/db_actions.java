package game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class db_actions {
    public static Connection connect() {
        String url = "jdbc:sqlite:identifier.sqlite";
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

    public static void insert(String username, int score) {
        String sql = "UPDATE player SET score=? WHERE username=?";
        try (Connection conn = db_actions.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, score);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void create_player(String username) {
        String sql = "INSERT INTO player(id, username, score) VALUES(?, ?, ?)";
        try (Connection conn = db_actions.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM player");
            rs.next();
            int id = rs.getInt("count(*)")+1;
            int score = 0;
            pstmt.setInt(1, id);
            pstmt.setString(2, username);
            pstmt.setInt(3, score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int check_if_present(String username) throws SQLException {
        Connection conn = db_actions.connect();
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM player");
        ResultSetMetaData rsmd = res.getMetaData();
        int col_c = rsmd.getColumnCount();
        List<String> list = new ArrayList<String>();
        while(res.next()) {
            for (int i = 1; i<=col_c; i++) {
                list.add(res.getString(i));
            }
        }
        if (list.contains(username)) {
            return 1;
        } else return 0;
    }
}
