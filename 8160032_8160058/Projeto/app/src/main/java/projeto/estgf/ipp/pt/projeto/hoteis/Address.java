package projeto.estgf.ipp.pt.projeto.hoteis;

import java.util.List;



public class Address {
    private List<String> lines = null;
    private String postalCode;
    private String cityName;


    public List<String> getLines() {
        return lines;
    }


    public void setLines(List<String> lines) {
        this.lines = lines;
    }


    public String getPostalCode() {
        return postalCode;
    }


    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
