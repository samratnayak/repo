package core.java;

public class LocalGlobal {

	static int a = 5;
	public static void main(String args[]) {
		a = 10;
		System.out.println("intiial a "+a);
		int a = 15;
		changeVal(a);
		System.out.println("Final local  a "+a);
		System.out.println("Final global a "+LocalGlobal.a);
	}
	private static void changeVal(int a) {
		a += a;
		System.out.println("change val a "+a);
	}
}
