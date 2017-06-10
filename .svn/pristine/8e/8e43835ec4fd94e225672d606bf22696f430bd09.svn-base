package ProjectUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangingDB {
	public static void DeleteGoods(Connection con,String tableName,String Id) throws SQLException{
		Statement stctc = con.createStatement();
		stctc.executeUpdate("DELETE FROM "+tableName+" WHERE Id = "+Id);
	}
	
}
