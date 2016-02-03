package retrofit;

import retrofit.client.Response;

public abstract interface Callback<T> {
    public abstract void failure(RetrofitError paramRetrofitError);

    public abstract void success(T paramT, Response paramResponse);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */