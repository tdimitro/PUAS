package transport;

import javax.swing.*;
import java.sql.*;

public class sqliteConnection {
	Connection conn=null;
	public static Connection dbConnector()
	{
		try {
				Class.forName("com.mysql.jdbc.Driver");
				String host="jdbc:mysql://78.46.89.150/user2964783641_mixTasos";
				String username ="user2_mixTasos";
				String password="Tas2017!";
				Connection conn =DriverManager.getConnection(host, username, password);
				JOptionPane.showMessageDialog(null,"Connection Successfull"); 
				return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"fail Connection");
				return null;
		}
	}
}
 