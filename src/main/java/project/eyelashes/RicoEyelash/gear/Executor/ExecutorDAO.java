package project.eyelashes.RicoEyelash.gear.Executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.eyelashes.RicoEyelash.gear.common.Common;

public class ExecutorDAO {

	public ExecutorDAO() {
	}

	public boolean isExistingUser(String inName){
		System.out.println("データベースと照合します...");

		boolean existingFlg = false;

		String sql = getSQL();

		try(Connection con = Common.getDbConnection();
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

	private String getSQL(){
		String sql = "SELECT USER_NAME FROM MST_USER WHERE USER_NAME = ?";
		return sql;
	}
}
