import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CodeCopier
{
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
			System.out.println("null");
			System.exit(-1);
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
			System.out.println("null");
			System.exit(-1);
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
		copyDependency(TstlConstants.COMMONS_CLI);
		copyClientCode();
	}
	private void copyClientCode() 
	{
		TstlLogger log = new TstlLogger("copyClientCode");
		File workingDir = new File(TstlConstants.getPath(TstlConstants.PATHKEY_WORKINGDIR));
		log.append("workingDir" , workingDir.getAbsolutePath());
		File srcDir = new File(workingDir.getAbsolutePath() + "/src");
		log.append("srcDir" , srcDir.getAbsolutePath());
		if(srcDir.exists() && srcDir.isDirectory())
		{
			ArrayList<File> arrListFiles = new ArrayList<File>();
			recursivelyGetFiles(arrListFiles, srcDir);
			File[] srcFiles = arrListFiles.toArray(new File[arrListFiles.size()]);
			log.append("srcFiles: " , Arrays.toString(srcFiles));
			File[] relFiles = new File[srcFiles.length];
			for(int i = 0; i < srcFiles.length; i++)
			{
				File file = srcFiles[i];
				String wDirPath = workingDir.getAbsolutePath();
				String fPath = file.getAbsolutePath();
				if(!fPath.startsWith(wDirPath))
					Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "A src file  is not a child of working directory/src! FILE: \"" + fPath + "\"");
				String rPath = fPath.substring(wDirPath.length());
				File rFile = new File(TstlConstants.fileInDir(TstlConstants.getParserOutputSourceDir(), rPath));
				relFiles[i] = rFile;
				log.append(i + "", "fPath: " + fPath + "rPath: " + rPath + "rFile: " + rFile.getAbsolutePath());
			}
		}
		else
		{
			log.append("no src dir?");
		}
		log.close();
	}	
	private void recursivelyGetFiles(ArrayList<File> files, File search)
	{
		File[] list = search.listFiles();
		for (int i = 0; i < list.length; i++)
		{
			File file = list[i];
			if(file.isFile())
			{
				if(file.isDirectory())
				{
					recursivelyGetFiles(files,file);
				}
				if(file.isFile())
				{
					files.add(file);
				}
			}
		}
	}

	private void copyDependency(String dependency) throws IOException
	{
        InputStream inStream = null;
        OutputStream outStream = null;
        String jarPath;
        try {
            inStream = CodeCopier.class.getResourceAsStream(dependency);
            if(inStream == null) 
            {
            	System.out.println("cant get lib inside jar");
                throw new RuntimeException("Cannot get resource \"" + dependency + "\" from Jar file.");
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
            inStream.close();
            outStream.close();
        }
    }
}
