package chapter1510;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
	public static void main(String[] args) throws Exception {
		Files.copy(Paths.get("D:\\Workspaces\\fkjava3\\src\\chapter1510\\FilesTest.java"), new FileOutputStream("a.txt"));
		//判断文件是否为影藏文件
		System.out.println(Files.isHidden(Paths.get("D:\\Workspaces\\fkjava3\\src\\chapter1510\\FilesTest.java")));
		List<String> lines=Files.readAllLines(Paths.get("D:\\Workspaces\\fkjava3\\src\\chapter1510\\FilesTest.java"), Charset.forName("gbk"));
		System.out.println(lines);
		System.out.println(Files.size(Paths.get("D:\\Workspaces\\fkjava3\\src\\chapter1510\\FilesTest.java")));
		List<String> poem=new ArrayList<String>();
		poem.add("水晶潭底");
		poem.add("qingfaeng");
		Files.write(Paths.get("pome.txt"), poem, Charset.forName("gbk"));
	}
}
