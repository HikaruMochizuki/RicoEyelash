package project.eyelashes.RicoEyelash;

import static project.eyelashes.RicoEyelash.Constants.*;

import java.util.Scanner;

public class Executor {

	//System.inをcloseしないように
	//Scannerクラスを大量に生成しないように
	private static final Scanner scanner = new Scanner(System.in);

	public Executor() {
	}

	public static void execute(){
		String name = null;
		int mode = 0;
		String answer = null;
		boolean loopFlg = true;

		System.out.println("あなたのお名前は？");
		System.out.print(prompt);
		name = scanInputStr();
		System.out.println("Hello World! " + name + "!");
		while(loopFlg){
			System.out.println("モードを選択してください");
			System.out.print(prompt);
			mode = scanInputNum();
			System.out.println(mode + "モードを選択しました");
			System.out.println("現在"+ mode + "モードです");
			System.out.println("モード選択をつづけますか？y/n");
			System.out.print(prompt);
			answer = scanInputStr();
			if("no".equals(answer)||"n".equals(answer)){
				loopFlg = false;
			}
		}
		System.out.println(mode + "モードを開始します");
	}

	private static int scanInputNum(){
		int inputNum = 0;
		try{
			inputNum = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputNum;
	}

	private static String scanInputStr(){
		String inputStr = null;
		try{
			inputStr = scanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStr;
	}
}
