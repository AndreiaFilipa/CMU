package projeto.estgf.ipp.pt.projeto.Voos;

import java.io.Serializable;

import projeto.estgf.ipp.pt.projeto.Voos.FlightSegment;
import projeto.estgf.ipp.pt.projeto.Voos.PricingDetailPerAdult;

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