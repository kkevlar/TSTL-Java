public interface Action
{
	public String name();
	public boolean enabled();
	public void act();
	public String getAllInfo();
	public int id();
}