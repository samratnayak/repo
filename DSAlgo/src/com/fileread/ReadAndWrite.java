package com.fileread;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWrite {

	public static void main(String[] args) throws IOException {
		String textInputFile = "C:\\Users\\samrnaya\\Desktop\\code_links.txt";
		String textoutputFile = "C:\\Users\\samrnaya\\Desktop\\code_links_copied.txt";

		String jpgInputFile = "C:\\Users\\samrnaya\\Desktop\\enrollment_samrat.JPG";
		String jpgOutputFile = "C:\\Users\\samrnaya\\Desktop\\enrollment_samrat_copied.JPG";

		copyFileBuffered(jpgInputFile, jpgOutputFile);

		System.out.println("done!!!");
	}

	private static void copyFile(String fileStr, String opFileStr) throws IOException {
		File file = new File(fileStr);
		File opFile = new File(opFileStr);
		try (FileInputStream fi = new FileInputStream(file); FileOutputStream fo = new FileOutputStream(opFile)) {
			byte[] b = new byte[1024];
			while (fi.read(b) != -1) {
				fo.write(b);
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		}
	}

	private static void copyFileBuffered(String fileStr, String opFileStr) throws IOException {
		File file = new File(fileStr);
		File opFile = new File(opFileStr);
		try (BufferedInputStream bi = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(opFile))) {
			byte[] b = new byte[1024];
			while (bi.read(b) != -1) {
				bo.write(b);
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		}
	}

}
