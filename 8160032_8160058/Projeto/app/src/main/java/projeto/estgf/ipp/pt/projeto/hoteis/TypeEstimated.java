package projeto.estgf.ipp.pt.projeto.hoteis;

import java.io.Serializable;

public class TypeEstimated implements Serializable {


    private String category;

    private Integer beds;

    private String bedType;


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public Integer getBeds() {
        return beds;
    }


    public void setBeds(Integer beds) {
        this.beds = beds;
    }


    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

}
