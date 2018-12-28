package projeto.estgf.ipp.pt.projeto.hoteis;


import java.io.Serializable;

public class Guarantee implements Serializable {


    private AcceptedPayments acceptedPayments;


    public AcceptedPayments getAcceptedPayments() {
        return acceptedPayments;
    }


    public void setAcceptedPayments(AcceptedPayments acceptedPayments) {
        this.acceptedPayments = acceptedPayments;
    }

}
