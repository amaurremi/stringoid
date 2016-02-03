package com.android.a.a;

import android.os.SystemClock;
import com.android.a.aa;
import com.android.a.ab;
import com.android.a.c;
import com.android.a.l;
import com.android.a.m;
import com.android.a.n;
import com.android.a.x;
import com.android.a.y;
import com.android.a.z;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;

public class a
  implements com.android.a.j
{
  protected static final boolean a = ab.b;
  protected final j b;
  protected final b c;
  
  public a(j paramj)
  {
    this(paramj, new b(4096));
  }
  
  public a(j paramj, b paramb)
  {
    this.b = paramj;
    this.c = paramb;
  }
  
  private static Map a(Header[] paramArrayOfHeader)
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
  
  private void a(long paramLong, com.android.a.p paramp, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((a) || (paramLong > 3000L)) {
      if (paramArrayOfByte == null) {
        break label81;
      }
    }
    label81:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      ab.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramp, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramp.u().b()) });
      return;
    }
  }
  
  private static void a(String paramString, com.android.a.p paramp, aa paramaa)
  {
    x localx = paramp.u();
    int i = paramp.t();
    try
    {
      localx.a(paramaa);
      paramp.a(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (aa paramaa)
    {
      paramp.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramaa;
    }
  }
  
  private byte[] a(HttpEntity paramHttpEntity)
  {
    p localp = new p(this.c, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        throw new y();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.c.a((byte[])localObject1);
      localp.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = this.c.a(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1)
        {
          localObject1 = arrayOfByte;
          localObject4 = localp.toByteArray();
        }
        try
        {
          paramHttpEntity.consumeContent();
          this.c.a(arrayOfByte);
          localp.close();
          return (byte[])localObject4;
          localObject1 = arrayOfByte;
          localp.write(arrayOfByte, 0, i);
        }
        catch (IOException paramHttpEntity)
        {
          for (;;)
          {
            ab.a("Error occured when calling consumingContent", new Object[0]);
          }
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        ab.a("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  public m a(com.android.a.p paramp)
  {
    long l = SystemClock.elapsedRealtime();
    for (;;)
    {
      localMap = null;
      Object localObject3 = null;
      Object localObject1 = null;
      localObject5 = new HashMap();
      Object localObject4;
      try
      {
        localObject4 = new HashMap();
        localObject4 = this.b.a(paramp, (Map)localObject4);
        try
        {
          localStatusLine = ((HttpResponse)localObject4).getStatusLine();
          i = localStatusLine.getStatusCode();
          localMap = a(((HttpResponse)localObject4).getAllHeaders());
          if (i == 304) {
            localObject1 = localObject3;
          }
        }
        catch (IOException localIOException2)
        {
          StatusLine localStatusLine;
          int i;
          Object localObject2;
          m localm;
          for (;;) {}
        }
        try
        {
          return new m(304, paramp.f().a, localMap, true);
        }
        catch (IOException localIOException3)
        {
          localObject5 = localMap;
          break label288;
        }
        localObject1 = localObject3;
        if (((HttpResponse)localObject4).getEntity() != null)
        {
          localObject1 = localObject3;
          localObject3 = a(((HttpResponse)localObject4).getEntity());
          localObject1 = localObject3;
          a(SystemClock.elapsedRealtime() - l, paramp, (byte[])localObject3, localStatusLine);
          if ((i >= 200) && (i <= 299)) {
            break label211;
          }
          localObject1 = localObject3;
          throw new IOException();
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          a("socket", paramp, new z());
          break;
          localObject2 = localObject3;
          localObject3 = new byte[0];
        }
        localObject2 = localObject3;
        localObject3 = new m(i, (byte[])localObject3, localMap, false);
        return (m)localObject3;
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        a("connection", paramp, new z());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        throw new RuntimeException("Bad URL " + paramp.d(), localMalformedURLException);
      }
      catch (IOException localIOException1)
      {
        label211:
        localObject4 = localMap;
      }
      label288:
      if (localObject4 == null) {
        break;
      }
      i = ((HttpResponse)localObject4).getStatusLine().getStatusCode();
      ab.c("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramp.d() });
      if (localMalformedURLException == null) {
        break label401;
      }
      localm = new m(i, localMalformedURLException, (Map)localObject5, false);
      if ((i != 401) && (i != 403)) {
        break label391;
      }
      a("auth", paramp, new com.android.a.a(localm));
    }
    throw new n(localIOException1);
    label391:
    throw new y(localm);
    label401:
    throw new l(null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */