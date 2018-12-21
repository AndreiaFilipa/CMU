package projeto.estgf.ipp.pt.projeto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class FlightSegment implements Serializable {

private Departure departure;
private Arrival arrival;
private String carrierCode;
private String number;
private Aircraft aircraft;
private Operating operating;
private String duration;

public Departure getDeparture() {
return departure;
}

public void setDeparture(Departure departure) {
this.departure = departure;
}

public Arrival getArrival() {
return arrival;
}

public void setArrival(Arrival arrival) {
this.arrival = arrival;
}

public String getCarrierCode() {
return carrierCode;
}

public void setCarrierCode(String carrierCode) {
this.carrierCode = carrierCode;
}

public String getNumber() {
return number;
}

public void setNumber(String number) {
this.number = number;
}

public Aircraft getAircraft() {
return aircraft;
}

public void setAircraft(Aircraft aircraft) {
this.aircraft = aircraft;
}

public Operating getOperating() {
return operating;
}

public void setOperating(Operating operating) {
this.operating = operating;
}

public String getDuration() {
return duration;
}

public void setDuration(String duration) {
this.duration = duration;
}



}