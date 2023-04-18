package com.mycompany.mitpmaven.utils;

import java.io.File;

public class FileUtils {

	public static File getFile(FileLocator fileLocator) {
		try {
			return new File(FileUtils.class.getClassLoader().getResource(fileLocator.getFileLocation()).getFile());
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
		return null;
	}
}
