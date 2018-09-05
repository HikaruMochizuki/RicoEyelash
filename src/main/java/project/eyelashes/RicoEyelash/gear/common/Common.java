package project.eyelashes.RicoEyelash.gear.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public final class Common {

	//System.inをcloseしないように
	//Scannerクラスを大量に生成しないようにクラスフィールドでスキャナーを作成
	private static final Scanner scanner = new Scanner(System.in);

	public static int scanInputNum(){
		int inputNum = 0;
		try{
			inputNum = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputNum;
	}

	public static String scanInputStr(){
		String inputStr = null;
		try{
			inputStr = scanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStr;
	}

	public static void lineSeparator(){
		System.out.println("================================");
	}

	public static Connection getDbConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@192.168.2.110:1521:db01";
		String schema = "RICO_EYELASH";
		String password = "rico_eyelash";
		Connection con = DriverManager.getConnection(url, schema, password);
		return con;
	}
}
