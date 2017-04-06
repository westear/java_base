package java_repeat_use.extend;
/**
 * 继承结构初始化
 * @author westear
 * 2017年4月1日
 */
public class Cartoon extends Drawing{

	public Cartoon(){
		System.out.println("Cartoon constructor!");
	}
	
	public static void main(String[] args){
		Cartoon x = new Cartoon();
		System.out.println(x);
	}
}

class Art{
	Art(){
		System.out.println("Art Constructor");
	}
	
	protected void printProtected(){
		System.out.println("print artProtected!"); 
	}
}

class Drawing extends Art {

	public Drawing() {
		System.out.println("Drawing constructor! ");
	}
	
	@Override
	protected void printProtected(){
		System.out.println("print drawProtected!");
	}
}