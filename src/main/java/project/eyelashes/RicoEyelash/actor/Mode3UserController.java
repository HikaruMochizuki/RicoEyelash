package project.eyelashes.RicoEyelash.actor;

import static project.eyelashes.RicoEyelash.gear.common.Common.*;
import static project.eyelashes.RicoEyelash.gear.common.Constants.*;

import project.eyelashes.RicoEyelash.gear.mode3.Mode3DAO;
public class Mode3UserController extends Actor {

	public Mode3UserController() {
		super("ユーザ操作");
	}

	@Override
	public void action() {

		System.out.println("ログインユーザを登録します。");
		System.out.println("登録するユーザ名を入力してください。");
		System.out.print(prompt);
		String insertName = scanInputStr();

		new Mode3DAO().AddUser(insertName);

	}

}
