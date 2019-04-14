package core.java;

public class A {

	A(int a){
		System.out.println("A "+a);
	}
	A(){
		System.out.println("A");
	}
	protected int doIt() throws IllegalArgumentException{
		try {
		System.out.println("A");
		System.exit(0);
		// throw new IllegalArgumentException();
		return -1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			return 2;
		}
	}
	public static void main(String args[]) throws Exception{/*
		System.out.println(args.length);
		A a = new B();
		// int x = a.doIt();
		// System.out.println("x "+x);
		int x = 5, y =10, z =15, w = 20, q = 6;
		x = ~-~y;
		q = x>y?y:x>z?w:y>z?50:100;
		System.out.println("x "+x+" "+"y "+y+" z "+z+" w "+w+" q "+q);
	
		int i=1;
		for(;;) {
			i++;
			System.out.println(i);
		}
	*/
	String s1 = "E-mail";
	StringBuffer s2 = new StringBuffer();
	s2.append("E-mail");
	String s3 = new String("mail");
	System.out.println((s1==("E-"+s3).intern())+" and "
	+(s2.toString().intern() == ("E-"+s3).intern()));
	char c2 = 100;
	Long x = (long)999;
	double d2 = (double)x.longValue();
	System.out.println("double "+d2);
	A b = new B();
	
	}
}
