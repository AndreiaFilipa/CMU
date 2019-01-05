package projeto.estgf.ipp.pt.projeto.Voos;

import java.io.Serializable;
import java.util.List;

import projeto.estgf.ipp.pt.projeto.Voos.Segment;

public class Service implements Serializable {

private List<Segment> segments = null;

public List<Segment> getSegments() {
return segments;
}

public void setSegments(List<Segment> segments) {
this.segments = segments;
}



}