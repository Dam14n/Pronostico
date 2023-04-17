package com.mycompany.mitpmaven.utils;

import com.mycompany.mitpmaven.lists.ListaEquipos;
import java.io.File;

public class FileUtils {

	public static File getFile(ListaEquipos listaequipos) {
		try {
			return new File(FileUtils.class.getClassLoader().getResource(listaequipos.getEquiposCSV()).getFile());
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
		return null;
	}
}
