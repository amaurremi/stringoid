package com.everimaging.fotorsdk.http;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class a {
    private int a = 10;
    private int b = 10000;
    private final DefaultHttpClient c;
    private final HttpContext d;
    private ExecutorService e;
    private final Map<Context, List<k>> f;
    private final Map<String, String> g;
    private boolean h = true;

    public a() {
        this(false, 80, 443);
    }

    public a(SchemeRegistry paramSchemeRegistry) {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(localBasicHttpParams, this.b);
        ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(this.a));
        ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, this.b);
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, this.b);
        HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(localBasicHttpParams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[]{"1.4.5"}));
        paramSchemeRegistry = new ThreadSafeClientConnManager(localBasicHttpParams, paramSchemeRegistry);
        this.e = Executors.newCachedThreadPool();
        this.f = new WeakHashMap();
        this.g = new HashMap();
        this.d = new SyncBasicHttpContext(new BasicHttpContext());
        this.c = new DefaultHttpClient(paramSchemeRegistry, localBasicHttpParams);
        this.c.addRequestInterceptor(new HttpRequestInterceptor() {
            public void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext) {
                if (!paramAnonymousHttpRequest.containsHeader("Accept-Encoding")) {
                    paramAnonymousHttpRequest.addHeader("Accept-Encoding", "gzip");
                }
                paramAnonymousHttpContext = a.a(a.this).keySet().iterator();
                while (paramAnonymousHttpContext.hasNext()) {
                    String str = (String) paramAnonymousHttpContext.next();
                    if (paramAnonymousHttpRequest.containsHeader(str)) {
                        Header localHeader = paramAnonymousHttpRequest.getFirstHeader(str);
                        Log.d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[]{str, a.a(a.this).get(str), localHeader.getName(), localHeader.getValue()}));
                    }
                    paramAnonymousHttpRequest.addHeader(str, (String) a.a(a.this).get(str));
                }
            }
        });
        this.c.addResponseInterceptor(new HttpResponseInterceptor() {
            public void process(HttpResponse paramAnonymousHttpResponse, HttpContext paramAnonymousHttpContext) {
                paramAnonymousHttpContext = paramAnonymousHttpResponse.getEntity();
                if (paramAnonymousHttpContext == null) {
                }
                for (; ; ) {
                    return;
                    Object localObject = paramAnonymousHttpContext.getContentEncoding();
                    if (localObject != null) {
                        localObject = ((Header) localObject).getElements();
                        int j = localObject.length;
                        int i = 0;
                        while (i < j) {
                            if (localObject[i].getName().equalsIgnoreCase("gzip")) {
                                paramAnonymousHttpResponse.setEntity(new a.a(paramAnonymousHttpContext));
                                return;
                            }
                            i += 1;
                        }
                    }
                }
            }
        });
        this.c.addRequestInterceptor(new HttpRequestInterceptor() {
            public void process(HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
                    throws HttpException, IOException {
                paramAnonymousHttpRequest = (AuthState) paramAnonymousHttpContext.getAttribute("http.auth.target-scope");
                CredentialsProvider localCredentialsProvider = (CredentialsProvider) paramAnonymousHttpContext.getAttribute("http.auth.credentials-provider");
                paramAnonymousHttpContext = (HttpHost) paramAnonymousHttpContext.getAttribute("http.target_host");
                if (paramAnonymousHttpRequest.getAuthScheme() == null) {
                    paramAnonymousHttpContext = localCredentialsProvider.getCredentials(new AuthScope(paramAnonymousHttpContext.getHostName(), paramAnonymousHttpContext.getPort()));
                    if (paramAnonymousHttpContext != null) {
                        paramAnonymousHttpRequest.setAuthScheme(new BasicScheme());
                        paramAnonymousHttpRequest.setCredentials(paramAnonymousHttpContext);
                    }
                }
            }
        }, 0);
        this.c.setHttpRequestRetryHandler(new n(5, 1500));
    }

    public a(boolean paramBoolean, int paramInt1, int paramInt2) {
        this(a(paramBoolean, paramInt1, paramInt2));
    }

    public static String a(boolean paramBoolean, String paramString, l paraml) {
        if (paramBoolean) {
            paramString = paramString.replace(" ", "%20");
        }
        for (; ; ) {
            Object localObject = paramString;
            if (paraml != null) {
                paraml = paraml.b().trim();
                localObject = paramString;
                if (!paraml.equals("")) {
                    localObject = paramString;
                    if (!paraml.equals("?")) {
                        localObject = new StringBuilder().append(paramString);
                        if (!paramString.contains("?")) {
                            break label103;
                        }
                    }
                }
            }
            label103:
            for (paramString = "&"; ; paramString = "?") {
                paramString = paramString;
                localObject = paramString + paraml;
                return (String) localObject;
            }
        }
    }

    private HttpEntity a(l paraml, m paramm) {
        HttpEntity localHttpEntity = null;
        if (paraml != null) {
        }
        try {
            localHttpEntity = paraml.a(paramm);
            return localHttpEntity;
        } catch (Throwable paraml) {
            if (paramm != null) {
                paramm.b(0, null, null, paraml);
                return null;
            }
            paraml.printStackTrace();
        }
        return null;
    }

    private HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, HttpEntity paramHttpEntity) {
        if (paramHttpEntity != null) {
            paramHttpEntityEnclosingRequestBase.setEntity(paramHttpEntity);
        }
        return paramHttpEntityEnclosingRequestBase;
    }

    private static SchemeRegistry a(boolean paramBoolean, int paramInt1, int paramInt2) {
        if (paramBoolean) {
            Log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        int i = paramInt1;
        if (paramInt1 < 1) {
            i = 80;
            Log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        paramInt1 = paramInt2;
        if (paramInt2 < 1) {
            paramInt1 = 443;
            Log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        if (paramBoolean) {
        }
        for (SSLSocketFactory localSSLSocketFactory = i.b(); ; localSSLSocketFactory = SSLSocketFactory.getSocketFactory()) {
            SchemeRegistry localSchemeRegistry = new SchemeRegistry();
            localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i));
            localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, paramInt1));
            return localSchemeRegistry;
        }
    }

    public static void a(InputStream paramInputStream) {
        if (paramInputStream != null) {
        }
        try {
            paramInputStream.close();
            return;
        } catch (IOException paramInputStream) {
            Log.w("AsyncHttpClient", "Cannot close input stream", paramInputStream);
        }
    }

    public static void a(OutputStream paramOutputStream) {
        if (paramOutputStream != null) {
        }
        try {
            paramOutputStream.close();
            return;
        } catch (IOException paramOutputStream) {
            Log.w("AsyncHttpClient", "Cannot close output stream", paramOutputStream);
        }
    }

    public k a(Context paramContext, String paramString, l paraml, m paramm) {
        return a(this.c, this.d, new HttpGet(a(this.h, paramString, paraml)), null, paramm, paramContext);
    }

    public k a(Context paramContext, String paramString1, HttpEntity paramHttpEntity, String paramString2, m paramm) {
        return a(this.c, this.d, a(new HttpPost(URI.create(paramString1).normalize()), paramHttpEntity), paramString2, paramm, paramContext);
    }

    public k a(String paramString, l paraml, m paramm) {
        return a(null, paramString, paraml, paramm);
    }

    protected k a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, m paramm, Context paramContext) {
        if (paramHttpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        }
        if (paramm == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        }
        if (paramm.a()) {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
        if (paramString != null) {
            paramHttpUriRequest.setHeader("Content-Type", paramString);
        }
        paramm.a(paramHttpUriRequest.getAllHeaders());
        paramm.a(paramHttpUriRequest.getURI());
        paramDefaultHttpClient = new b(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramm);
        this.e.submit(paramDefaultHttpClient);
        paramString = new k(paramDefaultHttpClient);
        if (paramContext != null) {
            paramHttpContext = (List) this.f.get(paramContext);
            paramDefaultHttpClient = paramHttpContext;
            if (paramHttpContext == null) {
                paramDefaultHttpClient = new LinkedList();
                this.f.put(paramContext, paramDefaultHttpClient);
            }
            if ((paramm instanceof j)) {
                ((j) paramm).a(paramHttpUriRequest);
            }
            paramDefaultHttpClient.add(paramString);
            paramDefaultHttpClient = paramDefaultHttpClient.iterator();
            while (paramDefaultHttpClient.hasNext()) {
                if (((k) paramDefaultHttpClient.next()).c()) {
                    paramDefaultHttpClient.remove();
                }
            }
        }
        return paramString;
    }

    public void a(int paramInt) {
        int i = paramInt;
        if (paramInt < 1000) {
            i = 10000;
        }
        this.b = i;
        HttpParams localHttpParams = this.c.getParams();
        ConnManagerParams.setTimeout(localHttpParams, this.b);
        HttpConnectionParams.setSoTimeout(localHttpParams, this.b);
        HttpConnectionParams.setConnectionTimeout(localHttpParams, this.b);
    }

    public void a(int paramInt1, int paramInt2) {
        this.c.setHttpRequestRetryHandler(new n(paramInt1, paramInt2));
    }

    public k b(Context paramContext, String paramString, l paraml, m paramm) {
        return a(paramContext, paramString, a(paraml, paramm), null, paramm);
    }

    public k b(String paramString, l paraml, m paramm) {
        return b(null, paramString, paraml, paramm);
    }

    private static class a
            extends HttpEntityWrapper {
        public a(HttpEntity paramHttpEntity) {
            super();
        }

        public InputStream getContent()
                throws IOException {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }

        public long getContentLength() {
            return -1L;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */