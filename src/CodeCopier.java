import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CodeCopier
{
	private TstlLogger ccLog;
	private Logger log;
	public CodeCopier()
	{
		log = Logger.getLogger(this.getClass().getName());
	}
	private void copyJarClass(String className) throws IOException
	{
		ArrayList<String> lines = new ArrayList<String>();
		InputStream stream = this.getClass().getResourceAsStream("res/" + className + ".nocompile");
		if(stream == null)
		{
			stream = this.getClass().getResourceAsStream("res/" + className);
		}
		if(stream == null)
		{
			log.log(Level.SEVERE, "Unable to copy " + className + " from witin jar resources!");
			return;
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		while(true)
		{
			String line = reader.readLine();
			if(line != null)
				lines.add(line);
			else
				break;
		}
		reader.close();
		String[] strings = lines.toArray(new String[lines.size()]);
		String[] split = className.replace(".", "~").split("~");
		String newClassName = "";
		for (int i = 0; i < split.length; i++) 
		{
			newClassName += split[i] + ".";
		}
		newClassName = newClassName.substring(0, newClassName.length() -1);
		File outFile = new File(TstlConstants.getParserOutputSourceDir()+ newClassName);
		outFile.createNewFile();
		PrintWriter writer = new PrintWriter(outFile);
		for (int i = 0; i < strings.length; i++) 
		{
			writer.println(strings[i]);
		}
		writer.flush();
		writer.close();
	}

	public void copyCode() throws IOException
	{
		ArrayList<String> lines = new ArrayList<String>();
		InputStream stream = this.getClass().getResourceAsStream("res/" + "names");
		if(stream == null)
		{
			stream = this.getClass().getResourceAsStream("res/" + "names.names");
		}		
		if(stream == null)
		{
			log.log(Level.SEVERE, "Unable to copy " + "names.names" + " from witin jar resources! No SUT depencies can be written!");
			return;
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		while(true)
		{
			String line = reader.readLine();
			if(line != null)
				lines.add(line);
			else
				break;
		}
		reader.close();

		for (int i = 0; i < lines.size(); i++) 
		{
			if(!lines.get(i).equals("SUT.java"))
				this.copyJarClass(lines.get(i));
		}	
		copyDependency(TstlConstants.JAR_COMMONS_CLI);
		copyDependency(TstlConstants.JAR_EMMA);
		copyClientCode();
	}
	private void copyClientCode() 
	{
		ccLog = new TstlLogger("copyClientCode");
		File workingDir = new File(TstlConstants.getPath(TstlConstants.PATHKEY_WORKINGDIR));
		ccLog.append("workingDir" , workingDir.getAbsolutePath());
		File srcDir = new File(workingDir.getAbsolutePath() + "/src");
		ccLog.append("srcDir" , srcDir.getAbsolutePath());
		if(srcDir.exists() && srcDir.isDirectory())
		{
			ArrayList<File> arrListFiles = new ArrayList<File>();
			recursivelyGetFiles(arrListFiles, srcDir);
			File[] srcFiles = arrListFiles.toArray(new File[arrListFiles.size()]);
			ccLog.append("srcFiles: " , Arrays.toString(srcFiles));
			File[] relFiles = new File[srcFiles.length];
			for(int i = 0; i < srcFiles.length; i++)
			{
				File file = srcFiles[i];
				String srcDirPath = srcDir.getAbsolutePath();
				String fPath = file.getAbsolutePath();
				if(!fPath.startsWith(srcDirPath))
					Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "A src file  is not a child of working directory/src! FILE: \"" + fPath + "\"");
				String rPath = fPath.substring(srcDirPath.length());
				File rFile = new File(TstlConstants.fileInDir(TstlConstants.getParserOutputSourceDir(), rPath));
				relFiles[i] = rFile;
				ccLog.append(i + "", "fPath: " + fPath + "rPath: " + rPath + "rFile: " + rFile.getAbsolutePath());
			}
			for(int x = 0; x < relFiles.length; x++)
			{
				File file = relFiles[x];
				try {
					file.createNewFile();
				} catch (IOException e2) {
					ccLog.append("COULD NOT CREATE FILE FOR: " + file.getAbsolutePath());
				}
				constructDirectories(file.getParentFile());
				ArrayList<String> lines = new ArrayList<String>();
				Scanner scanner = null;
				try {
					scanner = new Scanner(srcFiles[x]);
				} catch (FileNotFoundException e1) {
					ccLog.append("COULD NOT SCAN FOR: " + srcFiles[x].getAbsolutePath());
				}
				while(scanner != null && scanner.hasNextLine())
					lines.add(scanner.nextLine());
				PrintWriter writer = null;
				try {
					writer = new PrintWriter(file);
				} catch (FileNotFoundException e) {
					ccLog.append("COULD NOT CREATE WRITER FOR: " + file.getAbsolutePath());
				}
				for(int y = 0; y < lines.size() && writer != null; y++)
				{
					writer.println(lines.get(y));
				}
				if(writer != null)
				{
					writer.flush();
					writer.close();
				}
			}

		}
		else
		{
			ccLog.append("no src dir?");
		}
		ccLog.close();
	}	
	private void constructDirectories(File parentFile) 
	{
		if(!parentFile.getParentFile().exists())
			constructDirectories(parentFile.getParentFile());
		if(!parentFile.exists())
			parentFile.mkdir();
	}

	private void recursivelyGetFiles(ArrayList<File> files, File search)
	{
		ccLog.append("RGF", search.getAbsolutePath());
		File[] list = search.listFiles();
		for (int i = 0; i < list.length; i++)
		{
			File file = list[i];

			if(file.isDirectory())
			{
				ccLog.append("RGF", "gotdir " + file.getAbsolutePath());
				recursivelyGetFiles(files,file);
			}
			if(file.isFile())
			{
				ccLog.append("RGF", "gotfile " + file.getAbsolutePath());
				files.add(file);
			}

		}
	}

	private void copyDependency(String dependency) throws IOException
	{
		File libFolder  = new File(TstlConstants.fileInDir(TstlConstants.getPath(TstlConstants.PATHKEY_WORKINGDIR), "lib"));
		if(!libFolder.exists() || !libFolder.isDirectory())
			libFolder.mkdir();
		InputStream inStream = null;
		OutputStream outStream = null;
		String jarPath;
		try {
			inStream = CodeCopier.class.getResourceAsStream(dependency);
			if(inStream == null) 
			{
				Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Couldn't get a depedency from within the jar!");
				return;
			}

			int readBytes;
			byte[] buffer = new byte[2048];
			jarPath = TstlConstants.getPath(TstlConstants.PATHKEY_WORKINGDIR)  + "/lib/" + dependency;

			File jarFile = new File(jarPath);

			jarFile.createNewFile();

			outStream = new FileOutputStream(jarFile);
			while ((readBytes = inStream.read(buffer)) > 0)
			{
				outStream.write(buffer, 0, readBytes);
			}
			outStream.flush();

		} catch (IOException ex) {
			throw ex;
		} finally {
			if(inStream != null)
			inStream.close();
			if(outStream != null)
			outStream.close();
		}
	}
}
