package Hoteis;


public class Hotel {

    private String type;

    private String hotelId;

    private String chainCode;

    private String dupeId;

    private String name;

    private String cityCode;

    private Double latitude;

    private Double longitude;

    private HotelDistance hotelDistance;

    private Address address;

    private Contact contact;


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }


    public String getChainCode() {
        return chainCode;
    }


    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }


    public String getDupeId() {
        return dupeId;
    }


    public void setDupeId(String dupeId) {
        this.dupeId = dupeId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCityCode() {
        return cityCode;
    }


    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Double getLatitude() {
        return latitude;
    }


    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    public Double getLongitude() {
        return longitude;
    }


    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public HotelDistance getHotelDistance() {
        return hotelDistance;
    }


    public void setHotelDistance(HotelDistance hotelDistance) {
        this.hotelDistance = hotelDistance;
    }


    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }


    public Contact getContact() {
        return contact;
    }


    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
