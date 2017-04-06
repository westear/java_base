package java_repeat_use.association;

public class Soap {

	private String s;
	Soap(){
		System.out.println("Soap()");
		s = "Constructed";
	}
	public String toString(){
		return s;
	}
}
