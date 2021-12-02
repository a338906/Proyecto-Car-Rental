package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }

    public void connectToDatabase() throws SQLException {
        String server = "SERVER";
        String port = "PORT";
        String service = "SERVICE";
        String userName = "USERNAME";
        String password = "PASSWORD";
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());         
        connection = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@//" 
            + server + ":" + port + "/" + service, userName, password);   
    }
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
