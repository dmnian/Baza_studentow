package gui;
import java.io.File;

import javax.swing.filechooser.FileFilter;

public class StudentFileFilter extends FileFilter {

	@Override
	public boolean accept(File file) {

		String name = file.getName();
		String extension = Utils.getFileExtension(name);
		
		if(file.isDirectory()){
			return true;
		}
		
		if(extension == null){
			return false;
		}
		
		if(extension.equals("student")){ //Określam rozszerzenie ktore ma być widoczne
			return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Pliki Bazy Danych Studentów (*.student)";
	}

}
