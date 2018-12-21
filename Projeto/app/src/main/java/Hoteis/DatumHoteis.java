package Hoteis;

import java.util.List;



public class DatumHoteis {


    private String type;

    private Hotel hotel;

    private Boolean available;

    private List<Offer> offers = null;

    private String self;


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }

    public Hotel getHotel() {
        return hotel;
    }


    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


    public Boolean getAvailable() {
        return available;
    }


    public void setAvailable(Boolean available) {
        this.available = available;
    }


    public List<Offer> getOffers() {
        return offers;
    }


    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }


    public String getSelf() {
        return self;
    }


    public void setSelf(String self) {
        this.self = self;
    }

}
