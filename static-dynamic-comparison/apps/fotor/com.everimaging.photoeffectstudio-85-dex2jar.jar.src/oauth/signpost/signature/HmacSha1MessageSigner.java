package oauth.signpost.signature;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpParameters;

public class HmacSha1MessageSigner
        extends OAuthMessageSigner {
    public String getSignatureMethod() {
        return "HMAC-SHA1";
    }

    public String sign(oauth.signpost.http.a parama, HttpParameters paramHttpParameters)
            throws OAuthMessageSignerException {
        try {
            SecretKeySpec localSecretKeySpec = new SecretKeySpec((oauth.signpost.a.a(getConsumerSecret()) + '&' + oauth.signpost.a.a(getTokenSecret())).getBytes("UTF-8"), "HmacSHA1");
            Mac localMac = Mac.getInstance("HmacSHA1");
            localMac.init(localSecretKeySpec);
            parama = new a(parama, paramHttpParameters).a();
            oauth.signpost.a.a("SBS", parama);
            parama = base64Encode(localMac.doFinal(parama.getBytes("UTF-8"))).trim();
            return parama;
        } catch (GeneralSecurityException parama) {
            throw new OAuthMessageSignerException(parama);
        } catch (UnsupportedEncodingException parama) {
            throw new OAuthMessageSignerException(parama);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/signature/HmacSha1MessageSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */