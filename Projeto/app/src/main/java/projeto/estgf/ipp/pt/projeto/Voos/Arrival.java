package projeto.estgf.ipp.pt.projeto.Voos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Arrival  implements Serializable {

private String iataCode;
private String at;
private String terminal;

public String getIataCode() {
return iataCode;
}

public void setIataCode(String iataCode) {
this.iataCode = iataCode;
}

public String getAt() {
return at;
}

public void setAt(String at) {
this.at = at;
}

public String getTerminal() {
return terminal;
}

public void setTerminal(String terminal) {
this.terminal = terminal;
}


}
