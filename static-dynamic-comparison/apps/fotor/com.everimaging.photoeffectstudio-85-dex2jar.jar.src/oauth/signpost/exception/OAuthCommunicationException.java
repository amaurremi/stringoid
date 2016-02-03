package oauth.signpost.exception;

public class OAuthCommunicationException
        extends OAuthException {
    public OAuthCommunicationException(Exception paramException) {
        super("Communication with the service provider failed: " + paramException.getLocalizedMessage(), paramException);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/oauth/signpost/exception/OAuthCommunicationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */