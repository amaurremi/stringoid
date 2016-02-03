package retrofit.client;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OkClient
        extends UrlConnectionClient {
    private final OkUrlFactory okUrlFactory;

    public OkClient() {
        this(generateDefaultOkHttp());
    }

    public OkClient(OkHttpClient paramOkHttpClient) {
        this.okUrlFactory = new OkUrlFactory(paramOkHttpClient);
    }

    private static OkHttpClient generateDefaultOkHttp() {
        OkHttpClient localOkHttpClient = new OkHttpClient();
        localOkHttpClient.setConnectTimeout(15000L, TimeUnit.MILLISECONDS);
        localOkHttpClient.setReadTimeout(20000L, TimeUnit.MILLISECONDS);
        return localOkHttpClient;
    }

    protected HttpURLConnection openConnection(Request paramRequest) {
        return this.okUrlFactory.open(new URL(paramRequest.getUrl()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/client/OkClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */