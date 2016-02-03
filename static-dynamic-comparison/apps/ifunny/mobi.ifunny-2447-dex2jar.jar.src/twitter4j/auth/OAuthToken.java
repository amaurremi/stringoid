package twitter4j.auth;

import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;

import twitter4j.HttpResponse;

abstract class OAuthToken
        implements Serializable {
    private static final long serialVersionUID = -7841506492508140600L;
    private String[] responseStr = null;
    private transient SecretKeySpec secretKeySpec;
    private final String token;
    private final String tokenSecret;

    OAuthToken(String paramString) {
        this.responseStr = paramString.split("&");
        this.tokenSecret = getParameter("oauth_token_secret");
        this.token = getParameter("oauth_token");
    }

    public OAuthToken(String paramString1, String paramString2) {
        if (paramString1 == null) {
            throw new IllegalArgumentException("Token can't be null");
        }
        if (paramString2 == null) {
            throw new IllegalArgumentException("TokenSecret can't be null");
        }
        this.token = paramString1;
        this.tokenSecret = paramString2;
    }

    OAuthToken(HttpResponse paramHttpResponse) {
        this(paramHttpResponse.asString());
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof OAuthToken)) {
                return false;
            }
            paramObject = (OAuthToken) paramObject;
            if (!this.token.equals(((OAuthToken) paramObject).token)) {
                return false;
            }
        } while (this.tokenSecret.equals(((OAuthToken) paramObject).tokenSecret));
        return false;
    }

    public String getParameter(String paramString) {
        Object localObject2 = null;
        String[] arrayOfString = this.responseStr;
        int j = arrayOfString.length;
        int i = 0;
        for (; ; ) {
            Object localObject1 = localObject2;
            if (i < j) {
                localObject1 = arrayOfString[i];
                if (((String) localObject1).startsWith(paramString + '=')) {
                    localObject1 = localObject1.split("=")[1].trim();
                }
            } else {
                return (String) localObject1;
            }
            i += 1;
        }
    }

    SecretKeySpec getSecretKeySpec() {
        return this.secretKeySpec;
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    public int hashCode() {
        return this.token.hashCode() * 31 + this.tokenSecret.hashCode();
    }

    void setSecretKeySpec(SecretKeySpec paramSecretKeySpec) {
        this.secretKeySpec = paramSecretKeySpec;
    }

    public String toString() {
        return "OAuthToken{token='" + this.token + '\'' + ", tokenSecret='" + this.tokenSecret + '\'' + ", secretKeySpec=" + this.secretKeySpec + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/auth/OAuthToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */