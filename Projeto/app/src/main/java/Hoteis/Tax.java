package Hoteis;


public class Tax {

    private String code;
    private Integer percentage;

    private Boolean included;

    private String pricingFrequency;

    private String pricingMode;

    private String amount;


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public Integer getPercentage() {
        return percentage;
    }


    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }


    public Boolean getIncluded() {
        return included;
    }

    public void setIncluded(Boolean included) {
        this.included = included;
    }


    public String getPricingFrequency() {
        return pricingFrequency;
    }


    public void setPricingFrequency(String pricingFrequency) {
        this.pricingFrequency = pricingFrequency;
    }


    public String getPricingMode() {
        return pricingMode;
    }


    public void setPricingMode(String pricingMode) {
        this.pricingMode = pricingMode;
    }


    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

}
