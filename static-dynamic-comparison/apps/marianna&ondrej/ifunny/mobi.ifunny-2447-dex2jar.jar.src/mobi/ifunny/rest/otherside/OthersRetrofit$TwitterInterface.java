package mobi.ifunny.rest.otherside;

import retrofit.http.GET;
import retrofit.http.Query;

abstract interface OthersRetrofit$TwitterInterface {
    @GET("/urls/count.json")
    public abstract TwitterShareCounters getCounters(@Query("url") String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/otherside/OthersRetrofit$TwitterInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */