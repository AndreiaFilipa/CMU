package projeto.estgf.ipp.pt.projeto;

public class Token {
    private int expires_in;
    private String acess_token;

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAcess_token() {
        return acess_token;
    }

    public void setAcess_token(String acess_token) {
        this.acess_token = acess_token;
    }
}
