package project.eyelashes.RicoEyelash.actor;

import static project.eyelashes.RicoEyelash.common.Common.*;
import static project.eyelashes.RicoEyelash.common.Constants.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mode1 extends Actor {

	public Mode1() {
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

		// キャラクタストリームで読み込み
		System.out.println("文字列（SJIS）で読み込みます。");
		readChar(file);
		lineSeparator();

		// バイトストリームで読み込み
		System.out.println("バイトデータで読み込みます。");
		readByte(file);
	}

	private void readChar(File file) {
		try (FileInputStream fi = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fi, "SJIS");
				BufferedReader br = new BufferedReader(isr)) {

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readByte(File file) {
		try (FileInputStream fi = new FileInputStream(file)) {

			int data = 0;
			while ((data = fi.read()) != -1) {
				System.out.print(data + " ");
			}
			System.out.println("");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
