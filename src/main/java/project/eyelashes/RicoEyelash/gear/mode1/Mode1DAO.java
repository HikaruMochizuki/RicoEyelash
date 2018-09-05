package project.eyelashes.RicoEyelash.gear.mode1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mode1DAO {

	public Mode1DAO() {
	}

	public void readChar(File file) {
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

	public void readByte(File file) {
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
