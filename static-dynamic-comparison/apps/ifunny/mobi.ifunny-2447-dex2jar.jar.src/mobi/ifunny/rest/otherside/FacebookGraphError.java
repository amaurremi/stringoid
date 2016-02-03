package mobi.ifunny.rest.otherside;

import mobi.ifunny.rest.content.RestError.RestErrorProxy;

public class FacebookGraphError
        implements RestError.RestErrorProxy {
    public int code;
    public int error_subcode;
    public String message;
    public String type;

    public int getCode() {
        return this.code;
    }

    public String getError() {
        return this.type;
    }

    public String getErrorMessage() {
        return this.message;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/otherside/FacebookGraphError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */