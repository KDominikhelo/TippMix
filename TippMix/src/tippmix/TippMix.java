
package tippmix;

import BD.Db_Connect;
import java.sql.SQLException;
import java.util.ArrayList;
import moduls.Player;


public class TippMix {

    public static void main(String[] args) throws SQLException {
          // System.out.println(Db_Connect.getInc().getConnection());
          
          ArrayList<Player> pl = Db_Connect.getInc().getPlayer();
          for (Player player : pl) {
              System.out.println(player.name);
        }
          
    }
    
}
