package com.facebook;

public class FacebookServiceException
        extends FacebookException {
    private static final long serialVersionUID = 1L;
    private final FacebookRequestError error;

    public FacebookServiceException(FacebookRequestError paramFacebookRequestError, String paramString) {
        super(paramString);
        this.error = paramFacebookRequestError;
    }

    public final FacebookRequestError getRequestError() {
        return this.error;
    }

    public final String toString() {
        return "{FacebookServiceException: " + "httpResponseCode: " + this.error.getRequestStatusCode() + ", facebookErrorCode: " + this.error.getErrorCode() + ", facebookErrorType: " + this.error.getErrorType() + ", message: " + this.error.getErrorMessage() + "}";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/FacebookServiceException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */