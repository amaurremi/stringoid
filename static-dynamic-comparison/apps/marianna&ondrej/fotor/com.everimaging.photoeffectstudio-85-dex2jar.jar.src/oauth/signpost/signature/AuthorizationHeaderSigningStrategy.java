package oauth.signpost.signature;

import java.util.Iterator;
import java.util.Set;

import oauth.signpost.http.HttpParameters;

public class AuthorizationHeaderSigningStrategy
        implements SigningStrategy {
    public String writeSignature(String paramString, oauth.signpost.http.a parama, HttpParameters paramHttpParameters) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OAuth ");
        if (paramHttpParameters.containsKey("realm")) {
            localStringBuilder.append(paramHttpParameters.getAsHeaderElement("realm"));
            localStringBuilder.append(", ");
        }
        paramHttpParameters = paramHttpParameters.getOAuthParameters();
        paramHttpParameters.put("oauth_signature", paramString, true);
        paramString = paramHttpParameters.keySet().iterator();
        while (paramString.hasNext()) {
            localStringBuilder.append(paramHttpParameters.getAsHeaderElement((String) paramString.next()));
            if (paramString.hasNext()) {
                localStringBuilder.append(", ");
            }
        }
        paramString = localStringBuilder.toString();
        oauth.signpost.a.a("Auth Header", paramString);
        parama.a("Authorization", paramString);
        return paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/signature/AuthorizationHeaderSigningStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */