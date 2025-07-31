package payloads;

import Pojo.DeletePlace;

public class DeletePlacePayload {

	
	public static  DeletePlace del(String place_id) {
	DeletePlace dp = new DeletePlace();
	dp.setPlace_id(place_id);
	return dp;
	}
	
}
