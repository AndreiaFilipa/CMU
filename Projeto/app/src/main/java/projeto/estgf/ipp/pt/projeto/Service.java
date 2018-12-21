package projeto.estgf.ipp.pt.projeto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Service implements Serializable {

private List<Segment> segments = null;

public List<Segment> getSegments() {
return segments;
}

public void setSegments(List<Segment> segments) {
this.segments = segments;
}



}