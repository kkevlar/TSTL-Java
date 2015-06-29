
public abstract class RepeatablesContainer 
{
	public abstract Repeatable[] getRepeatables();
	
	public int getActionCount()
	{
		int count = 1;
		for (int i = 0; i < this.getRepeatables().length; i++) 
		{
			count *= this.getRepeatables()[i].getListSize();		
		}
		return count;
	}
	
	public void actOnValidCombinations(RepeatablesAction action) 
	{
		int[] ints = new int[getRepeatables().length];
		for (int i = 0; i < ints.length; i++) 
		{
			ints[i] = -1;
		}
		this.actOnValidCombinations(ints,action);		
	}
	
	private void actOnValidCombinations(int[] ints, RepeatablesAction action)
	{
		int[] newInts = new int[ints.length];
		int negativeIndex = -1;
		for (int i = 0; i < newInts.length; i++) 
		{
			newInts[i] = ints[i];
			if(newInts[i] == -1)
			{
				negativeIndex = i;
			}
		}
		if(negativeIndex == -1)
		{
			action.actOnRepValues(newInts,this);
			return;
		}
		for(int i = 0; i < getRepeatables()[negativeIndex].getListSize(); i++)
		{
			newInts[negativeIndex] = i;
			this.actOnValidCombinations(newInts,action);
		}	

	}

	
}
