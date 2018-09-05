package project.eyelashes.RicoEyelash.gear.mode3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.eyelashes.RicoEyelash.gear.common.Common;

public class Mode3DAO {

	public Mode3DAO() {
	}

	public void AddUser(String insertName) {

		String sql = getSQL();

		try (Connection con = Common.getDbConnection();
			 PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, insertName);

			// ユーザ登録
			int result = stmt.executeUpdate();

			if (result >= 1) {
				System.out.println("新しいユーザが登録されました。");
			} else {
				System.out.println("ユーザが登録されませんでした。");
			}

		} catch (SQLException e) {
			System.out.println("ユーザ登録に失敗しました。");
			e.printStackTrace();
		}
	}

	private String getSQL(){
		String sql = "INSERT INTO MST_USER VALUES(SEQUENCE_USER_ID.NEXTVAL, ?)";
		return sql;
	}
}
