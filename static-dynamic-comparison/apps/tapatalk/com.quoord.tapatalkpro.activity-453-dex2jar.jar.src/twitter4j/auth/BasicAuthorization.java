package twitter4j.auth;

import java.io.Serializable;

import twitter4j.internal.http.BASE64Encoder;
import twitter4j.internal.http.HttpRequest;

public class BasicAuthorization
        implements Authorization, Serializable {
    private static final long serialVersionUID = -5861104407848415060L;
    private String basic;
    private String password;
    private String userId;

    public BasicAuthorization(String paramString1, String paramString2) {
        this.userId = paramString1;
        this.password = paramString2;
        this.basic = encodeBasicAuthenticationString();
    }

    private String encodeBasicAuthenticationString() {
        if ((this.userId != null) && (this.password != null)) {
            return "Basic " + BASE64Encoder.encode(new StringBuilder().append(this.userId).append(":").append(this.password).toString().getBytes());
        }
        return null;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
            return true;
        }
        if (!(paramObject instanceof BasicAuthorization)) {
            return false;
        }
        paramObject = (BasicAuthorization) paramObject;
        return this.basic.equals(((BasicAuthorization) paramObject).basic);
    }

    public String getAuthorizationHeader(HttpRequest paramHttpRequest) {
        return this.basic;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.basic.hashCode();
    }

    public boolean isEnabled() {
        return true;
    }

    public String toString() {
        return "BasicAuthorization{userId='" + this.userId + '\'' + ", password='**********''" + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/auth/BasicAuthorization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */