package projeto.estgf.ipp.pt.projeto.Voos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datum {

private String type;
private String id;
private List<OfferItem> offerItems = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public List<OfferItem> getOfferItems() {
return offerItems;
}

public void setOfferItems(List<OfferItem> offerItems) {
this.offerItems = offerItems;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}