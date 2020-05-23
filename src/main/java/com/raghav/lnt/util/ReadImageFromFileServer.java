package com.raghav.lnt.util;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class ReadImageFromFileServer {
	private static String UPLOAD_DIR = System.getProperty("user.home") + "\\" + "postSaleimages";
	public static void loadImagePath(String imageName) {

		File file = new File(UPLOAD_DIR +"\\"+ imageName);
		DataInputStream dis = null;
		try {
			// Reading a Image file from file system
			FileInputStream imageInFile = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(imageInFile);
	           dis = new DataInputStream(bis);
			
	           byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			imageInFile.close();
			System.out.println("Image Successfully Manipulated!");
		}

		catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		 finally {
	           // if the file opened okay, make sure we close it
	           if (dis != null) {
	              try {
	                 dis.close();
	              } catch (IOException ioe) {
	              }
	           }
	        }
	}
}
