package mobi.ifunny.rest.otherside;

import mobi.ifunny.rest.content.RestError.RestErrorProxy;

public class TwitterRestError
        implements RestError.RestErrorProxy {
    public String error;

    public int getCode() {
        return 0;
    }

    public String getError() {
        return this.error;
    }

    public String getErrorMessage() {
        return this.error;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/otherside/TwitterRestError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */