package project.eyelashes.RicoEyelash.actor;

import static project.eyelashes.RicoEyelash.gear.common.Common.*;
import static project.eyelashes.RicoEyelash.gear.common.Constants.*;

import java.io.File;

import project.eyelashes.RicoEyelash.gear.mode1.Mode1DAO;

public class Mode1FileReader extends Actor {

	public Mode1FileReader() {
		super("Mode1");
	}

	@Override
	public void action() {
		String pathstr;

		System.out.println("ファイルからデータを読み込みます。");
		System.out.println("読み込むファイルを指定してください。");
		System.out.print(prompt);

		//Fileオブジェクト作成
		pathstr = scanInputStr();
		File file = new File(pathstr);
		System.out.println(file.getAbsolutePath() + "からデータを読み込みます。");
		lineSeparator();

		Mode1DAO dao = new Mode1DAO();

		// キャラクタストリームで読み込み
		System.out.println("文字列（SJIS）で読み込みます。");
		dao.readChar(file);
		lineSeparator();

		// バイトストリームで読み込み
		System.out.println("バイトデータで読み込みます。");
		dao.readByte(file);
	}
}
