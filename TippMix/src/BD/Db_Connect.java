
package BD;

import moduls.Player;
import java.sql.*;
import java.util.ArrayList;

public class Db_Connect {


    private Connection conn;
    
    
    

    private static ArrayList<Player> player = new ArrayList<>();
    private String url = "jdbc:mysql://localhost/tippmix";


    private String user = "root";
    private String password = "";

    private static Db_Connect inc = null;
    
    public static Db_Connect getInc(){
        
        if(inc == null){
            inc = new Db_Connect();
        }
        
        return inc;
    }
    
    private Db_Connect() {

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


    public ArrayList<Player> getPlayer() throws SQLException{
        Connection conn = getConnection();
        ArrayList<Player> pl = new ArrayList<>();
        String storedProcedureCall = "{call getPlayer()}";
            CallableStatement callableStatement = conn.prepareCall(storedProcedureCall);
            //callableStatement.setInt(1, 123); // beállítjuk az első paraméter értékét
            //callableStatement.setString(2, "John"); // beállítjuk a második paraméter értékét
            //callableStatement.setDouble(3, 45.67); // beállítjuk a harmadik paraméter értékét
            callableStatement.execute();
            ResultSet resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int power = resultSet.getInt("power");
                Integer TeamID = null;
                String ID = resultSet.getString("TeamID");
                if(ID==null){
                    TeamID = null;
                }else{
                    try{
                    TeamID = Integer.parseInt(ID);
                    }catch(Exception ex){
                        System.err.println("hiba");
                    }finally{
                        TeamID = null;
                    }
                }
                //Integer TeamID = Integer.parseInt(resultSet.getString("TeamID"));
                
                // eredmény feldolgozása
                Player p = new Player(name,power,TeamID);
                pl.add(p);
            }

            // Objektumok bezárása
            resultSet.close();
            callableStatement.close();
            closeConnection(conn);
        return pl;
    }
    public void closeConnection(Connection conn) {
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