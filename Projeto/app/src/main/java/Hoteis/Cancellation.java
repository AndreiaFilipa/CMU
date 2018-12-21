package Hoteis;



public class Cancellation {


    private Integer numberOfNights;

    private String type;

    private String deadline;

    private String amount;


    public Integer getNumberOfNights() {
        return numberOfNights;
    }


    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getDeadline() {
        return deadline;
    }


    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
