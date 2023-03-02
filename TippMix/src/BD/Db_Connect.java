
package BD;

import java.sql.*;

public class Db_Connect {


    private Connection conn;


    private String url = "jdbc:mysql://localhost/tippmix";


    private String user = "root";
    private String password = "";

    public Db_Connect() {

        try {

            Class.forName("com.mysql.jdbc.Driver");


            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Az adatbázis csatlakozás sikeres.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Az adatbázis kapcsolat sikeresen lezárult.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        return conn;
    }
}