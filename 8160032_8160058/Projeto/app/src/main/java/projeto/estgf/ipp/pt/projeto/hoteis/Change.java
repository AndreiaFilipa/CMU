package projeto.estgf.ipp.pt.projeto.hoteis;

import java.io.Serializable;

public class Change implements Serializable {
    private String startDate;
    private String endDate;
    private String total;
    private String base;


    public String getStartDate() {
        return startDate;
    }


    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public String getEndDate() {
        return endDate;
    }


    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public String getTotal() {
        return total;
    }


    public void setTotal(String total) {
        this.total = total;
    }


    public String getBase() {
        return base;
    }


    public void setBase(String base) {
        this.base = base;
    }

}
