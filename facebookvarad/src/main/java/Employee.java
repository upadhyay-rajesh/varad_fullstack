
public  class Employee {
	final int i8=9;
	void add() {
		System.out.println("i am add method");
		//i8=5;
	}
	
	void add(int i,int j) {
		System.out.println("i am add method "+(i+j));
	}
	void add(int i,float j) {
		System.out.println("i am add method "+(i+j));
	}
	
	private void sub() {
		System.out.println("sub method of parent");
	}
}
