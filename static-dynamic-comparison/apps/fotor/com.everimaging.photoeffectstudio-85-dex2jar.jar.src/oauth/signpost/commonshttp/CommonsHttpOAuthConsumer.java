package oauth.signpost.commonshttp;

import oauth.signpost.AbstractOAuthConsumer;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

public class CommonsHttpOAuthConsumer
        extends AbstractOAuthConsumer {
    public CommonsHttpOAuthConsumer(String paramString1, String paramString2) {
        super(paramString1, paramString2);
    }

    protected oauth.signpost.http.a wrap(Object paramObject) {
        if (!(paramObject instanceof HttpRequest)) {
            throw new IllegalArgumentException("This consumer expects requests of type " + HttpRequest.class.getCanonicalName());
        }
        return new a((HttpUriRequest) paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/commonshttp/CommonsHttpOAuthConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */