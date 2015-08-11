import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;

public class JUnitTestCreator 
{
	private int[] actionIds;
	private SUTInterface sut;
	private HashMap<Integer, String> poolwideMap;
	private HashMap<Integer, ArrayList<String>> javaCodePiecesMap;


	public JUnitTestCreator(int[] actionIds, SUTInterface sut) 
	{
		super();
		this.actionIds = actionIds;
		this.sut = sut;
	}

	public int[] getActionIds() {
		return actionIds;
	}

	public void setActionIds(int[] actionIds) {
		this.actionIds = actionIds;
	}

	public void writeTest() 
	{
		parsePoolEntryMap();
		parseJavaCodePiecesMap();
		String[] lines = generateLocalVariables();
	}

	private void parseJavaCodePiecesMap()
	{
		ArrayList<Integer> familyIdsList = new ArrayList<Integer>();
		for (int x = 0; x < sut.getActions().length; x++) 
		{
			int familyId = sut.getActions()[x].familyId();
			if(!familyIdsList.contains(new Integer(familyId)))
				familyIdsList.add(familyId);
		}
		int[] familyIdsArray = new int[familyIdsList.size()];
		for(int i = 0; i < familyIdsList.size(); i++)
		{
			familyIdsArray[i] = familyIdsList.get(i);
		}
		Arrays.sort(familyIdsArray);
		javaCodePiecesMap = new HashMap<Integer, ArrayList<String>>();
		BufferedReader reader = null;
		File javaCodePiecesMapFile = new File(TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(), TstlConstants.FILE_JAVA_CODE_PIECE_SAVE));
		int putCount = 0;
		try
		{
			reader = new BufferedReader(new FileReader(javaCodePiecesMapFile));
			while(true)
			{
				String line = null;
				line = reader.readLine();
				if(line != null)
				{
					String[] mainSplit = line.split(TstlConstants.SPLIT_SYNTAX_ID_WITH_CODE_PIECES);
					int id = Integer.parseInt(mainSplit[0]);
					if(id != familyIdsArray[putCount])
						continue;
					String codePiecesUnsplit = mainSplit[1];
					String[] codePiecesSplit = codePiecesUnsplit.split(TstlConstants.SPLIT_SYNTAX_JAVA_CODE_PIECES);
					ArrayList<String> codePieces = new ArrayList<String>();
					for (int i = 0; i < codePiecesSplit.length; i++) 
					{
						codePieces.add(codePiecesSplit[i]);
					}					
					javaCodePiecesMap.put(new Integer(id), codePieces);
					putCount++;
				}
				else
					break;
			}
		}
		catch(Exception ex)
		{
			TstlConstants.log(Level.SEVERE,"Failed to read poolwidemap from file!",ex);
		}
		finally
		{
			if(reader != null)
				try
			{
					reader.close();
			}
			catch(Exception ex)
			{
				TstlConstants.log(Level.WARNING, "Failed to close poolwidemap reader.",ex);
			}
		}
	}

	private void parsePoolEntryMap() 
	{
		BufferedReader reader = null;
		File poowideMapFile = new File(TstlConstants.fileInDir(TstlConstants.getTstlHomeDir(), TstlConstants.FILE_POOLWIDE_MAP));
		poolwideMap = new HashMap<Integer,String>();
		try
		{
			reader = new BufferedReader(new FileReader(poowideMapFile));
			while(true)
			{
				String line = null;
				line = reader.readLine();
				if(line != null)
				{
					String[] split = line.split(TstlConstants.SPLIT_SYNTAX_POOLENTRY_ID_AND_CLASSNAME);
					int id = Integer.parseInt(split[0]);
					String className = split[1];
					poolwideMap.put(id,className);
				}
				else
					break;
			}
		}
		catch(Exception ex)
		{
			TstlConstants.log(Level.SEVERE,"Failed to read poolwidemap from file!",ex);
		}
		finally
		{
			if(reader != null)
				try
			{
					reader.close();
			}
			catch(Exception ex)
			{
				TstlConstants.log(Level.WARNING, "Failed to close poolwidemap reader.",ex);
			}
		}
	}

	private String[] generateLocalVariables() 
	{
		ArrayList<String> lines = new ArrayList<String>();
		if(poolwideMap == null)
			return null;
		ArrayList<Integer> varBeenInited = new ArrayList<Integer>();
		for (int x = 0; x < actionIds.length; x++) 
		{
			Action action = sut.getActions()[actionIds[x]];
			int initId = action.initId();
			if(initId != -1)
			{
				boolean already = false;
				for (int y = 0; y < varBeenInited.size(); y++) 
				{
					if(initId == varBeenInited.get(y))
					{
						already = true;
						break;
					}
				}
				if(!already)
				{
					String className = poolwideMap.get(new Integer(initId));
					String initLine = className + " " + makeLocalVariableName(action, initId, 0) + ";";
					lines.add(initLine);
					varBeenInited.add(initId);
				}
			}
		}
		return lines.toArray(new String[lines.size()]);
	}

	private String makeLocalVariableName(Action action, int initId, int varNum)
	{
		String className = poolwideMap.get(new Integer(initId));
		return className.substring(0, 1).toLowerCase() + className.substring(1) + action.repVals()[varNum];
	}

}
