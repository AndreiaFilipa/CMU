package projeto.estgf.ipp.pt.projeto.Voos;

import java.io.Serializable;
import java.util.List;

public class OfferItem implements Serializable {

private List<Service> services = null;
private Price price;
private PricePerAdult pricePerAdult;


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



}