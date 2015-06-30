
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;


public class FlushWriter extends PrintWriter {

	public FlushWriter(Writer arg0) {
		super(arg0);
		
	}

	public FlushWriter(OutputStream arg0) {
		super(arg0);
		
	}

	public FlushWriter(String arg0) throws FileNotFoundException {
		super(arg0);
		
	}

	public FlushWriter(File arg0) throws FileNotFoundException {
		super(arg0);
		
	}

	public FlushWriter(Writer arg0, boolean arg1) {
		super(arg0, arg1);
		
	}

	public FlushWriter(OutputStream arg0, boolean arg1) {
		super(arg0, arg1);
		
	}

	public FlushWriter(String arg0, String arg1) throws FileNotFoundException,
			UnsupportedEncodingException {
		super(arg0, arg1);
		
	}

	public FlushWriter(File arg0, String arg1) throws FileNotFoundException,
			UnsupportedEncodingException {
		super(arg0, arg1);
		
	}
	@Override
	public void println()
	{
		this.println("");
	}
	@Override
	public void println(String s)
	{
		this.print(s + "\n");
	}
	@Override
	public void print(String s)
	{
		s = TstlConstants.excapeString(s);
		super.print(s);
		this.flush();
	}
	

}
