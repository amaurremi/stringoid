package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import twitter4j.HttpResponse;
import twitter4j.JSONException;
import twitter4j.JSONObject;

public class OAuth2Token
        implements Serializable {
    private static final long serialVersionUID = -8985359441959903216L;
    private String accessToken;
    private String tokenType;

    public OAuth2Token(String paramString1, String paramString2) {
        this.tokenType = paramString1;
        this.accessToken = paramString2;
    }

    OAuth2Token(HttpResponse paramHttpResponse) {
        paramHttpResponse = paramHttpResponse.asJSONObject();
        this.tokenType = getRawString("token_type", paramHttpResponse);
        try {
            this.accessToken = URLDecoder.decode(getRawString("access_token", paramHttpResponse), "UTF-8");
            return;
        } catch (UnsupportedEncodingException paramHttpResponse) {
        }
    }

    private static String getRawString(String paramString, JSONObject paramJSONObject) {
        try {
            if (paramJSONObject.isNull(paramString)) {
                return null;
            }
            paramString = paramJSONObject.getString(paramString);
            return paramString;
        } catch (JSONException paramString) {
        }
        return null;
    }

    public boolean equals(Object paramObject) {
        if ((paramObject == null) || (!(paramObject instanceof OAuth2Token))) {
        }
        do {
            do {
                return false;
                paramObject = (OAuth2Token) paramObject;
                if (this.tokenType == null) {
                    break;
                }
            } while (!this.tokenType.equals(((OAuth2Token) paramObject).tokenType));
            if (this.accessToken == null) {
                break label71;
            }
        } while (!this.accessToken.equals(((OAuth2Token) paramObject).accessToken));
        label71:
        while (((OAuth2Token) paramObject).accessToken == null) {
            return true;
            if (((OAuth2Token) paramObject).tokenType == null) {
                break;
            }
            return false;
        }
        return false;
    }

    String generateAuthorizationHeader() {
        Object localObject = "";
        try {
            String str = URLEncoder.encode(this.accessToken, "UTF-8");
            localObject = str;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
            }
        }
        return "Bearer " + (String) localObject;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public int hashCode() {
        int j = 0;
        if (this.tokenType != null) {
        }
        for (int i = this.tokenType.hashCode(); ; i = 0) {
            if (this.accessToken != null) {
                j = this.accessToken.hashCode();
            }
            return i * 31 + j;
        }
    }

    public String toString() {
        return "OAuth2Token{tokenType='" + this.tokenType + '\'' + ", accessToken='" + this.accessToken + '\'' + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/auth/OAuth2Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */