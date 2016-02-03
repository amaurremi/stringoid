package retrofit;

import retrofit.client.Response;

public abstract class ResponseCallback
        implements Callback<Response> {
    public abstract void success(Response paramResponse);

    public void success(Response paramResponse1, Response paramResponse2) {
        success(paramResponse1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/ResponseCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */