package com.everimaging.fotorsdk.http;

import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class b
        implements Runnable {
    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final m d;
    private int e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    public b(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, m paramm) {
        this.a = paramAbstractHttpClient;
        this.b = paramHttpContext;
        this.c = paramHttpUriRequest;
        this.d = paramm;
    }

    private void c()
            throws IOException {
        if (a()) {
        }
        HttpResponse localHttpResponse;
        do {
            return;
            if (this.c.getURI().getScheme() == null) {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            localHttpResponse = this.a.execute(this.c, this.b);
        } while ((a()) || (this.d == null));
        this.d.a(localHttpResponse);
    }

    private void d()
            throws IOException {
        Object localObject = null;
        HttpRequestRetryHandler localHttpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
        int j = 1;
        if (j != 0) {
        }
        label298:
        for (; ; ) {
            try {
                c();
                return;
            } catch (UnknownHostException localUnknownHostException) {
                IOException localIOException1 = new IOException("UnknownHostException exception: " + localUnknownHostException.getMessage());
                if (this.e > 0) {
                    i = this.e + 1;
                    this.e = i;
                    if (localHttpRequestRetryHandler.retryRequest(localIOException1, i, this.b)) {
                        bool = true;
                        break label298;
                        localObject = localIOException1;
                        j = bool;
                        if (!bool) {
                            break;
                        }
                        localObject = localIOException1;
                        j = bool;
                        if (this.d == null) {
                            break;
                        }
                        this.d.b(this.e);
                        localObject = localIOException1;
                        j = bool;
                        break;
                    }
                }
            } catch (Exception localException) {
                Log.e("AsyncHttpRequest", "Unhandled exception origin cause", localException);
                localObject = new IOException("Unhandled exception: " + localException.getMessage());
                throw ((Throwable) localObject);
                bool = false;
            } catch (NullPointerException localNullPointerException) {
                IOException localIOException2 = new IOException("NPE in HttpClient: " + localNullPointerException.getMessage());
                i = this.e + 1;
                this.e = i;
                bool = localHttpRequestRetryHandler.retryRequest(localIOException2, i, this.b);
            } catch (IOException localIOException3) {
                int i;
                boolean bool;
                if (!a()) {
                    i = this.e + 1;
                    this.e = i;
                    bool = localHttpRequestRetryHandler.retryRequest(localIOException3, i, this.b);
                }
            }
        }
    }

    private void e() {
        try {
            if ((!this.h) && (this.f) && (!this.g)) {
                this.g = true;
                if (this.d != null) {
                    this.d.h();
                }
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean a() {
        if (this.f) {
            e();
        }
        return this.f;
    }

    public boolean a(boolean paramBoolean) {
        this.f = true;
        if ((paramBoolean) && (this.c != null) && (!this.c.isAborted())) {
            this.c.abort();
        }
        return a();
    }

    public boolean b() {
        return (a()) || (this.h);
    }

    public void run() {
        if (a()) {
        }
        for (; ; ) {
            return;
            if (this.d != null) {
                this.d.f();
            }
            if (a()) {
                continue;
            }
            try {
                d();
                if (a()) {
                    continue;
                }
                if (this.d != null) {
                    this.d.g();
                }
                this.h = true;
                return;
            } catch (IOException localIOException) {
                for (; ; ) {
                    if ((!a()) && (this.d != null)) {
                        this.d.b(0, null, null, localIOException);
                    } else {
                        Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", localIOException);
                    }
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */