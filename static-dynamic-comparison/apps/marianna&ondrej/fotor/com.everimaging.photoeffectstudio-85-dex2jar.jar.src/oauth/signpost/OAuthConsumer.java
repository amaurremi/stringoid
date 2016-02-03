package oauth.signpost;

import java.io.Serializable;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.a;

public abstract interface OAuthConsumer
        extends Serializable {
    public abstract void setTokenWithSecret(String paramString1, String paramString2);

    public abstract a sign(Object paramObject)
            throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/OAuthConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */