package projeto.estgf.ipp.pt.projeto.hoteis;

import java.io.Serializable;

public class Offer implements Serializable {


    private String id;

    private String rateCode;

    private Commission commission;

    private String boardType;

    private Room room;

    private Guests guests;

    private Price price;

    private Policies policies;

    private RateFamilyEstimated rateFamilyEstimated;

    private Description_ description;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getRateCode() {
        return rateCode;
    }


    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }


    public Commission getCommission() {
        return commission;
    }


    public void setCommission(Commission commission) {
        this.commission = commission;
    }


    public String getBoardType() {
        return boardType;
    }


    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }


    public Room getRoom() {
        return room;
    }


    public void setRoom(Room room) {
        this.room = room;
    }


    public Guests getGuests() {
        return guests;
    }


    public void setGuests(Guests guests) {
        this.guests = guests;
    }


    public Price getPrice() {
        return price;
    }


    public void setPrice(Price price) {
        this.price = price;
    }


    public Policies getPolicies() {
        return policies;
    }


    public void setPolicies(Policies policies) {
        this.policies = policies;
    }


    public RateFamilyEstimated getRateFamilyEstimated() {
        return rateFamilyEstimated;
    }


    public void setRateFamilyEstimated(RateFamilyEstimated rateFamilyEstimated) {
        this.rateFamilyEstimated = rateFamilyEstimated;
    }


    public Description_ getDescription() {
        return description;
    }


    public void setDescription(Description_ description) {
        this.description = description;
    }

}
