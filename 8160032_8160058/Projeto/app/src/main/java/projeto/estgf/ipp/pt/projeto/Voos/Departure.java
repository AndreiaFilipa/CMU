package projeto.estgf.ipp.pt.projeto.Voos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Departure implements Serializable {

private String iataCode;
private String at;


public String getIataCode() {
return iataCode;
}

public void setIataCode(String iataCode) {
this.iataCode = iataCode;
}

public String getAt() {
return at;
}

public void setAt(String at) {
this.at = at;
}



}