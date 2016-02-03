package twitter4j.auth;

import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;

import twitter4j.TwitterException;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalStringUtil;

abstract class OAuthToken
        implements Serializable {
    private static final long serialVersionUID = 3891133932519746686L;
    String[] responseStr = null;
    private transient SecretKeySpec secretKeySpec;
    private String token;
    private String tokenSecret;

    OAuthToken(String paramString) {
        this.responseStr = z_T4JInternalStringUtil.split(paramString, "&");
        this.tokenSecret = getParameter("oauth_token_secret");
        this.token = getParameter("oauth_token");
    }

    public OAuthToken(String paramString1, String paramString2) {
        this.token = paramString1;
        this.tokenSecret = paramString2;
    }

    OAuthToken(HttpResponse paramHttpResponse)
            throws TwitterException {
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
                    localObject1 = z_T4JInternalStringUtil.split(localObject1, "=")[1].trim();
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/auth/OAuthToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */