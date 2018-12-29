package projeto.estgf.ipp.pt.projeto;

import java.io.Serializable;

public class ProcuraVooHotel implements Serializable {
    private String origem;
    private String destino;
    private String dataPartida;
    private String dataRegresso;
    private String passageiros;
    private String hospedes;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getDataRegresso() {
        return dataRegresso;
    }

    public void setDataRegresso(String dataRegresso) {
        this.dataRegresso = dataRegresso;
    }

    public String getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(String passageiros) {
        this.passageiros = passageiros;
    }

    public String getHospedes() {
        return hospedes;
    }

    public void setHospedes(String hospedes) {
        this.hospedes = hospedes;
    }
}
