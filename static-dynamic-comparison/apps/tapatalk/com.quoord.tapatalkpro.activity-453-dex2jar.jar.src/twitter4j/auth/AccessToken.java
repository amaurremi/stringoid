package twitter4j.auth;

import java.io.Serializable;

import twitter4j.TwitterException;
import twitter4j.internal.http.HttpResponse;

public class AccessToken
        extends OAuthToken
        implements Serializable {
    private static final long serialVersionUID = -8344528374458826291L;
    private String screenName;
    private long userId = -1L;

    AccessToken(String paramString) {
        super(paramString);
        this.screenName = getParameter("screen_name");
        paramString = getParameter("user_id");
        if (paramString != null) {
            this.userId = Long.parseLong(paramString);
        }
    }

    public AccessToken(String paramString1, String paramString2) {
        super(paramString1, paramString2);
        int i = paramString1.indexOf("-");
        if (i != -1) {
            paramString1 = paramString1.substring(0, i);
        }
        try {
            this.userId = Long.parseLong(paramString1);
            return;
        } catch (NumberFormatException paramString1) {
        }
    }

    public AccessToken(String paramString1, String paramString2, long paramLong) {
        super(paramString1, paramString2);
        this.userId = paramLong;
    }

    AccessToken(HttpResponse paramHttpResponse)
            throws TwitterException {
        this(paramHttpResponse.asString());
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            if (!super.equals(paramObject)) {
                return false;
            }
            paramObject = (AccessToken) paramObject;
            if (this.userId != ((AccessToken) paramObject).userId) {
                return false;
            }
            if (this.screenName == null) {
                break;
            }
        } while (this.screenName.equals(((AccessToken) paramObject).screenName));
        for (; ; ) {
            return false;
            if (((AccessToken) paramObject).screenName == null) {
                break;
            }
        }
    }

    public String getScreenName() {
        return this.screenName;
    }

    public long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int j = super.hashCode();
        if (this.screenName != null) {
        }
        for (int i = this.screenName.hashCode(); ; i = 0) {
            return (j * 31 + i) * 31 + (int) (this.userId ^ this.userId >>> 32);
        }
    }

    public String toString() {
        return "AccessToken{screenName='" + this.screenName + '\'' + ", userId=" + this.userId + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/auth/AccessToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */