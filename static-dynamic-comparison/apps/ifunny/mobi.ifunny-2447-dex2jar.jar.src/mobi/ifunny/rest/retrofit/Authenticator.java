package mobi.ifunny.rest.retrofit;

import android.text.TextUtils;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import mobi.ifunny.social.auth.l;
import mobi.ifunny.social.auth.m;
import mobi.ifunny.util.z;

public class Authenticator
        implements m {
    private static final String clientId = "MsOIJ39Q28";
    private static final String clientSecret = "PTDc3H8a)Vi=UYap";
    private final String basicAuthenticator = createBasicAuthenticator(paramString);
    private String bearerAuthenticator = createBearerAuthenticator(paraml);

    public Authenticator(String paramString, l paraml) {
    }

    private String createBasicAuthenticator(String paramString) {
        try {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append('_');
            localStringBuilder.append("MsOIJ39Q28");
            localStringBuilder.append(':');
            localStringBuilder.append(z.b(paramString + ":" + "MsOIJ39Q28" + ":" + "PTDc3H8a)Vi=UYap").toLowerCase());
            paramString = Base64.encodeToString(localStringBuilder.toString().getBytes("UTF-8"), 2);
            paramString = "Basic " + paramString;
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
            return null;
        } catch (NoSuchAlgorithmException paramString) {
        }
        return null;
    }

    private String createBearerAuthenticator(l paraml) {
        if ((paraml == null) || (!paraml.h())) {
            return null;
        }
        return "Bearer " + paraml.b();
    }

    public String getAuthenticator() {
        l locall = l.a();
        if ((locall == null) || (!locall.h()) || (TextUtils.isEmpty(this.bearerAuthenticator))) {
            return getBasicAuthenticator();
        }
        return getBearerAuthenticator();
    }

    public String getBasicAuthenticator() {
        return this.basicAuthenticator;
    }

    public String getBearerAuthenticator() {
        return this.bearerAuthenticator;
    }

    public void onSessionUpdate(l paraml) {
        this.bearerAuthenticator = createBearerAuthenticator(paraml);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/Authenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */