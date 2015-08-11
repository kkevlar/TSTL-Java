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
	private int familyId;
	private boolean reInitEnabled[];

	public ActionEntry(String explicitGuardUnparsed, String actionLine, PoolEntry[] entirePoolEntries, int familyId) 
	{
		this.explicitGuardUnparsed = explicitGuardUnparsed;
		this.actionLine = actionLine;
		this.entirePoolEntries = entirePoolEntries;
		this.parseActionLine();
		this.parseExplicitGuard();
		this.setFamilyId(familyId);
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
		boolean reInit = false;
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
			if(name.startsWith("~"))
			{
				reInit = true;
				name = name.substring(1).trim();
			}
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
		int bonus = 0;
		if(hasInit())
			bonus = 1;
		reInitEnabled = new boolean[packet.getTreatAsUnused().length + bonus];
		if(hasInit())
			reInitEnabled[0] = reInit;
		for(int i = bonus; i<reInitEnabled.length; i++)
		{
			reInitEnabled[i] = packet.getTreatAsUnused()[i-bonus];
		}
	}

	
	protected String[] getJavaPieces() 
	{
		return this.javaCodePieces;
	}

	@Override
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
		ret += "return \"" + TstlConstants.escapeString(this.getActMainLine(poolValues).replace(";", "")) + "\";\n";
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
				int index;
				try
				{
					index = Integer.parseInt(split[1])-1;
				}
				catch(Exception ex)
				{
					throw new MalformedTstlException("Are your pool variables in explicit guards formatted as: %INT,2%?");
				}
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
				+"formatter.addToStorage"+"(\"MainLine/Name\",\"" + TstlConstants.escapeString(this.getActMainLine(vals)) + "\");"+ "\n"
				+"formatter.addToStorage"+"(\"enabled()\",enabled()+\"\");"+ "\n";
		for(int i = 0; i < this.getRepeatables().length; i++)
		{			
			Repeatable rep = this.getRepeatables()[i];
			String java;
			String label;
			if(rep instanceof NumRange)
			{
				NumRange numrange = (NumRange) rep;
				java = numrange.getAsJava(vals[i]);
				label = numrange.getAsTstl();
			}
			else
			{				
				java = rep.getAsJava(vals[i]);
				label = rep.getAsJava(vals[i]);
			}
			ret += "formatter.addToStorage"+"(\"" + label+"\","+java+"+\"\");"+ "\n";		
		}
		ret += "return formatter.getAllFormatted();"+"\n";
		ret += "}"+"\n";
		return ret;
	}
	public String makeGetInitIdMethod()
	{
		String ret = "public int "+TstlConstants.DECLARATION_ACTION_INITID_METHOD+"()"+"\n"
				+ "{"+"\n";
		if(this.hasInit())
			ret += "return " + getRepeatables()[0].getId() +";"+"\n";
		else
			ret += "return " + -1 +";"+"\n";
		ret += "}" + "\n";
		return ret;
	}
	public String makeGetRepValsMethod(int[] repVals)
	{
		String array = "new int[] {";
		for (int i = 0; i < repVals.length; i++) 
		{
			array += repVals[i] + ",";
		}
		array = array.substring(0,array.length()-1);
		array += "}";
		String ret = "public int[] "+TstlConstants.DECLARATION_ACTION_REPVAL_METHOD+"()"+"\n"
				+ "{"+"\n";
		ret += "return " + array +";"+"\n";
		ret += "}" + "\n";
		return ret;
	}
	public String makeGetRepIdsMethod()
	{
		String array = "new int[] {";
		for (int i = 0; i < this.getRepeatables().length; i++) 
		{
			array += this.getRepeatables()[i].getId() + ",";
		}
		array = array.substring(0,array.length()-1);
		array += "}";
		String ret = "public int[] "+TstlConstants.DECLARATION_ACTION_REPID_METHOD+"()"+"\n"
				+ "{"+"\n";
		ret += "return " + array +";"+"\n";
		ret += "}" + "\n";
		return ret;
	}
	public String makeGetFamilyIdMethod()
	{
		String ret = "public int "+TstlConstants.DECLARATION_ACTION_FAMILY_ID_METHOD+"()"+"\n"
				+ "{"+"\n";
		ret += "return " + familyId +";"+"\n";
		ret += "}" + "\n";
		return ret;
	}
	public String getActMainLine(int[] poolValues)
	{
		String mainLine = "";
		String endingCharacters = ";";
		int poolStartIndex= 0;
		if(this.hasInit())
		{
			if(this.getRepeatables()[0] instanceof NumRange)
				System.out.println(this.toString());
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
	public String makeFormattedTstlMethod(int[] poolValues)
	{
		String[] jav = new String[getJavaPieces().length];
		//need to copy, escape quotes, and replace below
		for (int i = 0; i < jav.length; i++) 
		{
			jav[i] = TstlConstants.escapeString(getJavaPieces()[i]);
		}
		String ret = "public String " + TstlConstants.DECLARTATION_ACTION_METHOD_TSTL_STYLE_OUTPUT + "(){\n";
		String line = "return \"";
		int plus = 0;
		if(hasInit())
		{
			line += this.getRepeatables()[0].getAsFormattedTstl(poolValues[0]) + " =";
			plus = 1;
		}
		for (int i = 0; i < (jav.length*2)-1;i++) 
		{
			if(i%2==0)
				line += jav[(i)/2];//was (i+1)/2 - if bug reimplement
			else
			{
				int index = ((i-1)/2) + plus;
				line += this.getRepeatables()[index].getAsFormattedTstl(poolValues[index]);
			}
		}
		line += "\";\n";
		ret += line;
		ret += "}\n";
		return ret;
	}
	public String getActUsageLines(int[] poolValues)
	{
		String ret = "";
		String save = "";
		for(int i = 0; i < this.getRepeatables().length; i++)
		{
			if(i == 0 && hasInit())
			{
				PoolEntry pEntry = (PoolEntry) this.getRepeatables()[i];
				int valToSet;
				if(reInitEnabled[i])
					valToSet = 1;
				else
					valToSet = 0;
				save = pEntry.getUsedVarName() + "[" + poolValues[i] + "] = " + valToSet + ";\n";
			}
			else
			{
				if(this.getRepeatables()[i] instanceof PoolEntry && !reInitEnabled[i])
				{
					PoolEntry pEntry = (PoolEntry) this.getRepeatables()[i];
					ret += pEntry.getUsedVarName() + "[" + poolValues[i] + "] = 2;\n";
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
		ret += this.makeGetInitIdMethod();
		ret += this.makeGetFamilyIdMethod();
		ret += this.makeGetRepValsMethod(poolValues);
		ret += this.makeGetRepIdsMethod();
		ret += this.makeFormattedTstlMethod(poolValues);
		ret += "};";
		return ret;
	}

	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	@Override
	public String toString() 
	{
		return "ActionEntry [explicitGuardUnparsed=" + explicitGuardUnparsed
				+ ", actionLine=" + actionLine + ", entirePoolEntries="
				+ Arrays.toString(repeatables) + ", javaCodePieces="
				+ Arrays.toString(javaCodePieces) + "]";
	}

	public String getJavaCodePiecesAsSaveLine()
	{
		String javaCodePieceLine = "";
		for (int i = 0; i < getJavaPieces().length; i++) 
		{
			System.out.println("Java Code Piece " + i + ": " + getJavaPieces()[i]); //t
			String append;				
			if(getJavaPieces()[i].length() > 0)
				append = getJavaPieces()[i];
			else
				append = " ";
			javaCodePieceLine += append + TstlConstants.SPLIT_SYNTAX_JAVA_CODE_PIECES;
		}
		System.out.println("jcpl " + javaCodePieceLine); //t
		javaCodePieceLine = javaCodePieceLine.substring(0,(javaCodePieceLine.length()-TstlConstants.SPLIT_SYNTAX_JAVA_CODE_PIECES.length()));
		System.out.println("jcpl " + javaCodePieceLine); //t
		return getFamilyId() + TstlConstants.SPLIT_SYNTAX_ID_WITH_CODE_PIECES + javaCodePieceLine;
	}
}
