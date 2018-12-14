package projeto.estgf.ipp.pt.projeto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class OfferItem {

private List<Service> services = null;
private Price price;
private PricePerAdult pricePerAdult;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<Service> getServices() {
return services;
}

public void setServices(List<Service> services) {
this.services = services;
}

public Price getPrice() {
return price;
}

public void setPrice(Price price) {
this.price = price;
}

public PricePerAdult getPricePerAdult() {
return pricePerAdult;
}

public void setPricePerAdult(PricePerAdult pricePerAdult) {
this.pricePerAdult = pricePerAdult;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}