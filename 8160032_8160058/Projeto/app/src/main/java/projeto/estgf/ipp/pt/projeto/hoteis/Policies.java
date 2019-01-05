package projeto.estgf.ipp.pt.projeto.hoteis;

import java.io.Serializable;

public class Policies implements Serializable {

    private Cancellation cancellation;

    private Guarantee guarantee;

    private Deposit deposit;

    private HoldTime holdTime;


    public Cancellation getCancellation() {
        return cancellation;
    }


    public void setCancellation(Cancellation cancellation) {
        this.cancellation = cancellation;
    }


    public Guarantee getGuarantee() {
        return guarantee;
    }


    public void setGuarantee(Guarantee guarantee) {
        this.guarantee = guarantee;
    }


    public Deposit getDeposit() {
        return deposit;
    }


    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }


    public HoldTime getHoldTime() {
        return holdTime;
    }


    public void setHoldTime(HoldTime holdTime) {
        this.holdTime = holdTime;
    }

}
