package project.eyelashes.RicoEyelash.gear.mode2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
		System.out.println("ディレクトリ" + dir + "にアクセスします。");
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
		System.out.println("ファイル" + file + "にアクセスします。");
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException{
		System.out.println("ファイル" + file + "へのアクセスに失敗しました。");
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException{
		System.out.println("ディレクトリ" + dir + "の探索が完了しました");
		return FileVisitResult.CONTINUE;
	}

}
