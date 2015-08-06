public interface Action
{
	public String name();
	public boolean enabled();
	public void act();
	public String getAllInfo();
	public int initId();
	public int familyId();
	public int[] repVals();
	public int[] repIds();
	public String tstlStyleOutput();
}