//deals with all aspects of the file
package framework;
import java.io.*;

public class FileHandler{
	private static FileWriter writer;
	private final static String newline = "\n";
	public FileHandler(String name){
		try{
			File file = new File(name);
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new FileWriter(file);
		}
		catch(Exception e){	
			System.out.println(e);
		}
	}
	public void writeToFile(String input){
		try{
			writer.write(input + newline);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void close(){
		try{
			writer.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
