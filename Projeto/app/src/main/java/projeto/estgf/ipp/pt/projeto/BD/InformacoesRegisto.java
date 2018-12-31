package projeto.estgf.ipp.pt.projeto.BD;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
public class InformacoesRegisto implements Serializable {
    @PrimaryKey
    @NonNull
    public String nomeUtilizador;
    public String ciadadePreferencia;
    public String cidadeHabita;
}
