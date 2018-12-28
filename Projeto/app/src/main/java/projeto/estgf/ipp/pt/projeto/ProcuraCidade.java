package projeto.estgf.ipp.pt.projeto;

import java.io.Serializable;

public class ProcuraCidade implements Serializable {
    private String nome;
    private String cidadePref;
    private String cidadeHabita;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidadePref() {
        return cidadePref;
    }

    public void setCidadePref(String cidadePref) {
        this.cidadePref = cidadePref;
    }

    public String getCidadeHabita() {
        return cidadeHabita;
    }

    public void setCidadeHabita(String cidadeHabita) {
        this.cidadeHabita = cidadeHabita;
    }
}
