package P11_DBConnection;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample1 {

    @Test
    public void JDBCConnection() throws SQLException {
        // Configure via environment variables to avoid hard-coding credentials.
        // Defaults shown for convenience — replace with your values or set env vars.
        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/mydb");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String pass = System.getenv().getOrDefault("DB_PASS", "password");

        // Example query — change table/columns to match your schema
        String sql = "SELECT id, name FROM users LIMIT 10";

        // Optional: explicitly load driver (usually not required with modern JDBC drivers on the classpath)
        // try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException ignored) {}

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.printf("id=%d, name=%s%n", id, name);
            }

        } catch (SQLException e) {
            // In tests you might want to fail the test instead of swallowing the exception.
            e.printStackTrace();
            throw e;
        }
    }
}
