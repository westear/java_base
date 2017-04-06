package java_repeat_use.extend_association;

/**
 * 继承和组合的通用准则是：
	用继承表达行为间的差异，并用字段表达状态上的变化
 * @author westear
 */

//基类
class Actor{
	public void act(){
		System.out.println("base actor");
	}
}

//导出类（子类）
class HappyActor extends Actor{
	public void act(){
		System.out.println("HappyActor");
	}
	public void smile(){
		System.out.println("smile");
	}
}

//导出类，与HappyActor具有不同的行为
class SadActor extends Actor{
	public void act(){
		System.out.println("SadActor");
	}
	public void cry(){
		System.out.println("cry");
	}
}

class Sage {
	private Actor actor = new HappyActor();	//组合
	//改变行为
	public void change(){
		actor = new SadActor();
	}
	public void performPlay(){
		actor.act();
	}
}

public class ChangeBehaviour {

	public static void main(String[] args){
		Sage sage = new Sage();
		sage.performPlay();
		sage.change();
		sage.performPlay();
//		sage.smile();  向上转型后不具备导出类独有的方法
	}
}
