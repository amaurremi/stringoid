package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache.Entry;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

public class BasicNetwork
        implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    public BasicNetwork(HttpStack paramHttpStack) {
        this(paramHttpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    public BasicNetwork(HttpStack paramHttpStack, ByteArrayPool paramByteArrayPool) {
        this.mHttpStack = paramHttpStack;
        this.mPool = paramByteArrayPool;
    }

    private void addCacheHeaders(Map<String, String> paramMap, Cache.Entry paramEntry) {
        if (paramEntry == null) {
        }
        do {
            return;
            if (paramEntry.etag != null) {
                paramMap.put("If-None-Match", paramEntry.etag);
            }
        } while (paramEntry.serverDate <= 0L);
        paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramEntry.serverDate)));
    }

    private static void attemptRetryOnException(String paramString, Request<?> paramRequest, VolleyError paramVolleyError)
            throws VolleyError {
        RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
        int i = paramRequest.getTimeoutMs();
        try {
            localRetryPolicy.retry(paramVolleyError);
            paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{paramString, Integer.valueOf(i)}));
            return;
        } catch (VolleyError paramVolleyError) {
            paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{paramString, Integer.valueOf(i)}));
            throw paramVolleyError;
        }
    }

    private static Map<String, String> convertHeaders(Header[] paramArrayOfHeader) {
        HashMap localHashMap = new HashMap();
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayOfHeader.length) {
                return localHashMap;
            }
            localHashMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
            i += 1;
        }
    }

    private byte[] entityToBytes(HttpEntity paramHttpEntity)
            throws IOException, ServerError {
        PoolingByteArrayOutputStream localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) paramHttpEntity.getContentLength());
        Object localObject2 = null;
        Object localObject1 = localObject2;
        Object localObject4;
        try {
            localObject4 = paramHttpEntity.getContent();
            if (localObject4 == null) {
                localObject1 = localObject2;
                throw new ServerError();
            }
        } finally {
        }
        try {
            paramHttpEntity.consumeContent();
            this.mPool.returnBuf((byte[]) localObject1);
            localPoolingByteArrayOutputStream.close();
            throw ((Throwable) localObject3);
            localObject1 = localObject3;
            byte[] arrayOfByte = this.mPool.getBuf(1024);
            for (; ; ) {
                localObject1 = arrayOfByte;
                int i = ((InputStream) localObject4).read(arrayOfByte);
                if (i == -1) {
                    localObject1 = arrayOfByte;
                    localObject4 = localPoolingByteArrayOutputStream.toByteArray();
                }
                try {
                    paramHttpEntity.consumeContent();
                    this.mPool.returnBuf(arrayOfByte);
                    localPoolingByteArrayOutputStream.close();
                    return (byte[]) localObject4;
                    localObject1 = arrayOfByte;
                    localPoolingByteArrayOutputStream.write(arrayOfByte, 0, i);
                } catch (IOException paramHttpEntity) {
                    for (; ; ) {
                        VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
                    }
                }
            }
        } catch (IOException paramHttpEntity) {
            for (; ; ) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
        }
    }

    private void logSlowRequests(long paramLong, Request<?> paramRequest, byte[] paramArrayOfByte, StatusLine paramStatusLine) {
        if ((DEBUG) || (paramLong > SLOW_REQUEST_THRESHOLD_MS)) {
            if (paramArrayOfByte == null) {
                break label82;
            }
        }
        label82:
        for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length); ; paramArrayOfByte = "null") {
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[]{paramRequest, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramRequest.getRetryPolicy().getCurrentRetryCount())});
            return;
        }
    }

    protected void logError(String paramString1, String paramString2, long paramLong) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[]{paramString1, Long.valueOf(SystemClock.elapsedRealtime() - paramLong), paramString2});
    }

    public NetworkResponse performRequest(Request<?> paramRequest)
            throws VolleyError {
        long l = SystemClock.elapsedRealtime();
        for (; ; ) {
            HttpResponse localHttpResponse2 = null;
            Object localObject4 = null;
            Object localObject5 = new HashMap();
            Object localObject1 = localObject4;
            HttpResponse localHttpResponse1 = localHttpResponse2;
            Object localObject3 = localObject5;
            try {
                Object localObject6 = new HashMap();
                localObject1 = localObject4;
                localHttpResponse1 = localHttpResponse2;
                localObject3 = localObject5;
                addCacheHeaders((Map) localObject6, paramRequest.getCacheEntry());
                localObject1 = localObject4;
                localHttpResponse1 = localHttpResponse2;
                localObject3 = localObject5;
                localHttpResponse2 = this.mHttpStack.performRequest(paramRequest, (Map) localObject6);
                localObject1 = localObject4;
                localHttpResponse1 = localHttpResponse2;
                localObject3 = localObject5;
                localObject6 = localHttpResponse2.getStatusLine();
                localObject1 = localObject4;
                localHttpResponse1 = localHttpResponse2;
                localObject3 = localObject5;
                i = ((StatusLine) localObject6).getStatusCode();
                localObject1 = localObject4;
                localHttpResponse1 = localHttpResponse2;
                localObject3 = localObject5;
                localObject5 = convertHeaders(localHttpResponse2.getAllHeaders());
                if (i == 304) {
                    localObject1 = localObject4;
                    localHttpResponse1 = localHttpResponse2;
                    localObject3 = localObject5;
                    return new NetworkResponse(304, paramRequest.getCacheEntry().data, (Map) localObject5, true);
                }
                localObject1 = localObject4;
                localHttpResponse1 = localHttpResponse2;
                localObject3 = localObject5;
                localObject4 = entityToBytes(localHttpResponse2.getEntity());
                localObject1 = localObject4;
                localHttpResponse1 = localHttpResponse2;
                localObject3 = localObject5;
                logSlowRequests(SystemClock.elapsedRealtime() - l, paramRequest, (byte[]) localObject4, (StatusLine) localObject6);
                if ((i != 200) && (i != 204)) {
                    localObject1 = localObject4;
                    localHttpResponse1 = localHttpResponse2;
                    localObject3 = localObject5;
                    throw new IOException();
                }
            } catch (SocketTimeoutException localSocketTimeoutException) {
                attemptRetryOnException("socket", paramRequest, new TimeoutError());
                continue;
                Object localObject2 = localObject4;
                localHttpResponse1 = localHttpResponse2;
                localObject3 = localObject5;
                localObject4 = new NetworkResponse(i, (byte[]) localObject4, (Map) localObject5, false);
                return (NetworkResponse) localObject4;
            } catch (ConnectTimeoutException localConnectTimeoutException) {
                attemptRetryOnException("connection", paramRequest, new TimeoutError());
            } catch (MalformedURLException localMalformedURLException) {
                throw new RuntimeException("Bad URL " + paramRequest.getUrl(), localMalformedURLException);
            } catch (IOException localIOException) {
                int i = 0;
                if (localHttpResponse1 != null) {
                    i = localHttpResponse1.getStatusLine().getStatusCode();
                }
                VolleyLog.e("Unexpected response code %d for %s", new Object[]{Integer.valueOf(i), paramRequest.getUrl()});
                if (localMalformedURLException != null) {
                    NetworkResponse localNetworkResponse = new NetworkResponse(i, localMalformedURLException, (Map) localObject3, false);
                    if ((i == 401) || (i == 403)) {
                        attemptRetryOnException("auth", paramRequest, new AuthFailureError(localNetworkResponse));
                        continue;
                    }
                    throw new ServerError(localNetworkResponse);
                }
                throw new NetworkError(null);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/android/volley/toolbox/BasicNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */