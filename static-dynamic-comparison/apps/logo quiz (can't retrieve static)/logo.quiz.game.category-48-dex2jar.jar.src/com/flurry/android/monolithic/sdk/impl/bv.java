package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.avro.protocol.v6.AdRequest;
import com.flurry.android.impl.ads.avro.protocol.v6.AdResponse;
import com.flurry.android.impl.ads.avro.protocol.v6.SdkLogRequest;
import com.flurry.android.impl.ads.avro.protocol.v6.SdkLogResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class bv
{
  private static final String a = bv.class.getSimpleName();
  private static ly b;
  
  public bv()
  {
    b = new ly();
  }
  
  private <A extends nu, B extends nu> B a(A paramA, String paramString, Class<A> paramClass, Class<B> paramClass1)
  {
    paramA = a(paramA, paramClass);
    if (paramA != null) {
      return a(a(paramA, paramString), paramClass1);
    }
    ja.a(6, a, "Response in bytes is null");
    return null;
  }
  
  private byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[''];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  private byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject1 = new ByteArrayEntity(paramArrayOfByte);
    ((ByteArrayEntity)localObject1).setContentType("avro/binary");
    ja.a(4, a, "httpPOSTAvroBytesToUrl: reportUrl = " + paramString);
    Object localObject2 = new HttpPost(paramString);
    ((HttpPost)localObject2).setEntity((HttpEntity)localObject1);
    ((HttpPost)localObject2).setHeader("accept", "avro/binary");
    ((HttpPost)localObject2).setHeader("FM-Checksum", Integer.toString(a(paramArrayOfByte)));
    paramArrayOfByte = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramArrayOfByte, 10000);
    HttpConnectionParams.setSoTimeout(paramArrayOfByte, 15000);
    ((HttpPost)localObject2).getParams().setBooleanParameter("http.protocol.expect-continue", false);
    paramArrayOfByte = iz.a(paramArrayOfByte);
    for (;;)
    {
      try
      {
        localObject2 = paramArrayOfByte.execute((HttpUriRequest)localObject2);
        i = ((HttpResponse)localObject2).getStatusLine().getStatusCode();
        if ((i != 200) || (((HttpResponse)localObject2).getEntity() == null) || (((HttpResponse)localObject2).getEntity().getContentLength() == 0L)) {
          continue;
        }
        ja.a(4, a, "Request successful");
        byte[] arrayOfByte = a(((HttpResponse)localObject2).getEntity().getContent());
        ((ByteArrayEntity)localObject1).consumeContent();
        localObject1 = Integer.toString(a(arrayOfByte));
        if (((HttpResponse)localObject2).containsHeader("FM-Checksum"))
        {
          boolean bool = ((HttpResponse)localObject2).getFirstHeader("FM-Checksum").getValue().equals(localObject1);
          if (!bool) {}
        }
        else
        {
          return arrayOfByte;
        }
        ja.a(6, a, "Response was received, but checksum failed.");
      }
      catch (IOException localIOException)
      {
        int i;
        ja.a(6, a, "Request to url = " + paramString + " failed with IOException = " + localIOException.toString(), localIOException);
        if (paramArrayOfByte == null) {
          continue;
        }
        paramArrayOfByte.getConnectionManager().shutdown();
        continue;
      }
      finally
      {
        if (paramArrayOfByte == null) {
          continue;
        }
        paramArrayOfByte.getConnectionManager().shutdown();
      }
      return null;
      ja.a(6, a, "Request to url = " + paramString + " failed with HTTP = " + i);
    }
  }
  
  private <A extends nu> A b(byte[] paramArrayOfByte, Class<A> paramClass)
  {
    Object localObject = b.a(new ByteArrayInputStream(paramArrayOfByte), null);
    try
    {
      localObject = (nu)new nr(paramClass).a(null, (lx)localObject);
      return (A)localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      ja.a(6, a, "ClassCastException in parseAvroBinary:" + localClassCastException.getMessage());
      ja.a(3, a, "ClassCastException in parseAvroBinary: bytes = " + paramArrayOfByte + " type = " + paramClass.getSimpleName());
      return null;
    }
    catch (IOException localIOException)
    {
      ja.a(6, a, "IOException in parseAvroBinary:" + localIOException.getMessage());
      ja.a(3, a, "IOException in parseAvroBinary: bytes = " + paramArrayOfByte + " type = " + paramClass.getSimpleName());
    }
    return null;
  }
  
  int a(byte[] paramArrayOfByte)
  {
    iv localiv = new iv();
    localiv.update(paramArrayOfByte);
    return localiv.b();
  }
  
  public AdResponse a(AdRequest paramAdRequest, String paramString)
  {
    return (AdResponse)a(paramAdRequest, paramString, AdRequest.class, AdResponse.class);
  }
  
  public SdkLogResponse a(SdkLogRequest paramSdkLogRequest, String paramString)
  {
    return (SdkLogResponse)a(paramSdkLogRequest, paramString, SdkLogRequest.class, SdkLogResponse.class);
  }
  
  <A extends nu> A a(byte[] paramArrayOfByte, Class<A> paramClass)
  {
    if (paramArrayOfByte == null)
    {
      ja.a(6, a, "convertBytesToResponse: bytes array is null");
      return null;
    }
    return b(paramArrayOfByte, paramClass);
  }
  
  <A extends nu> byte[] a(A paramA, Class<A> paramClass)
  {
    if (paramA == null)
    {
      ja.a(6, a, "convertRequestToByte: Request is null");
      return null;
    }
    paramClass = new ns(paramClass);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    lr locallr = md.a().b(localByteArrayOutputStream, null);
    try
    {
      paramClass.a(paramA, locallr);
      locallr.flush();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramA)
    {
      ja.a(6, a, "Error generating adlog request" + paramA.getMessage());
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */