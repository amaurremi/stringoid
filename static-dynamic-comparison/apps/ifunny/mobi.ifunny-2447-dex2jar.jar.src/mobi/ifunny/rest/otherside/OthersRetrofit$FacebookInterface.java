package mobi.ifunny.rest.otherside;

import retrofit.http.GET;
import retrofit.http.Path;

abstract interface OthersRetrofit$FacebookInterface {
    @GET("/{id}")
    public abstract FacebookShareCounters getCounters(@Path("id") String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/otherside/OthersRetrofit$FacebookInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */