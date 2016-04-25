//deals with all aspects of the file
package framework;
import java.io.*;
import java.util.Scanner;

public class FileHandler{
	private static FileWriter writer;
	private Scanner scanner;
	public FileHandler(String name){
		try{
			File file = new File(name);
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new FileWriter(file);
			scanner = new Scanner(new BufferedReader(new FileReader(name)));
			
		}
		catch(Exception e){	
			System.out.println(e);
		}
	}
	public void writeToFile(String input){
		try{
			writer.write(input);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public int readFromFile(){
		try{
			if (scanner.hasNextInt())
				return scanner.nextInt();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return -1;
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
