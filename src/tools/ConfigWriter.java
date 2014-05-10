package tools;

import java.io.*;

public class ConfigWriter 
{
	private PrintWriter printWrite;
	
	public ConfigWriter(String file) throws FileNotFoundException
	{
		printWrite = new PrintWriter(file);
	}
	
	public void writeLine(String line)
	{
		printWrite.println(line);
	}
	
	public void close()
	{
		printWrite.flush();
		printWrite.close();
	}
}
