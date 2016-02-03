package com.inmobi.commons.network;

import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.abstraction.INetworkListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NetworkRequestTask
        implements Runnable {
    private Request a;
    private INetworkListener b;
    private HttpURLConnection c;

    NetworkRequestTask(Request paramRequest, INetworkListener paramINetworkListener) {
        this.a = paramRequest;
        this.b = paramINetworkListener;
    }

    private HttpURLConnection a(String paramString) {
        paramString = (HttpURLConnection) new URL(paramString).openConnection();
        a(paramString);
        return paramString;
    }

    private void a() {
        localObject4 = null;
        for (; ; ) {
            try {
                Log.debug("[InMobi]-4.5.1", "Http Status Code: " + this.c.getResponseCode());
                int i = this.c.getResponseCode();
                Log.internal("[InMobi]-4.5.1", "Status Code: " + i);
                if (i != 200) {
                }
            } catch (Exception localException) {
                Object localObject1;
                Log.internal("[InMobi]-4.5.1", "Failed to retrieve response", localException);
                localResponse1 = new Response(ErrorCode.CONNECTION_ERROR);
                if (this.b != null) {
                    this.b.onRequestFailed(this.a, localResponse1);
                }
                return;
                localObject4 = ((StringBuilder) localObject4).toString();
                Log.debug("[InMobi]-4.5.1", "Response: " + (String) localObject4);
                localObject4 = new Response((String) localObject4, this.c.getResponseCode(), this.c.getHeaderFields());
                if (this.b != null) {
                    this.b.onRequestSucceded(this.a, (Response) localObject4);
                }
                this.c.disconnect();
                a(localResponse1);
                return;
            } catch (OutOfMemoryError localOutOfMemoryError) {
                Log.internal("[InMobi]-4.5.1", "Out of memory error received while retieving network response", localOutOfMemoryError);
                localObject2 = new Response(ErrorCode.INTERNAL_ERROR);
                if (this.b == null) {
                    continue;
                }
                this.b.onRequestFailed(this.a, (Response) localObject2);
                return;
            }
            try {
                localObject1 = new BufferedReader(new InputStreamReader(this.c.getInputStream(), "UTF-8"));
                try {
                    localObject4 = new StringBuilder();
                    String str = ((BufferedReader) localObject1).readLine();
                    if (str == null) {
                        continue;
                    }
                    ((StringBuilder) localObject4).append(str).append("\n");
                    continue;
                    this.c.disconnect();
                } finally {
                    localObject4 = localObject1;
                    localObject1 = localObject5;
                }
            } finally {
                localObject4 = null;
            }
        }
        a((Closeable) localObject4);
        throw ((Throwable) localObject1);
        for (; ; ) {
            Response localResponse1;
            Response localResponse2 = new Response(null, this.c.getResponseCode(), this.c.getHeaderFields());
            Object localObject2 = localObject4;
            if (this.b != null) {
                this.b.onRequestFailed(this.a, localResponse2);
                localObject2 = localObject4;
            }
        }
    }

    private void a(Closeable paramCloseable) {
        if (paramCloseable != null) {
        }
        try {
            paramCloseable.close();
            return;
        } catch (IOException localIOException) {
            Log.debug("[InMobi]-4.5.1", "Exception closing resource: " + paramCloseable, localIOException);
        }
    }

    private void a(HttpURLConnection paramHttpURLConnection) {
        paramHttpURLConnection.setConnectTimeout(this.a.getTimeout());
        paramHttpURLConnection.setReadTimeout(this.a.getTimeout());
        Object localObject = this.a.getHeaders().keySet().iterator();
        while (((Iterator) localObject).hasNext()) {
            String str = (String) ((Iterator) localObject).next();
            paramHttpURLConnection.setRequestProperty(str, (String) this.a.getHeaders().get(str));
        }
        paramHttpURLConnection.setUseCaches(false);
        localObject = this.a.getRequestMethod();
        if (localObject != Request.Method.GET) {
            paramHttpURLConnection.setDoOutput(true);
            paramHttpURLConnection.setDoInput(true);
        }
        paramHttpURLConnection.setRequestMethod(((Request.Method) localObject).toString());
        paramHttpURLConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
    }

    private void b(String paramString) {
        this.c.setRequestProperty("Content-Length", Integer.toString(paramString.length()));
        try {
            BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(this.c.getOutputStream()));
            a(localBufferedWriter);
        } finally {
            try {
                localBufferedWriter.write(paramString);
                a(localBufferedWriter);
                return;
            } finally {
            }
            paramString =finally;
            localBufferedWriter = null;
        }
        throw paramString;
    }

    public void run() {
        try {
            String str2 = this.a.getQueryParams();
            String str1 = this.a.getPostBody();
            localObject2 = this.a.getUrl();
            Object localObject1 = localObject2;
            if (str2 != null) {
                localObject1 = localObject2;
                if (!"".equals(str2.trim())) {
                    localObject1 = (String) localObject2 + "?" + str2;
                }
            }
            Log.internal("[InMobi]-4.5.1", "URL:" + (String) localObject1);
            this.c = a((String) localObject1);
            if ((this.a.getRequestMethod() != Request.Method.GET) && ((str1 == null) || ("".equals(str1)))) {
                this.b.onRequestFailed(this.a, new Response(ErrorCode.INTERNAL_ERROR));
                return;
            }
            if (this.a.getRequestMethod() != Request.Method.GET) {
                Log.debug("[InMobi]-4.5.1", "Post body:" + str1);
                b(str1);
            }
            a();
            return;
        } catch (Exception localException) {
            Object localObject2 = new Response(ErrorCode.NETWORK_ERROR);
            if (this.b != null) {
                this.b.onRequestFailed(this.a, (Response) localObject2);
            }
            Log.debug("[InMobi]-4.5.1", "Failed to make network request", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/network/NetworkRequestTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */