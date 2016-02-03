package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class da
        implements ab {
    private final Context aac;
    private final String aat;
    private final HttpClient aau;
    private a aav;

    da(HttpClient paramHttpClient, Context paramContext, a parama) {
        this.aac = paramContext.getApplicationContext();
        this.aat = a("GoogleTagManager", "4.00", Build.VERSION.RELEASE, b(Locale.getDefault()), Build.MODEL, Build.ID);
        this.aau = paramHttpClient;
        this.aav = parama;
    }

    private HttpEntityEnclosingRequest a(URL paramURL) {
        try {
            paramURL = new BasicHttpEntityEnclosingRequest("GET", paramURL.toURI().toString());
            bh.z("Exception sending hit: " + localURISyntaxException1.getClass().getSimpleName());
        } catch (URISyntaxException localURISyntaxException1) {
            try {
                paramURL.addHeader("User-Agent", this.aat);
                return paramURL;
            } catch (URISyntaxException localURISyntaxException2) {
                for (; ; ) {
                }
            }
            localURISyntaxException1 = localURISyntaxException1;
            paramURL = null;
        }
        bh.z(localURISyntaxException1.getMessage());
        return paramURL;
    }

    private void a(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) {
        StringBuffer localStringBuffer = new StringBuffer();
        Object localObject = paramHttpEntityEnclosingRequest.getAllHeaders();
        int j = localObject.length;
        int i = 0;
        while (i < j) {
            localStringBuffer.append(localObject[i].toString()).append("\n");
            i += 1;
        }
        localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (paramHttpEntityEnclosingRequest.getEntity() != null) {
        }
        try {
            paramHttpEntityEnclosingRequest = paramHttpEntityEnclosingRequest.getEntity().getContent();
            if (paramHttpEntityEnclosingRequest != null) {
                i = paramHttpEntityEnclosingRequest.available();
                if (i > 0) {
                    localObject = new byte[i];
                    paramHttpEntityEnclosingRequest.read((byte[]) localObject);
                    localStringBuffer.append("POST:\n");
                    localStringBuffer.append(new String((byte[]) localObject)).append("\n");
                }
            }
        } catch (IOException paramHttpEntityEnclosingRequest) {
            for (; ; ) {
                bh.y("Error Writing hit to log...");
            }
        }
        bh.y(localStringBuffer.toString());
    }

    static String b(Locale paramLocale) {
        if (paramLocale == null) {
        }
        while ((paramLocale.getLanguage() == null) || (paramLocale.getLanguage().length() == 0)) {
            return null;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
        if ((paramLocale.getCountry() != null) && (paramLocale.getCountry().length() != 0)) {
            localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
        }
        return localStringBuilder.toString();
    }

    String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{paramString1, paramString2, paramString3, paramString4, paramString5, paramString6});
    }

    public boolean ch() {
        NetworkInfo localNetworkInfo = ((ConnectivityManager) this.aac.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
            bh.y("...no network connectivity");
            return false;
        }
        return true;
    }

    URL d(ap paramap) {
        paramap = paramap.kE();
        try {
            paramap = new URL(paramap);
            return paramap;
        } catch (MalformedURLException paramap) {
            bh.w("Error trying to parse the GTM url.");
        }
        return null;
    }

    public void d(List<ap> paramList) {
        int n = Math.min(paramList.size(), 40);
        int i = 1;
        int m = 0;
        ap localap;
        Object localObject2;
        if (m < n) {
            localap = (ap) paramList.get(m);
            localObject2 = d(localap);
            if (localObject2 == null) {
                bh.z("No destination: discarding hit.");
                this.aav.b(localap);
            }
        }
        for (; ; ) {
            m += 1;
            break;
            Object localObject1 = a((URL) localObject2);
            if (localObject1 == null) {
                this.aav.b(localap);
            } else {
                localObject2 = new HttpHost(((URL) localObject2).getHost(), ((URL) localObject2).getPort(), ((URL) localObject2).getProtocol());
                ((HttpEntityEnclosingRequest) localObject1).addHeader("Host", ((HttpHost) localObject2).toHostString());
                a((HttpEntityEnclosingRequest) localObject1);
                int j = i;
                int k;
                if (i != 0) {
                    k = i;
                }
                try {
                    bn.p(this.aac);
                    j = 0;
                    k = j;
                    i = j;
                    localObject1 = this.aau.execute((HttpHost) localObject2, (HttpRequest) localObject1);
                    k = j;
                    i = j;
                    int i1 = ((HttpResponse) localObject1).getStatusLine().getStatusCode();
                    k = j;
                    i = j;
                    localObject2 = ((HttpResponse) localObject1).getEntity();
                    if (localObject2 != null) {
                        k = j;
                        i = j;
                        ((HttpEntity) localObject2).consumeContent();
                    }
                    if (i1 != 200) {
                        k = j;
                        i = j;
                        bh.z("Bad response: " + ((HttpResponse) localObject1).getStatusLine().getStatusCode());
                        k = j;
                        i = j;
                        this.aav.c(localap);
                    } else {
                        k = j;
                        i = j;
                        this.aav.a(localap);
                    }
                } catch (ClientProtocolException localClientProtocolException) {
                    bh.z("ClientProtocolException sending hit; discarding hit...");
                    this.aav.b(localap);
                    i = k;
                    continue;
                } catch (IOException localIOException) {
                    bh.z("Exception sending hit: " + localIOException.getClass().getSimpleName());
                    bh.z(localIOException.getMessage());
                    this.aav.c(localap);
                }
                continue;
                return;
                i = j;
            }
        }
    }

    public static abstract interface a {
        public abstract void a(ap paramap);

        public abstract void b(ap paramap);

        public abstract void c(ap paramap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */