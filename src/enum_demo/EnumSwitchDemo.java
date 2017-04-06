package enum_demo;

public class EnumSwitchDemo {

	Spiciness degree; //枚举类
	public EnumSwitchDemo(Spiciness degree){
		this.degree = degree;
	}
	
	public void describle(){
		System.out.println("Spiciness is enum ? "+Spiciness.class.isEnum());
		switch (degree) {
		case NOT:
			System.out.println(" not !");
			break;
		case HOT:
			System.out.println(" hot !");
			break;
		case MILD:
			System.out.println(" mild ");
			break;
		case MEDIUM:
			System.out.println(" MEDIUM ");
			break;
		default:
			System.out.println(" default ");
			break;
		}
	}
	
	public static void main(String[] args){
		EnumSwitchDemo enumSwitchDemo1 = new EnumSwitchDemo(Spiciness.NOT);
		EnumSwitchDemo enumSwitchDemo2 = new EnumSwitchDemo(Spiciness.HOT);
		EnumSwitchDemo enumSwitchDemo3 = new EnumSwitchDemo(Spiciness.MILD);
		EnumSwitchDemo enumSwitchDemo4 = new EnumSwitchDemo(Spiciness.MEDIUM);
		EnumSwitchDemo enumSwitchDemo5 = new EnumSwitchDemo(Spiciness.FLAMING);
		
		enumSwitchDemo1.describle();
		enumSwitchDemo2.describle();
		enumSwitchDemo3.describle();
		enumSwitchDemo4.describle();
		enumSwitchDemo5.describle();
	}
}
