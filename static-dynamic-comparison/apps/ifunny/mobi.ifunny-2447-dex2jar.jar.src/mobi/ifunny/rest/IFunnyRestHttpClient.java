package mobi.ifunny.rest;

import android.support.v4.app.k;

import java.util.HashMap;
import java.util.Map;

import mobi.ifunny.d.c;
import mobi.ifunny.d.e;
import mobi.ifunny.l.h;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class IFunnyRestHttpClient {
    private static final int DEFAULT_MAX_CONNECTIONS = 10;
    private static final int DEFAULT_MAX_RETRIES = 5;
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final int DEFAULT_SOCKET_TIMEOUT = 60000;
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    static final String TAG = IFunnyRestHttpClient.class.getSimpleName();
    private static final Map<String, String> clientHeaderMap;
    private static final DefaultHttpClient httpClient;
    private static final HttpContext httpContext;

    static {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(localBasicHttpParams, 60000L);
        ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
        HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(localBasicHttpParams, "mobi.ifunny/android");
        Object localObject = new SchemeRegistry();
        ((SchemeRegistry) localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry) localObject).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry) localObject);
        httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        httpClient = new DefaultHttpClient((ClientConnectionManager) localObject, localBasicHttpParams);
        httpClient.addRequestInterceptor(new IFunnyRestHttpClient .1 ());
        httpClient.addResponseInterceptor(new IFunnyRestHttpClient .2 ());
        httpClient.setHttpRequestRetryHandler(new IFunnyHttpRetryHandler(5));
        clientHeaderMap = new HashMap();
        addHeader("Cache-Control", "no-cache");
    }

    public static void addHeader(String paramString1, String paramString2) {
        clientHeaderMap.put(paramString1, paramString2);
    }

    static <T extends h> void get(k paramk, T paramT, String paramString1, String paramString2, c paramc, RestHttpHandler<String, T> paramRestHttpHandler) {
        new e(paramk, paramT, paramString1, httpClient, httpContext, "GET", paramString2, paramc, paramRestHttpHandler).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/IFunnyRestHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */