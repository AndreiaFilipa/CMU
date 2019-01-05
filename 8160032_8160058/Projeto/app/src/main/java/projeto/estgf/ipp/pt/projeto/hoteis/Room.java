package projeto.estgf.ipp.pt.projeto.hoteis;


import java.io.Serializable;

public class Room implements Serializable {


    private String type;

    private TypeEstimated typeEstimated;

    private Description description;


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public TypeEstimated getTypeEstimated() {
        return typeEstimated;
    }


    public void setTypeEstimated(TypeEstimated typeEstimated) {
        this.typeEstimated = typeEstimated;
    }


    public Description getDescription() {
        return description;
    }


    public void setDescription(Description description) {
        this.description = description;
    }

}
