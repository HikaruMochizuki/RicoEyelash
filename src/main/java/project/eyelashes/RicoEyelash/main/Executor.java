package project.eyelashes.RicoEyelash.main;

import static project.eyelashes.RicoEyelash.gear.common.Common.*;
import static project.eyelashes.RicoEyelash.gear.common.Constants.*;

import project.eyelashes.RicoEyelash.actor.Actor;
import project.eyelashes.RicoEyelash.actor.Mode1FileReader;
import project.eyelashes.RicoEyelash.actor.Mode2DirectorySearcher;
import project.eyelashes.RicoEyelash.actor.Mode3UserController;
import project.eyelashes.RicoEyelash.actor.Mode4HTTPConnection;
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
			//ログインフェーズ
			if(loginUser.getStartPhase() <= START_PHASE_LOGIN){
				//ユーザ判定
				userCheck = userCheck();
				lineSeparator();
			}

			//モード選択/実行フェーズ
			//ユーザ判定OKの場合のみ遷移
			if(userCheck){
				//モード選択フェーズ
				if(loginUser.getStartPhase() <= START_PHASE_MODE_SELECT){
					mode = selectMode();
					lineSeparator();
				}

				//モード実行フェーズ
				if(loginUser.getStartPhase() <= START_PHASE_EXECUTE_MODE){
					mode.action();
				}
				lineSeparator();
			}

			//コンテニューフェーズ
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
		//初期化
		int mode = 0;
		String answer;
		boolean loopFlg = true;
		Actor modeObj = new ModeNull();

		//全モードインスタンス生成
		Actor mode1 = new Mode1FileReader();
		Actor mode2 = new Mode2DirectorySearcher();
		Actor mode3 = new Mode3UserController();
		Actor mode4 = new Mode4HTTPConnection();

		//モード選択
		//モード選択を終えるまで繰り返す
		while(loopFlg){
			//モード選択画面表示
			System.out.println("モードを選択してください。");
			System.out.println("1：" + mode1.getName());
			System.out.println("2：" + mode2.getName());
			System.out.println("3:" + mode3.getName());
			System.out.println("4:" + mode4.getName());
			System.out.print(prompt);
			mode = scanInputNum();

			//選択に応じてモードを実装
			if(mode == 1){
				modeObj = mode1;
			}else if (mode == 2){
				modeObj = mode2;
			}else if (mode == 3) {
				modeObj = mode3;
			}else if (mode == 4) {
				modeObj = mode4;
			}

			//確認画面表示
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
