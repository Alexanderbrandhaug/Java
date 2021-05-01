package project_reservation;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class MySQLconnect {
	Reservation reservation;
	
	static Connection connection = null;
	static String databaseName = "";
	static String url = "jdbc:mysql://eu-cdbr-west-01.cleardb.com:3306/heroku_";
	
	static String username = "";
	static String password ="";
	
	
	public static Connection DBconnect() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	connection = DriverManager.getConnection(url, username, password);
	return connection;
	}
	
	
	
	public static String deleteFrom(int id) {
		
		String sql1 = "DELETE FROM booking WHERE bookingID = " + String.valueOf(id);
		System.out.println("Successfully deleted booking");
		return sql1;
		
	}
	public static ObservableList<Reservation> getBookings() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException{
		
		Connection conn = DBconnect();
		ObservableList<Reservation> list = FXCollections.observableArrayList();
		PreparedStatement ps = conn.prepareStatement("select * from booking");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new Reservation(rs.getInt("bookingID"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getDate("fromDate").toLocalDate(), rs.getDate("toDate").toLocalDate(), rs.getInt("price")));
		}
		
		return list;
		
	}
	
	public static String userAccount(String username, String password) {
		String sqlUser = "SELECT * FROM * users WHERE username && password = " + username + password;
		return sqlUser;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		

			
		}

		
	}

