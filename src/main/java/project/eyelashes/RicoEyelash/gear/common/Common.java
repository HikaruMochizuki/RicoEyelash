package project.eyelashes.RicoEyelash.gear.common;

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
}
