package project.eyelashes.RicoEyelash.actor;

import static project.eyelashes.RicoEyelash.gear.common.Common.*;
import static project.eyelashes.RicoEyelash.gear.common.Constants.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import project.eyelashes.RicoEyelash.gear.mode2.Mode2FileVisitor;

public class Mode2DirectorySearcher extends Actor {

	public Mode2DirectorySearcher() {
		super("ディレクトリ探索");
	}

	@Override
	public void action() {
		System.out.println("探索フォルダを指定してください。");
		System.out.print(prompt);
		String path = scanInputStr();
		Path searchRoot = Paths.get(path);

		try {
			Files.walkFileTree(searchRoot, new Mode2FileVisitor());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
