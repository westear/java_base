package enum_demo;

public class EnumAttrUseInvoke {
	
	private void getItem(){
		for(EnumAttrUse enumAttrUseItem : EnumAttrUse.values()){
			System.out.println(enumAttrUseItem.ordinal()+1 + 
					". player's name is " + enumAttrUseItem.name() + 
					", his position is " + enumAttrUseItem.getPosition() + 
					" and his number is " + enumAttrUseItem.getNumber() + 
					" and the second_position include " + enumAttrUseItem.getSecondPosition() + ".");
		}
	}
	
	public static void main(String[] args){
		
		EnumAttrUseInvoke enumAttrUseInvoke = new EnumAttrUseInvoke();
		enumAttrUseInvoke.getItem();
	}
}
