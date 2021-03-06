package projeto.estgf.ipp.pt.projeto.hoteis;

import java.io.Serializable;
import java.util.List;


public class AcceptedPayments implements Serializable {


    private List<String> creditCards = null;

    private List<String> methods = null;


    public List<String> getCreditCards() {
        return creditCards;
    }


    public void setCreditCards(List<String> creditCards) {
        this.creditCards = creditCards;
    }


    public List<String> getMethods() {
        return methods;
    }


    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

}
