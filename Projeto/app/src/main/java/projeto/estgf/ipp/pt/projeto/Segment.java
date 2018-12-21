package projeto.estgf.ipp.pt.projeto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Segment implements Serializable {

private FlightSegment flightSegment;
private PricingDetailPerAdult pricingDetailPerAdult;


public FlightSegment getFlightSegment() {
return flightSegment;
}

public void setFlightSegment(FlightSegment flightSegment) {
this.flightSegment = flightSegment;
}

public PricingDetailPerAdult getPricingDetailPerAdult() {
return pricingDetailPerAdult;
}

public void setPricingDetailPerAdult(PricingDetailPerAdult pricingDetailPerAdult) {
this.pricingDetailPerAdult = pricingDetailPerAdult;
}



}