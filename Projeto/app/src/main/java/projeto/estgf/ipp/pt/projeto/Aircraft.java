package projeto.estgf.ipp.pt.projeto;

import java.util.HashMap;
import java.util.Map;

public class Aircraft {

private String code;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}