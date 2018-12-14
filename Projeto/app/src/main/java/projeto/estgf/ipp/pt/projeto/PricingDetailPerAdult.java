package projeto.estgf.ipp.pt.projeto;

import java.util.HashMap;
import java.util.Map;
public class PricingDetailPerAdult {

private String travelClass;
private String fareClass;
private Integer availability;
private String fareBasis;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getTravelClass() {
return travelClass;
}

public void setTravelClass(String travelClass) {
this.travelClass = travelClass;
}

public String getFareClass() {
return fareClass;
}

public void setFareClass(String fareClass) {
this.fareClass = fareClass;
}

public Integer getAvailability() {
return availability;
}

public void setAvailability(Integer availability) {
this.availability = availability;
}

public String getFareBasis() {
return fareBasis;
}

public void setFareBasis(String fareBasis) {
this.fareBasis = fareBasis;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}