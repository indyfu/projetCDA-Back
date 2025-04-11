package projet3.maison.leloire.entity;


public class BearerToken {

    private final String token;
    private final String tokenType;

    //  Constructeurs  //

    public BearerToken(String token, String tokenType) {
        this.token = token;
        this.tokenType = tokenType;
    }

    //   Accesseurs  //

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }
}
