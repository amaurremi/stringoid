package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache.Entry;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
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
  implements Network
{
  protected static final boolean DEBUG = VolleyLog.DEBUG;
  private static int DEFAULT_POOL_SIZE = 4096;
  private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
  protected final HttpStack mHttpStack;
  protected final ByteArrayPool mPool;
  
  public BasicNetwork(HttpStack paramHttpStack)
  {
    this(paramHttpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
  }
  
  public BasicNetwork(HttpStack paramHttpStack, ByteArrayPool paramByteArrayPool)
  {
    this.mHttpStack = paramHttpStack;
    this.mPool = paramByteArrayPool;
  }
  
  private void addCacheHeaders(Map<String, String> paramMap, Cache.Entry paramEntry)
  {
    if (paramEntry == null) {}
    do
    {
      return;
      if (paramEntry.etag != null) {
        paramMap.put("If-None-Match", paramEntry.etag);
      }
    } while (paramEntry.serverDate <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramEntry.serverDate)));
  }
  
  private static void attemptRetryOnException(String paramString, Request<?> paramRequest, VolleyError paramVolleyError)
    throws VolleyError
  {
    RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try
    {
      localRetryPolicy.retry(paramVolleyError);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (VolleyError paramVolleyError)
    {
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramVolleyError;
    }
  }
  
  private static Map<String, String> convertHeaders(Header[] paramArrayOfHeader)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfHeader.length) {
        return localHashMap;
      }
      localHashMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
  }
  
  private byte[] entityToBytes(HttpEntity paramHttpEntity)
    throws IOException, ServerError
  {
    PoolingByteArrayOutputStream localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        throw new ServerError();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.mPool.returnBuf((byte[])localObject1);
      localPoolingByteArrayOutputStream.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = this.mPool.getBuf(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1)
        {
          localObject1 = arrayOfByte;
          localObject4 = localPoolingByteArrayOutputStream.toByteArray();
        }
        try
        {
          paramHttpEntity.consumeContent();
          this.mPool.returnBuf(arrayOfByte);
          localPoolingByteArrayOutputStream.close();
          return (byte[])localObject4;
          localObject1 = arrayOfByte;
          localPoolingByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        catch (IOException paramHttpEntity)
        {
          for (;;)
          {
            VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
          }
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  private void logSlowRequests(long paramLong, Request<?> paramRequest, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((DEBUG) || (paramLong > SLOW_REQUEST_THRESHOLD_MS)) {
      if (paramArrayOfByte == null) {
        break label82;
      }
    }
    label82:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramRequest, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramRequest.getRetryPolicy().getCurrentRetryCount()) });
      return;
    }
  }
  
  protected void logError(String paramString1, String paramString2, long paramLong)
  {
    VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[] { paramString1, Long.valueOf(SystemClock.elapsedRealtime() - paramLong), paramString2 });
  }
  
  public NetworkResponse performRequest(Request<?> paramRequest)
    throws VolleyError
  {
    long l = SystemClock.elapsedRealtime();
    label339:
    NetworkResponse localNetworkResponse;
    for (;;)
    {
      HttpResponse localHttpResponse2 = null;
      byte[] arrayOfByte = null;
      Object localObject4 = new HashMap();
      Object localObject2 = arrayOfByte;
      HttpResponse localHttpResponse1 = localHttpResponse2;
      Object localObject3 = localObject4;
      try
      {
        Object localObject5 = new HashMap();
        localObject2 = arrayOfByte;
        localHttpResponse1 = localHttpResponse2;
        localObject3 = localObject4;
        addCacheHeaders((Map)localObject5, paramRequest.getCacheEntry());
        localObject2 = arrayOfByte;
        localHttpResponse1 = localHttpResponse2;
        localObject3 = localObject4;
        localHttpResponse2 = this.mHttpStack.performRequest(paramRequest, (Map)localObject5);
        localObject2 = arrayOfByte;
        localHttpResponse1 = localHttpResponse2;
        localObject3 = localObject4;
        localObject5 = localHttpResponse2.getStatusLine();
        localObject2 = arrayOfByte;
        localHttpResponse1 = localHttpResponse2;
        localObject3 = localObject4;
        i = ((StatusLine)localObject5).getStatusCode();
        localObject2 = arrayOfByte;
        localHttpResponse1 = localHttpResponse2;
        localObject3 = localObject4;
        localObject4 = convertHeaders(localHttpResponse2.getAllHeaders());
        if (i == 304)
        {
          localObject2 = arrayOfByte;
          localHttpResponse1 = localHttpResponse2;
          localObject3 = localObject4;
          return new NetworkResponse(304, paramRequest.getCacheEntry().data, (Map)localObject4, true);
        }
        localObject2 = arrayOfByte;
        localHttpResponse1 = localHttpResponse2;
        localObject3 = localObject4;
        if (localHttpResponse2.getEntity() != null)
        {
          localObject2 = arrayOfByte;
          localHttpResponse1 = localHttpResponse2;
          localObject3 = localObject4;
          arrayOfByte = entityToBytes(localHttpResponse2.getEntity());
          localObject2 = arrayOfByte;
          localHttpResponse1 = localHttpResponse2;
          localObject3 = localObject4;
          logSlowRequests(SystemClock.elapsedRealtime() - l, paramRequest, arrayOfByte, (StatusLine)localObject5);
          if ((i == 200) || (i == 204)) {
            break label339;
          }
          localObject2 = arrayOfByte;
          localHttpResponse1 = localHttpResponse2;
          localObject3 = localObject4;
          throw new IOException();
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          attemptRetryOnException("socket", paramRequest, new TimeoutError());
          break;
          localObject2 = localSocketTimeoutException;
          localHttpResponse1 = localHttpResponse2;
          localObject3 = localObject4;
          localObject1 = new byte[0];
        }
        localObject2 = localObject1;
        localHttpResponse1 = localHttpResponse2;
        localObject3 = localObject4;
        Object localObject1 = new NetworkResponse(i, (byte[])localObject1, (Map)localObject4, false);
        return (NetworkResponse)localObject1;
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        attemptRetryOnException("connection", paramRequest, new TimeoutError());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        throw new RuntimeException("Bad URL " + paramRequest.getUrl(), localMalformedURLException);
      }
      catch (IOException localIOException)
      {
        int i;
        if (localHttpResponse1 != null)
        {
          i = localHttpResponse1.getStatusLine().getStatusCode();
          VolleyLog.e("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramRequest.getUrl() });
          if (localObject2 == null) {
            break label537;
          }
          localNetworkResponse = new NetworkResponse(i, (byte[])localObject2, (Map)localObject3, false);
          if ((i == 401) || (i == 403)) {
            attemptRetryOnException("auth", paramRequest, new AuthFailureError(localNetworkResponse));
          }
        }
        else
        {
          throw new NoConnectionError(localNetworkResponse);
        }
      }
    }
    throw new ServerError(localNetworkResponse);
    label537:
    throw new NetworkError(null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/android/volley/toolbox/BasicNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */