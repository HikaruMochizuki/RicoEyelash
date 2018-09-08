package project.eyelashes.RicoEyelash.actor;

import static project.eyelashes.RicoEyelash.gear.common.Common.*;
import static project.eyelashes.RicoEyelash.gear.common.Constants.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Mode4HTTPConnection extends Actor {

	public Mode4HTTPConnection() {
		super("HTTP通信");
	}

	@Override
	public void action() {
		System.out.println("HTTP通信を行います。");
		System.out.println("URLを指定してください。");
		System.out.print(prompt);
		String strUrl = scanInputStr();
		HttpURLConnection urlConn = null;
		InputStream in = null;
		BufferedReader reader = null;

		try {
			System.out.println("URL:" + strUrl);
			//接続するURLを指定する。
			URL url = new URL(strUrl);

			//コネクションを取得する。
			urlConn	= (HttpURLConnection)url.openConnection();

			urlConn.setRequestMethod("GET");

			urlConn.connect();

			int status = urlConn.getResponseCode();

			System.out.println("HTTPステータス：" + status);

			if (status == HttpURLConnection.HTTP_OK) {

				in = urlConn.getInputStream();

				reader = new BufferedReader(new InputStreamReader(in, "SJIS"));

				StringBuilder output = new StringBuilder();
				String line;

				while ((line = reader.readLine()) != null) {
					output.append(line);
					System.out.println(line);
				}
				System.out.println(output.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}

				if (urlConn != null) {
					urlConn.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
