package oauth.signpost.signature;

import java.io.Serializable;

import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.a;

public abstract interface SigningStrategy
        extends Serializable {
    public abstract String writeSignature(String paramString, a parama, HttpParameters paramHttpParameters);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/signature/SigningStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */