package projeto.estgf.ipp.pt.projeto.hoteis;


import java.io.Serializable;

public class Deposit implements Serializable {

    private String amount;
    private AcceptedPayments_ acceptedPayments;


    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }


    public AcceptedPayments_ getAcceptedPayments() {
        return acceptedPayments;
    }


    public void setAcceptedPayments(AcceptedPayments_ acceptedPayments) {
        this.acceptedPayments = acceptedPayments;
    }

}
