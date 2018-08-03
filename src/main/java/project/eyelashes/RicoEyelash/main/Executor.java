package project.eyelashes.RicoEyelash.main;

import static project.eyelashes.RicoEyelash.main.Constants.*;

import java.util.Scanner;

import project.eyelashes.RicoEyelash.elements.impl.Type1;
import project.eyelashes.RicoEyelash.elements.impl.TypeNull;
import project.eyelashes.RicoEyelash.elements.type.Molgana;

public class Executor {

	//System.inをcloseしないように
	//Scannerクラスを大量に生成しないようにクラスフィールドでスキャナーを作成
	private static final Scanner scanner = new Scanner(System.in);

	public Executor() {
	}

	public static void execute(){
		int mode = 0;

		//あいさつ
		greeting();

		//モード選択
		mode = selectMode();

		//モード実行
		Molgana doll = null;
		if(mode == 1){
			doll = new Type1();
		}else {
			doll = new TypeNull();
		}
		doll.action();
	}

	private static void greeting() {
		String name;
		System.out.println("あなたのお名前は？");
		System.out.print(prompt);
		//名前入力
		name = scanInputStr();
		System.out.println("Hello World! " + name + "!");
	}

	private static int selectMode() {
		int mode = 0;
		String answer;
		boolean loopFlg = true;

		//モード選択
		//モード選択を終えるまで繰り返し
		while(loopFlg){
			System.out.println("モードを選択してください。");
			System.out.print(prompt);
			mode = scanInputNum();
			System.out.println(mode + "モードを選択しました。");
			System.out.println("現在"+ mode + "モードです。");
			System.out.println("モード選択をつづけますか？y/n");
			System.out.print(prompt);
			answer = scanInputStr();
			if("no".equals(answer)||"n".equals(answer)){
				loopFlg = false;
			}
		}
		System.out.println(mode + "モードを開始します。");
		return mode;
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
