package project.eyelashes.RicoEyelash.main;

import static project.eyelashes.RicoEyelash.gear.common.Common.*;
import static project.eyelashes.RicoEyelash.gear.common.Constants.*;

import project.eyelashes.RicoEyelash.actor.Actor;
import project.eyelashes.RicoEyelash.actor.Mode1FileReader;
import project.eyelashes.RicoEyelash.actor.Mode2DirectorySearcher;
import project.eyelashes.RicoEyelash.actor.Mode3UserController;
import project.eyelashes.RicoEyelash.actor.ModeNull;
import project.eyelashes.RicoEyelash.gear.Executor.ExecutorDAO;

/**
 *
 * @author Amami
 *
 */
public class Executor {

	public Executor() {
	}

	/**
	 * 基本処理フロー
	 */
	public static void execute(){
		//初期化
		boolean continueFlg = true;
		Actor mode = new ModeNull();
		boolean userCheck =false;
		LoginUser loginUser = new LoginUser(START_PHASE_LOGIN);

		//コンテニューされる限り繰り返し
		while(continueFlg){
			//ユーザ判定
			if(loginUser.getStartPhase() <= START_PHASE_LOGIN){
				userCheck = userCheck();
				lineSeparator();
			}

			//ユーザ判定OKの場合
			if(userCheck){
				//モード選択
				if(loginUser.getStartPhase() <= START_PHASE_MODE_SELECT){
					mode = selectMode();
					lineSeparator();
				}

				//モード実行
				if(loginUser.getStartPhase() <= START_PHASE_EXECUTE_MODE){
					mode.action();
				}
				lineSeparator();
			}

			//コンテニュー判定
			continueFlg = checkContinue();
			//どこからはじめるか選択
			if(continueFlg){
				choiceStartPhase(loginUser);
			}
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
		checkresult = new ExecutorDAO().isExistingUser(name);
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
		Actor modeObj = new ModeNull();
		//モード選択を終えるまで繰り返す
		while(loopFlg){
			System.out.println("モードを選択してください。");
			System.out.println("1：" + new Mode1FileReader().getName());
			System.out.println("2：" + new Mode2DirectorySearcher().getName());
			System.out.println("3:" + new Mode3UserController().getName());
			System.out.print(prompt);
			mode = scanInputNum();

			//選択に応じてモードを実装
			if(mode == 1){
				modeObj = new Mode1FileReader();
			}else if (mode == 2){
				modeObj = new Mode2DirectorySearcher();
			}else if (mode == 3) {
				modeObj = new Mode3UserController();
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

	private static boolean checkContinue(){
		boolean continueFlg;
		String answer;
		System.out.println("続けますか？");
		System.out.print(prompt);
		answer = scanInputStr();
		if("yes".equals(answer)||"y".equals(answer)){
			continueFlg = true;
		}else{
			continueFlg = false;
		}
		return continueFlg;
	}

	private static void choiceStartPhase(LoginUser loginUser){
		System.out.println("どこからはじめますか？");
		System.out.println("ログイン：0");
		System.out.println("モード選択：1");
		System.out.println("モード実行：2");
		System.out.print(prompt);
		int answer = scanInputNum();
		loginUser.setStartPhase(answer);
	}

}
