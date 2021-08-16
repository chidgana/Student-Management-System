package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by chidgana on 02-Dec-17.
 */
public class DBHandler {
    protected Connection dbconnection;

    public Connection getConnection() {

        try {
//           Class.forName("org.sqlite.JDBC");
            dbconnection = DriverManager.getConnection("jdbc:sqlite:src\\Database\\data.db");
            if (dbconnection == null) {
                System.out.println("connection failed to the database");
            } else {
                System.out.println("connection Successful to the database");
            }

//        } catch (ClassNotFoundException e) {
//            System.err.println(e.getMessage());
        } catch (SQLException z) {
            System.err.println(z.getMessage());
        }
        return dbconnection;
    }
}
