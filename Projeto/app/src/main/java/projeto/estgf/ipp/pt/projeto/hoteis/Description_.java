package projeto.estgf.ipp.pt.projeto.hoteis;

import java.io.Serializable;

public class Description_ implements Serializable {


    private String lang;

    private String text;


    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

}
