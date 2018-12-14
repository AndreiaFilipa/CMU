package projeto.estgf.ipp.pt.projeto;

import java.util.HashMap;
import java.util.Map;

public class Arrival {

private String iataCode;
private String at;
private String terminal;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
