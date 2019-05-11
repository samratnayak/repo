package core.java;

public class AttributeOverriding {

	static class A {
		int i = 10;
		void myMethod(){
			System.out.println("method from A");
		}
	}
	
	static class B extends A {
		int i = 20;
		void myMethod(){
			System.out.println("method from B ");
		}
	}
	
	public static void main(String[] args) {
		B a = new B();
		System.out.println("i "+a.i);
		a.myMethod();
	}

}
