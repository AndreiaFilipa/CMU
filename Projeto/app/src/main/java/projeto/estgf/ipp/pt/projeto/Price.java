package projeto.estgf.ipp.pt.projeto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Price implements Serializable {

private String total;
private String totalTaxes;


public String getTotal() {
return total;
}

public void setTotal(String total) {
this.total = total;
}

public String getTotalTaxes() {
return totalTaxes;
}

public void setTotalTaxes(String totalTaxes) {
this.totalTaxes = totalTaxes;
}



}