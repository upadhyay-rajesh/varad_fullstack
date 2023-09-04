
public class Manager extends Employee{ //here Manager is child of Employee
	
	
	void add() {
		System.out.println("i am add method of child "+(6+7));
		
		super.add();
	}
	
	void sub() {
		System.out.println("sub method of child");
		//super.sub();
	}

	public static void main(String args[]) {
		Manager m=new Manager();
		m.add();
		m.add(5, 8);
		m.add(7, 9.8f);
	}
}
