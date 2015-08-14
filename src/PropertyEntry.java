import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;



public class PropertyEntry extends RepeatablesContainer implements RepeatablesAction
{
	private String[] javaCodeSplit;
	private Repeatable[] repeatables;
	private ArrayList<String> checks;

	public static String generateCheck(PropertyEntry[] propEntries)
	{
		
		String ret = "public String check()\n{\n";
		ret += "String fail = null;\n";
		for (int x = 0; x < propEntries.length; x++) 
		{
			ret += propEntries[x].getMyCheck() + "\n";
			
		}
		ret += "return fail;\n";
		ret += "}\n";
		return ret;		 
	}

	public PropertyEntry(LineParsePacket packet)
	{
		super();

		this.setJavaCodeSplit(packet.getJavaCodePieces());
		this.setRepeatables(packet.getRepeatables());
		checks = new ArrayList<String>();
		this.actOnValidCombinations(this);
	}

	public String[] getJavaCodeSplit() 
	{
		return javaCodeSplit;
	}

	private void setJavaCodeSplit(String[] javaCodeSplit)
	{
		this.javaCodeSplit = javaCodeSplit;
	}

	@Override
	public Repeatable[] getRepeatables() 
	{
		return repeatables;
	}

	private void setRepeatables(Repeatable[] repeatables)
	{
		this.repeatables = repeatables;
	}

	@Override
	public void actOnRepValues(int[] vals, RepeatablesContainer cont)
	{		
		String add = "";
		String saveToFile = "";
		for(int i = 0; i < ((this.getRepeatables().length*2)+1); i++)
		{
			if(i % 2 == 0)
			{
				add += javaCodeSplit[i/2];
				saveToFile += javaCodeSplit[i/2];
			}
			else
			{
				Repeatable r = this.getRepeatables()[(i-1)/2];
				int num = vals[(i-1)/2];
				add+=r.getAsJava(num);
				saveToFile += "%" + r.getId() + "," + num + "%";
			}
		}
		String check = "";
		check += "if(!(" + add + "))\n";
		check += "fail =\"" + add + "\";\n";
		if(!(this.checks.contains(check)))
			checks.add(check+TstlConstants.SPLIT_SYNTAX_PROPENTRY_INTERNAL_SPLIT + saveToFile);	
	}

	private String getMyCheck()
	{
		File propFile = new File(TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(), TstlConstants.FILE_PROPENTRY_SAVE));			
		PrintWriter propSaveWriter = null;
		try 
		{
			propFile.createNewFile();
			propSaveWriter = new PrintWriter(propFile);
		} 
		catch (IOException e) 
		{
			TstlConstants.log(Level.SEVERE, "Failed to write propentrysave file!", e);
		}
		
		
		
		String checkString = "";
		for(int i = 0; i < this.checks.size(); i++)
		{
			String[] check = this.checks.get(i).split(TstlConstants.SPLIT_SYNTAX_PROPENTRY_INTERNAL_SPLIT);
			checkString += check[0];
			propSaveWriter.println(check[1]);
		}
		propSaveWriter.flush();
		propSaveWriter.close();	
		return checkString;
	}



}
