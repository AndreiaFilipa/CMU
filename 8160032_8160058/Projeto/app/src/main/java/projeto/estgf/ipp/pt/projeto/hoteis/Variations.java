package projeto.estgf.ipp.pt.projeto.hoteis;


import java.io.Serializable;
import java.util.List;


public class Variations implements Serializable {


    private Average average;

    private List<Change> changes = null;


    public Average getAverage() {
        return average;
    }


    public void setAverage(Average average) {
        this.average = average;
    }


    public List<Change> getChanges() {
        return changes;
    }


    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }

}
