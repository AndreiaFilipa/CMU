package projeto.estgf.ipp.pt.projeto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Operating implements Serializable {

private String carrierCode;
private String number;

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

}