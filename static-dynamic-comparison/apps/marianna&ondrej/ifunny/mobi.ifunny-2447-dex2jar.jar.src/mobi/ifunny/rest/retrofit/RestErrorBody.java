package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.RestError.RestErrorProxy;

public class RestErrorBody
        implements RestError.RestErrorProxy {
    public String error;
    public String error_description;
    public int status;

    public RestErrorBody() {
    }

    public RestErrorBody(int paramInt, String paramString) {
        this();
        this.status = paramInt;
        this.error = paramString;
    }

    public int getCode() {
        return this.status;
    }

    public String getError() {
        return this.error;
    }

    public String getErrorMessage() {
        return this.error_description;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/RestErrorBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */