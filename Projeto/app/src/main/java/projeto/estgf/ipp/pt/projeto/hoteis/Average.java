package projeto.estgf.ipp.pt.projeto.hoteis;


import java.io.Serializable;

public class Average implements Serializable {
    private String total;
    private String base;


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
