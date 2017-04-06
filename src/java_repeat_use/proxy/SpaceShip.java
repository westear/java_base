package java_repeat_use.proxy;

public class SpaceShip{

	private String name;
	public SpaceShip(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
	//使用代理
	private SpaceShipControls  spaceShipControls = new SpaceShipControls();
	
	public void forword(int i){
		spaceShipControls.forword(i);
	}
	public void back(int i){
		spaceShipControls.back(i);
	}
	public void left(int i){
		spaceShipControls.left(i);
	}
	public void right(int i){
		spaceShipControls.right(i);
	}
	public void up(int i){
		spaceShipControls.up(i);
	}
	public void down(int i){
		spaceShipControls.down(i);
	}
	
	public static void main(String[] args){
		SpaceShip spaceShip = new SpaceShip("proxySpaceShip");
		spaceShip.forword(100);
		System.out.println(spaceShip);
	}
}
