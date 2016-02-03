package com.amazon.device.ads;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class de
        extends hy {
    private static final String m = de.class.getSimpleName();

    private void a(HttpPost paramHttpPost) {
        Object localObject2 = this.d;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = "UTF-8";
        }
        String str = this.c;
        localObject2 = str;
        if (str == null) {
            localObject2 = "text/plain";
        }
        if (this.a != null) {
            a(paramHttpPost, (String) localObject2, (String) localObject1);
            return;
        }
        a(paramHttpPost, (String) localObject1);
    }

    private void a(HttpPost paramHttpPost, String paramString) {
        paramString = new ArrayList();
        Iterator localIterator = this.g.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            paramString.add(new BasicNameValuePair((String) localEntry.getKey(), (String) localEntry.getValue()));
        }
        try {
            paramHttpPost.setEntity(new UrlEncodedFormEntity(paramString, "UTF-8"));
            return;
        } catch (UnsupportedEncodingException paramHttpPost) {
            dv.b(n(), "Unsupported character encoding used while creating the request: %s", new Object[]{paramHttpPost.getMessage()});
            throw new ic(this, ie.e, "Unsupported character encoding used while creating the request", paramHttpPost);
        }
    }

    private void a(HttpPost paramHttpPost, String paramString1, String paramString2) {
        try {
            paramString2 = new StringEntity(this.a, paramString2);
            paramString2.setContentType(paramString1);
            paramHttpPost.setEntity(paramString2);
            return;
        } catch (UnsupportedEncodingException paramHttpPost) {
            dv.b(n(), "Unsupported character encoding used while creating the request. ", new Object[]{paramHttpPost.getMessage()});
            throw new ic(this, ie.e, "Unsupported character encoding used while creating the request.", paramHttpPost);
        }
    }

    protected if

    a(URL paramURL) {
        paramURL = b(paramURL);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(a());
        try {
            paramURL = localDefaultHttpClient.execute(paramURL);
            return a(paramURL);
        } catch (ClientProtocolException paramURL) {
            dv.b(n(), "Invalid client protocol: %s", new Object[]{paramURL.getMessage()});
            throw new ic(this, ie.d, "Invalid client protocol", paramURL);
        } catch (IOException paramURL) {
            dv.b(n(), "IOException during client execution: %s", new Object[]{paramURL.getMessage()});
            throw new ic(this, ie.a, "IOException during client execution", paramURL);
        }
    }

    protected if

    a(HttpResponse paramHttpResponse) {
        if localif = new if (this) ;
        localif.b(n());
        localif.a(this.i);
        localif.a(paramHttpResponse.getStatusLine().getStatusCode());
        localif.c(paramHttpResponse.getStatusLine().getReasonPhrase());
        if (localif.d() == 200) {
            paramHttpResponse = paramHttpResponse.getEntity();
            if ((paramHttpResponse == null) || (paramHttpResponse.getContentLength() == 0L)) {
            }
        }
        try {
            localif.a(paramHttpResponse.getContent());
            return localif;
        } catch (IOException paramHttpResponse) {
            dv.b(n(), "IOException while reading the input stream from response: %s", new Object[]{paramHttpResponse.getMessage()});
            throw new ic(this, ie.a, "IOException while reading the input stream from response", paramHttpResponse);
        }
    }

    protected HttpParams a() {
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, m());
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, m());
        HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
        return localBasicHttpParams;
    }

    protected String b() {
        return m;
    }

    protected HttpRequestBase b(URL paramURL) {
        URI localURI;
        for (; ; ) {
            try {
                localURI = c(paramURL);
                switch (df.a[f().ordinal()]) {
                    default:
                        paramURL = null;
                        Iterator localIterator = this.e.entrySet().iterator();
                        if (!localIterator.hasNext()) {
                            break;
                        }
                        Map.Entry localEntry = (Map.Entry) localIterator.next();
                        if ((localEntry.getValue() == null) || (((String) localEntry.getValue()).equals(""))) {
                            continue;
                        }
                        paramURL.addHeader((String) localEntry.getKey(), (String) localEntry.getValue());
                        break;
                    case 1:
                        paramURL = new HttpGet(localURI);
                }
            } catch (URISyntaxException paramURL) {
                dv.b(n(), "Problem with URI syntax: %s", new Object[]{paramURL.getMessage()});
                throw new ic(this, ie.c, "Problem with URI syntax", paramURL);
            }
            continue;
            paramURL = new HttpPost(localURI);
            a((HttpPost) paramURL);
        }
        a(localURI.toString());
        if ((this.h) && (l() != null)) {
            dv.a(n(), "Request Body: %s", new Object[]{l()});
        }
        return paramURL;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */