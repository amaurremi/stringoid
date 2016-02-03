package mobi.ifunny.rest.retrofit;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.gson.ExclusionStrategy;
import com.google.gson.GsonBuilder;
import mobi.ifunny.b;
import mobi.ifunny.rest.content.LoadingHelper;
import mobi.ifunny.rest.gson.IFunnyExcludeStrategy;
import retrofit.Endpoints;
import retrofit.converter.Converter;

public class RestAdapterFactory {
    private static final String SERVER_URL = "https://api.ifunny.mobi/v3";
    private static final String SERVER_URL_DEFAULT = "https://api.ifunny.mobi/v3";

    public static BaseRestAdapter createAdapter(BaseRestAdapter.Builder paramBuilder) {
        return paramBuilder.build();
    }

    public static BaseRestAdapter createAuthRequestAdapter(Context paramContext, Authenticator paramAuthenticator) {
        Object localObject = new GsonBuilder();
        ((GsonBuilder) localObject).setExclusionStrategies(new ExclusionStrategy[]{new IFunnyExcludeStrategy(new Class[]{LoadingHelper.class, Void.class})});
        localObject = new IFunnyGsonConverter(((GsonBuilder) localObject).create());
        String str1 = getServerUrl(paramContext);
        String str2 = Retrofit.userAgent();
        return createAdapter(new BaseRestAdapter.Builder(paramContext).setEndpoint(Endpoints.newFixedEndpoint(str1)).setAuthenticator(new RestAdapterFactory
        .2 (paramAuthenticator)).
        setAcceptHeader("application/json").setUserAgent(str2).setConverter((Converter) localObject));
    }

    public static BaseRestAdapter createIFunnyRequestAdapter(Context paramContext, Authenticator paramAuthenticator) {
        Object localObject = new GsonBuilder();
        ((GsonBuilder) localObject).setExclusionStrategies(new ExclusionStrategy[]{new IFunnyExcludeStrategy(new Class[]{LoadingHelper.class, Void.class})});
        localObject = new IFunnyGsonConverter(((GsonBuilder) localObject).create());
        String str1 = Retrofit.userAgent();
        String str2 = getServerUrl(paramContext);
        return createAdapter(new BaseRestAdapter.Builder(paramContext).setEndpoint(Endpoints.newFixedEndpoint(str2)).setAuthenticator(new RestAdapterFactory
        .1 (paramAuthenticator)).
        setAcceptHeader("application/json,image/webp").setUserAgent(str1).setConverter((Converter) localObject));
    }

    private static String getServerUrl(Context paramContext) {
        if (b.a == null) {
        }
        for (String str = "https://api.ifunny.mobi/v3"; ; str = b.a) {
            if (!TextUtils.equals(str, "https://api.ifunny.mobi/v3")) {
                Toast.makeText(paramContext, "Build set to a non default server url\n" + str, 1).show();
            }
            return str;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/RestAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */