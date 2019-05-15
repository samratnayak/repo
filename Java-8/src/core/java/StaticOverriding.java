package core.java;

public class StaticOverriding {
	
	static class Super {
		public static void method() {
			System.out.println("super");
		}
	}
	
	static class Sub extends Super {
		public static void method() {
			System.out.println("sub method");
		}
	}

	public static void main(String[] args) {
		Super s = new Sub();
		s.method();
	}

}
