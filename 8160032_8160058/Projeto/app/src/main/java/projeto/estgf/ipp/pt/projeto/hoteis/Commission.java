package projeto.estgf.ipp.pt.projeto.hoteis;


import java.io.Serializable;

public class Commission implements Serializable {
    private String percentage;
    private String amount;


    public String getPercentage() {
        return percentage;
    }


    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }


    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

}
