package examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	public boolean readFile(StringBuffer buffer, String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileReader fileReader = new FileReader(path);
			BufferedReader br = new BufferedReader(fileReader);
			String temp = br.readLine();
			while (temp != null) {
				buffer.append(temp);
				buffer.append("\n");
				temp = br.readLine();
			}
			br.close();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean writeFile(String str, String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write(str);
			bw.close();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean clearFile(String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public static void main(String[] args) {
		FileUtil f = new FileUtil();
		StringBuffer buffer = new StringBuffer();
		String path = "/Users/wanglei/Documents/eclipse/workspace/Compiler/files/input.txt";

		if (f.readFile(buffer, path))
			System.out.println(buffer.toString());
	}
}
