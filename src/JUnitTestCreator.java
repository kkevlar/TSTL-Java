import java.util.ArrayList;

public class JUnitTestCreator 
{
	private int[] actionIds;
	private SUTInterface sut;


	public JUnitTestCreator(int[] actionIds, SUTInterface sut) {
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
		generateInstanceVariables();
	}

	private void generateInstanceVariables() 
	{
		ArrayList<Integer> varBeenInited = new ArrayList<Integer>();
		for (int x = 0; x < actionIds.length; x++) 
		{
			int initId = sut.getActions()[actionIds[x]].initId();
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
					//String initLine = "" UNFINISHED
					varBeenInited.add(initId);
				}
			}
		}
		
	}
	
}
