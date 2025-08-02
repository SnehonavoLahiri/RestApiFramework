package payloads;

import java.util.ArrayList;
import java.util.List;

import Pojo.GeoLocations;
import Pojo.LocationDetails;

public class AddPlacePayload {

	
	public LocationDetails AddPlace(String name, String phone, String address,double latitude, double longitude, String website, String language) {
		
		LocationDetails ld = new LocationDetails();
		
//		
//		// Fail the scenario if website is empty
//	    if (website == null || website.trim().isEmpty()) {
//	        throw new IllegalArgumentException("Website URL cannot be null or empty");
//	    }

		ld.setAccuracy(50);
		ld.setName(name);
		ld.setPhone_number(phone);
		ld.setAddress(address);
		List<String> type = new ArrayList<String>();
		type.add("shoe park");
		type.add("shoes");
		ld.setTypes(type);
		
		GeoLocations geo = new GeoLocations();
		geo.setLat(latitude);
		geo.setLng(longitude);
		ld.setLocation(geo);
		
		ld.setWebsite(website);
		ld.setLanguage(language);
		return ld;
	}
}
