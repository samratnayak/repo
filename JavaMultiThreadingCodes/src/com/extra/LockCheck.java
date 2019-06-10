package com.extra;



public class LockCheck {

	public static void main(String[] args) throws InterruptedException {
		CustomObj obj1 = new CustomObj();
		Thread t1 = new Thread() {@Override
		public void run() {
			try {
				obj1.methodCall();
				//obj1.staticMethodCall();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		};
		t1.setName("1");
		CustomObj obj2 = new CustomObj();
		Thread t2 = new Thread() {@Override
			public void run() {
				try {
					obj2.methodCall();
					//obj2.staticMethodCall();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
			};
		t2.setName("2");
		t1.start();
		t2.start();
		// t1.join();
		// t2.join();
	}
}
