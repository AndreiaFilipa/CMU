package projeto.estgf.ipp.pt.projeto.hoteis;

import java.io.Serializable;
import java.util.List;

public class Price implements Serializable {


    private String currency;

    private String total;

   // private List<Tax> taxes = null;

    private Variations variations;

    private String base;


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTotal() {
        return total;
    }


    public void setTotal(String total) {
        this.total = total;
    }


 /*   public List<Tax> getTaxes() {
        return taxes;
    }


    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }
*/

    public Variations getVariations() {
        return variations;
    }


    public void setVariations(Variations variations) {
        this.variations = variations;
    }


    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

}
