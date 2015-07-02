
public class TestReducer 
{
	private SUTInterface sut;
	private long[] originalTestIds;	
	public TestReducer(SUTInterface sut, long[] originalTestIds)
	{
		super();
		this.sut = sut;
		this.originalTestIds = originalTestIds;
	}
	public void reduceTest()
	{
		
	}
	private boolean isTestOk(long[] actionIds)
	{
		if(actionIds[actionIds.length - 1] != originalTestIds[originalTestIds.length - 1])
			return false;
		sut.reset();
		for (int i = 0; i < actionIds.length -1; i++) 
		{
			Action action = getActionById(actionIds[i]);
			if(!(action.enabled()))
				return false;
			action.act();
		}
		if(this.getActionById(actionIds[actionIds.length-1]).enabled())
			return true;
		else
			return false;
	}	

	private Action getActionById(long l)
	{
		Action action = sut.getActions()[(int) l];
		if(action.id() == l)
			return action;
		for (int i = 0; i < sut.getActions().length; i++)
		{
			action = sut.getActions()[i];
			if(action.id() == l)
				return action;
		}
		return null;
	}
}
