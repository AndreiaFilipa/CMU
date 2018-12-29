package projeto.estgf.ipp.pt.projeto.hoteis;

import java.io.Serializable;

public class RateFamilyEstimated implements Serializable {


    private String code;

    private String type;

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
