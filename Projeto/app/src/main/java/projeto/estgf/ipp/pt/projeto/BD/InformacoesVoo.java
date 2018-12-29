package projeto.estgf.ipp.pt.projeto.BD;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
public class InformacoesVoo implements Serializable {
    @PrimaryKey
    @NonNull
    public String id;
    public String tipo;
    public String preco;
    public String companhia;
    public String hora;
    public String fluxoViagem;
    public String duracao;

    public String companhiaV;
    public String horaV;
    public String fluxoViagemV;
    public String duracaoV;

}

