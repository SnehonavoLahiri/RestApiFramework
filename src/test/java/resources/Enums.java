package resources;

public enum Enums {

	
	 AddPlace("maps/api/place/add/json"),
	GetPlace("maps/api/place/get/json"),
	UpdatePlace("maps/api/place/update/json"),
	DeletePlace("maps/api/place/delete/json");
	
	private String api;
	
	
	Enums (String api){
		this.api=api;
	}
	public String getApi() {
		return api;
	}
}
