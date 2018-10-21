package lab9;

import java.io.File;

public class ListFiles {
	public static void main(String args[]){
		File rootDirectory = new File(".");
		long result = countFiles(rootDirectory);
		System.out.println(result);
	}

	public static int countFiles(File f){
		if(!f.isDirectory()){
			return 1;
		}else{		
			File[] files = f.listFiles();
			int count = 0;
			for(int i =0; i <files.length;i++){
				countFiles(files[i]);
				count = count + countFiles(files[i]);
			}
			return count;
		}
		
	}
}
