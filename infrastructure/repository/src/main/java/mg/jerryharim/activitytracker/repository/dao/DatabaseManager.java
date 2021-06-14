package mg.jerryharim.activitytracker.cli.repository.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gere la connection a la base de donnee. 
 * La connection a la base est initialiser au moment de 
 * l'appelle de son constructeur a travers la fonction getInstance()
 */
public class DatabaseManager {

    private static DatabaseManager databaseManager;
    private Connection connection;
    private final static String SBGD = "h2";
    private final static String HOST = "";
    private final static String PORT = "";
    private final static String DATABASE = "./databaseh2/test1";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "password";

    private DatabaseManager(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseManager getInstance() {
        if (databaseManager == null) {
            String url = String.format("jdbc:%s:%s", SBGD,DATABASE);
            databaseManager = new DatabaseManager(
                url,
                USERNAME,
                PASSWORD 
            );
        }
        return databaseManager;
    }
}
