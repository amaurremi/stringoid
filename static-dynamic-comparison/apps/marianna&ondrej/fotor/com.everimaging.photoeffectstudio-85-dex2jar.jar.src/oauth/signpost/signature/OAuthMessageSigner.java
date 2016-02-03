package oauth.signpost.signature;

import java.io.Serializable;

import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpParameters;

public abstract class OAuthMessageSigner
        implements Serializable {
    private transient org.a.a.a.a.a base64 = new org.a.a.a.a.a();
    private String consumerSecret;
    private String tokenSecret;

    protected String base64Encode(byte[] paramArrayOfByte) {
        return new String(this.base64.a(paramArrayOfByte));
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public abstract String getSignatureMethod();

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    public void setConsumerSecret(String paramString) {
        this.consumerSecret = paramString;
    }

    public void setTokenSecret(String paramString) {
        this.tokenSecret = paramString;
    }

    public abstract String sign(oauth.signpost.http.a parama, HttpParameters paramHttpParameters)
            throws OAuthMessageSignerException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/signature/OAuthMessageSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */