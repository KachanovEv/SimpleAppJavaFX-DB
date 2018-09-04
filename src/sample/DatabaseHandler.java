package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void singUpUser(String firstname, String lastname, String username, String password, String location, String gender) {

        String insert = "INSERT INTO" + Const.USER_TABlE + "(" + Const.USER_FIRSTNAME + "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + ","
                + Const.USER_PASSWORD + "," + Const.USER_LOCATION + "," + Const.USERS_GENDER + ")"
                + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, firstname);
            prSt.setString(2, lastname);
            prSt.setString(3, username);
            prSt.setString(4, password);
            prSt.setString(5, location);
            prSt.setString(6, gender);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

