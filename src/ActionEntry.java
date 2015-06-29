import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class ActionEntry extends RepeatablesContainer
{
	public static String[] splitActionLine(String rawLine)
	{
		if(rawLine.contains(TstlConstants.IDENTIFIER_EXPLICIT_GUARD))
		{
			String[] pieces = rawLine.split(TstlConstants.IDENTIFIER_EXPLICIT_GUARD);
			if(pieces.length > 2)
				throw new MalformedTstlException(TstlConstants.MESSAGE_ONLY_ONE_EXPLICIT_GUARD + ": " + rawLine);
			return pieces;
		}
		else
		{
			return new String[]{null,rawLine};
		}
	}
	private String explicitGuardUnparsed;
	private String actionLine;
	private PoolEntry[] entirePoolEntries;	
	private Repeatable[] repeatables;
	private String[] javaCodePieces;
	private HashMap<Repeatable, int[]> repeatingPoolValues;
	private String[] javaExpressionPieces;
	private String[] expressionVarInformation;

	public ActionEntry(String explicitGuardUnparsed, String actionLine, PoolEntry[] entirePoolEntries) 
	{
		this.explicitGuardUnparsed = explicitGuardUnparsed;
		this.actionLine = actionLine;
		this.entirePoolEntries = entirePoolEntries;
		this.parseActionLine();
		this.parseExplicitGuard();
	}
	private void parseExplicitGuard()
	{
		if(this.explicitGuardUnparsed == null)
			return;
		repeatingPoolValues = new HashMap<Repeatable,int[]>();
		for(int x = 0; x < this.getRepeatables().length; x++)
		{
			Repeatable rep = this.getRepeatables()[x];
			Repeatable[] reps = repeatingPoolValues.keySet().toArray(new Repeatable[repeatingPoolValues.size()]);
			Repeatable storeRep = rep;
			int[] newInts = new int[]{x};
			for(int y = 0; y < reps.length; y++)
			{
				Repeatable testRep = reps[y];
				boolean equal = rep.equalsRepeatable(testRep);
				if(!equal)
					continue;
				int[] ints  = repeatingPoolValues.get(testRep);
				newInts = new int[ints.length + 1];
				for (int z = 0; z < ints.length; z++) 
				{
					newInts[z] = ints[z];
				}
				newInts[newInts.length-1] = x;
				storeRep = testRep;
				repeatingPoolValues.remove(testRep);
				break;
			}
			repeatingPoolValues.put(storeRep, newInts);
		}

		String[] pieces = this.explicitGuardUnparsed.split(TstlConstants.IDENTIFIER_TSTLVARIABLE);
		if(pieces.length % 2 != 1)
			throw new MalformedTstlException(TstlConstants.MESSGAGE_NONSURROUNDING_VARIABLE_IDENTIFIERS + actionLine);
		javaExpressionPieces = new String[(pieces.length+1)/2];
		expressionVarInformation = new String[javaExpressionPieces.length -1];
		for (int i = 0; i < pieces.length; i++)
		{
			if(i%2==0)
			{
				int javaIndex = i/2;
				javaExpressionPieces[javaIndex] = pieces[i];
			}
			else
			{
				expressionVarInformation[(i-1)/2] = pieces[i];
			}
		}
	}
	private void parseActionLine()
	{
		String newActionLine = actionLine;
		boolean hasInit;
		if(newActionLine.contains(TstlConstants.IDENTIFIER_INITIALIZATION))
			hasInit = true;
		else
			hasInit = false;
		ArrayList<Repeatable> entries = new ArrayList<Repeatable>();

		if(hasInit)
		{
			PoolEntry initVar = null;
			String[] pieces = newActionLine.split(TstlConstants.IDENTIFIER_INITIALIZATION);
			newActionLine = pieces[1];
			String name =  pieces[0].replace(TstlConstants.IDENTIFIER_TSTLVARIABLE, " ").trim();
			initVar = (PoolEntry) TstlConstants.getRepeatableFromVariable(name,true, entirePoolEntries, actionLine);
			entries.add(initVar);
		}
		newActionLine = " " + newActionLine + " ";
		LineParsePacket packet = TstlConstants.parseVarLine(newActionLine, entirePoolEntries);
		for(int i = 0; i < packet.getRepeatables().length; i++)
		{
			entries.add(packet.getRepeatables()[i]);
		}
		this.javaCodePieces = packet.getJavaCodePieces();
		this.repeatables = entries.toArray(new Repeatable[entries.size()]);
	}
	
	protected String[] getJavaPieces() 
	{
		return this.javaCodePieces;
	}
	
	public Repeatable[] getRepeatables()
	{
		return this.repeatables;
	}
	
	protected boolean hasInit()
	{
		return this.getRepeatables().length == this.getJavaPieces().length;
	}
	public String makeGetNameMethod(int[] poolValues)
	{
		String ret = TstlConstants.DECLARATION_ACTION_NAME_METHOD + "\n";
		ret += "{\n";
		ret += "return \"" + this.getActMainLine(poolValues).replace(";", "") + "\";\n";
		ret += "} //end name()\n";
		return ret;
	}
	public String makeEnabledMethod(int[] poolValues)
	{
		String ret = TstlConstants.DECLARATION_ACTION_ENABLED_METHOD + "\n";
		ret += "{\n";
		ret += "boolean enabled = ";
		for (int i = 0; i < this.getRepeatables().length; i++)
		{
			if(i == 0 && this.hasInit())
				ret += this.getRepeatables()[i].getCanOverwriteExpression(poolValues[i]);
			else
			{
				if(i != 0)
					ret += " &&\n";
				ret += this.getRepeatables()[i].getIsUsableExpression(poolValues[i]);
			}

		}
		String s= this.getExplicitGuardExpression(poolValues);
		if(s != null)
		{
			ret += "\n&& (" + s + ")";
		}
		ret += ";"+ "\n";
		ret += "return enabled;"+ "\n";
		ret += "} //end enabled()\n";
		return ret;
	}
	public String getExplicitGuardExpression(int[] vals)
	{
		if(this.explicitGuardUnparsed == null)
			return null;
		String expressionLine = "";
		for (int i = 0; i < (this.javaExpressionPieces.length*2)-1;i++) 
		{
			if(i%2==0)
				expressionLine += this.javaExpressionPieces[(i)/2];
			else
			{
				String inf = this.expressionVarInformation[(i-1)/2];
				String[] split = inf.split(",");
				PoolEntry pEntry = (PoolEntry) TstlConstants.getRepeatableFromVariable(split[0], true, entirePoolEntries, actionLine);
				int index = Integer.parseInt(split[1])-1;//can error need throw/catch.....
				int indexFromVals = this.repeatingPoolValues.get(pEntry)[index];
				int giveToPoolNum = vals[indexFromVals];
				expressionLine += pEntry.getAsJava(giveToPoolNum);
			}
		}
		return expressionLine;
	}
	public String makeActMethod(int[] poolValues)
	{
		String ret = TstlConstants.DECLARATION_ACTION_ACT_METHOD + " \n";
		ret += "{\n";
		ret += this.getActMainLine(poolValues) + "\n";
		ret += this.getActUsageLines(poolValues) + "\n";
		ret += "} //end act() \n";
		return ret;
	}
	public String makeGetAllInfoMethod(int vals[])
	{
		String ret = "public String getAllInfo()"+ "\n"
				+"{"+ "\n"+ "\n"
				+"LabelFormatter formatter = new LabelFormatter();"+ "\n"
				+"formatter.addToStorage"+"(\"MainLine/Name\",\"" + this.getActMainLine(vals) + "\");"+ "\n"
				+"formatter.addToStorage"+"(\"enabled()\",enabled()+\"\");"+ "\n";
		for(int i = 0; i < this.getRepeatables().length; i++)
		{
			
			String asJava = this.getRepeatables()[i].getAsJava(vals[i]);
			ret += "formatter.addToStorage"+"(\"" + asJava+"\","+asJava+"+\"\");"+ "\n";
		
		}
		ret += "return formatter.getAllFormatted();"+"\n";
		ret += "}"+"\n";
		return ret;
	}

	public String getActMainLine(int[] poolValues)
	{
		String mainLine = "";
		String endingCharacters = ";";
		int poolStartIndex= 0;
		if(this.hasInit())
		{
			PoolEntry poolEntry = (PoolEntry) this.getRepeatables()[0];
			mainLine += poolEntry.getVarName() + ".set(" + poolValues[0] + ", ";
			endingCharacters = ")" + endingCharacters;
			poolStartIndex = 1;
		}
		for (int i = 0; i < (this.getJavaPieces().length*2)-1;i++) 
		{
			if(i%2==0)
				mainLine += this.getJavaPieces()[(i)/2];//was (i+1)/2 - if bug reimplement
			else
			{
				int index = (i/2)+poolStartIndex;
				mainLine += this.getRepeatables()[index].getAsJava(poolValues[index]);
			}
		}
		mainLine += endingCharacters;
		return mainLine;
	}
	public String getActUsageLines(int[] poolValues)
	{
		String ret = "";
		String save = "";
		for(int i = 0; i < this.getRepeatables().length; i++)
		{
			if(i == 0)
			{
				PoolEntry pEntry = (PoolEntry) this.getRepeatables()[i];
				save = pEntry.getUsedVarName() + "[" + poolValues[i] + "] = false;\n";
			}
			else
			{
				if(this.getRepeatables()[i] instanceof PoolEntry)
				{
					PoolEntry pEntry = (PoolEntry) this.getRepeatables()[i];
					ret += pEntry.getUsedVarName() + "[" + poolValues[i] + "] = true;\n";
				}
			}
		}
		ret += save;
		return ret;
	}
	public String createActionClass(int[] poolValues)
	{
		String ret = TstlConstants.DECLARATION_ACTION_CLASS + "\n";
		ret += this.makeGetNameMethod(poolValues);
		ret += this.makeEnabledMethod(poolValues);
		ret += this.makeActMethod(poolValues);
		ret += this.makeGetAllInfoMethod(poolValues);
		ret += "};";
		return ret;
	}

	@Override
	public String toString() 
	{
		return "ActionEntry [explicitGuardUnparsed=" + explicitGuardUnparsed
				+ ", actionLine=" + actionLine + ", entirePoolEntries="
				+ Arrays.toString(entirePoolEntries) + ", repeatables="
				+ Arrays.toString(repeatables) + ", javaCodePieces="
				+ Arrays.toString(javaCodePieces) + "]";
	}

}
