package Packagename.SeleniumBesantFreshers;

public class Encapsulation extends SAMPLEGitCheck {

	public void add() 
	{
		System.out.println("add : "+getName());
		setName(15);
		System.out.println("after : "+getName());
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Encapsulation E= new Encapsulation();
		E.add();
	}

}
