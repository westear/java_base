package enum_demo;

public enum EnumAttrUse {
	
//	Lionel_MESSI, Luis_SUAREZ;
//	
//	EnumAttrUse(){
//		
//	}
	
	Lionel_MESSI("SS", 10, "RWF/AMF"),
	Luis_SUAREZ("CF", 9, "SS/LWF"),
	Gerard_DEULOFEU("RWF",16, "LWF"),
	Andres_INIESTA("CWF", 8, "LWF/AMF"),
	Ivan_RAKITIC("CMF", 4, "DMF/AMF"),
	Sergio_BUSQUETS("DMF", 5, "CMF/CB"),
	Loze_PAULINHO("DMF", 15, "CMF/AMF/CF"),
	Sergi_ROBERTO("CMF", 20, "DMF/AMF/RWF/LWF/RB/LB"),
	Andre_GOMES("CMF", 21, "LWF/DMF/AMF"),
	Denis_SUAREZ("CMF", 6, "LWF/AMF"),
	Gerard_PIQUE("CB", 3, "CF(additional)"),
	Samuel_UMTITI("CB", 23, "LB"),
	Jordi_ALBA("LB", 18, "LWF"),
	Nelson_SEMEDO("RB", 2, "RWF"),
	Ter_STEGEN("GK", 1, "");
	
	private String position;
	private int number;
	private String second_position;
	
	EnumAttrUse(String position, int number, String second_position){
		this.position = position;
		this.number = number;
		this.second_position = second_position;
	}

	public String getPosition() {
		return position;
	}

	public int getNumber() {
		return number;
	}
	
	public String getSecondPosition(){
		return second_position;
	}

}
