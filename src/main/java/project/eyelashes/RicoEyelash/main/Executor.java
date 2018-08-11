package project.eyelashes.RicoEyelash.main;

import static project.eyelashes.RicoEyelash.common.Common.*;
import static project.eyelashes.RicoEyelash.common.Constants.*;

import project.eyelashes.RicoEyelash.actor.Actor;
import project.eyelashes.RicoEyelash.actor.Mode1;
import project.eyelashes.RicoEyelash.actor.ModeNull;
import project.eyelashes.RicoEyelash.dao.DataAccessor;

public class Executor {

	public Executor() {
	}

	public static void execute(){
		//ユーザ判定
		boolean userCheck = userCheck();
		lineSeparator();

		//ユーザ判定OKの場合
		if(userCheck){
			//モード選択
			Actor mode = selectMode();
			lineSeparator();

			//モード実行
			mode.action();
			lineSeparator();
		}
		//終了
		System.out.println("終了します。");
	}

	private static boolean userCheck() {
		boolean checkresult = false;
		String name;
		System.out.println("あなたのお名前は？");
		System.out.print(prompt);
		//名前入力
		name = scanInputStr();

		//ユーザの存在チェック
		checkresult = new DataAccessor().isExistingUser(name);

		if(checkresult){
			System.out.println("こんにちは、 " + name + "!");
		}else{
			System.out.println("登録されたユーザではありません。");
		}
		return checkresult;
	}

	private static Actor selectMode() {
		int mode = 0;
		String answer;
		boolean loopFlg = true;

		//モード選択
		//モード選択を終えるまで繰り返し
		Actor modeObj = null;
		while(loopFlg){
			System.out.println("モードを選択してください。");
			System.out.println("1：Mode1");
			System.out.print(prompt);
			mode = scanInputNum();
			//選択に応じてモードを実装
			if(mode == 1){
				modeObj = new Mode1();
			}else{
				modeObj = new ModeNull();
			}
			System.out.println(modeObj.getName() + "を実行しますか？y/n");
			System.out.print(prompt);
			answer = scanInputStr();
			if("yes".equals(answer)||"y".equals(answer)){
				loopFlg = false;
			}
		}
		System.out.println(modeObj.getName() + "を開始します。");
		return modeObj;
	}
}
