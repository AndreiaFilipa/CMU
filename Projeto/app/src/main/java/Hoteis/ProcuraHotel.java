package Hoteis;

import java.io.Serializable;

public class ProcuraHotel implements Serializable {
    private String cidadeDestino;
    private String dataCheckIn;
    private String dataCheckOut;
    private String hospedes;

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(String dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(String dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public String getHospedes() {
        return hospedes;
    }

    public void setHospedes(String hospedes) {
        this.hospedes = hospedes;
    }
}
