package Account;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
	private Connection con;

	public Account(Connection con) {
		this.con = con;
	}
	
	public boolean login(String email, String passwd) throws SQLException{
		int count=0;
		String sql = "select count(*) as count from users where username=? AND password=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,email);
		pstmt.setString(2,passwd);
		
		ResultSet rst = pstmt.executeQuery();
		
		if(rst.next()){
			count=rst.getInt("count");
		}
		
		rst.close();
		
		if(count == 0){
			return false;
		}
		else{
	return true;
		}
}
	public void insert(String name,String email, String passwd) throws SQLException{
		String sql = "insert into users(name,username,password) values (?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2,email);
		pstmt.setString(3,passwd);
		pstmt.executeUpdate();
		pstmt.close();
	}
}