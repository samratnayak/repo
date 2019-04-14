package core.java;

import java.io.IOException;

public class B extends A{

	final String a ;
	B(){
	a = "10";	
	System.out.println("B");
	}
	public int doIt(){
		return 0;
	}
	static final int s = 0;
	static int x = 0;
	class inner{
		final int s  = 5;
		// const x = 0;
	}
	static class innerStatic{
		static final int s = 0;
		static int x = 0;
	}
}
