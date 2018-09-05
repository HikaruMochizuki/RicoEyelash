package project.eyelashes.RicoEyelash.gear.Executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecutorDAO {

	public ExecutorDAO() {
	}

	public boolean isExistingUser(String inName){
		System.out.println("データベースと照合します...");

		boolean existingFlg = false;

		String sql = getSQL();

		try(Connection con = getDbConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, inName);

			//入力と同じ名前のユーザをマスタから取得
			//PreparedStatementがcloseされたときResultSetもcloseされるらしい...
			//ので、try-with-resourcesで囲まなくてもよい
			ResultSet rs = stmt.executeQuery();

			//同じ名前のユーザが一人でもいればOK
			if(rs.next()){
				existingFlg = true;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return existingFlg;
	}

	private Connection getDbConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@192.168.2.110:1521:db01";
		String schema = "RICO_EYELASH";
		String password = "rico_eyelash";
		Connection con = DriverManager.getConnection(url, schema, password);
		return con;
	}

	private String getSQL(){
		String sql = "SELECT USER_NAME FROM MST_USER WHERE USER_NAME = ?";
		return sql;
	}
}
