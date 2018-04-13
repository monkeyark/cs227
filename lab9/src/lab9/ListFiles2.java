package lab9;

import java.io.File;
import java.util.ArrayList;

public class ListFiles2 {
	public static void main(String[] args){		
		ArrayList<File> files = new ArrayList<File>();
		ArrayList<File> directory = new ArrayList<File>();
		
		File rootDirectory = new File(".");		
		if(!rootDirectory.isDirectory()){
				//System.out.println(rootDirectory.getName());
			files.add(rootDirectory);
		}else{
			directory.add(rootDirectory);
		}
				
		while(directory.size()>0){
			for(int i=0; i < directory.size();i++){
				File[] subfile = directory.get(i).listFiles();
					for(int j=0; j< subfile.length;j++){
						if(!subfile[j].isDirectory()){
							files.add(subfile[j]);
						}else{
							directory.add(subfile[j]);
						}
					}
					directory.remove(i);	
				}
			}	
			
		for(int i=0; i < files.size();i++){
			System.out.println(files.get(i).getName());
		}
	}
}
