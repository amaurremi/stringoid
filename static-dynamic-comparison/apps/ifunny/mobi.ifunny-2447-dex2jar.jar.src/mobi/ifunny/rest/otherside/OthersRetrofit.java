package mobi.ifunny.rest.otherside;

import android.content.Context;
import mobi.ifunny.rest.retrofit.BaseRestAdapter;
import mobi.ifunny.rest.retrofit.BaseRestAdapter.Builder;
import mobi.ifunny.rest.retrofit.RestAdapterFactory;
import retrofit.Endpoints;

public class OthersRetrofit {
    private static final String FACEBOOK_API_SERVER = "http://graph.facebook.com";
    private static final String TWITTER_API_SERVER = "http://cdn.api.twitter.com/1/";
    static OthersRetrofit.FacebookInterface facebook;
    static OthersRetrofit.TwitterInterface twitter;

    public static void init(Context paramContext) {
        BaseRestAdapter.Builder localBuilder = new BaseRestAdapter.Builder(paramContext);
        localBuilder.setEndpoint(Endpoints.newFixedEndpoint("http://graph.facebook.com"));
        facebook = (OthersRetrofit.FacebookInterface) RestAdapterFactory.createAdapter(localBuilder).create(OthersRetrofit.FacebookInterface.class);
        paramContext = new BaseRestAdapter.Builder(paramContext);
        paramContext.setEndpoint(Endpoints.newFixedEndpoint("http://cdn.api.twitter.com/1/"));
        twitter = (OthersRetrofit.TwitterInterface) RestAdapterFactory.createAdapter(paramContext).create(OthersRetrofit.TwitterInterface.class);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/otherside/OthersRetrofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */