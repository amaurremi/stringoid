package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class oh
  implements HttpEntity
{
  private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private final oc b;
  private final Header c;
  private long d;
  private volatile boolean e;
  
  public oh()
  {
    this(oe.a, null, null);
  }
  
  public oh(oe paramoe)
  {
    this(paramoe, null, null);
  }
  
  public oh(oe paramoe, String paramString, Charset paramCharset)
  {
    String str = paramString;
    if (paramString == null) {
      str = a();
    }
    paramString = paramoe;
    if (paramoe == null) {
      paramString = oe.a;
    }
    this.b = new oc("form-data", paramCharset, str, paramString);
    this.c = new BasicHeader("Content-Type", a(str, paramCharset));
    this.e = true;
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int j = localRandom.nextInt(11);
    int i = 0;
    while (i < j + 30)
    {
      localStringBuilder.append(a[localRandom.nextInt(a.length)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  protected String a(String paramString, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multipart/form-data; boundary=");
    localStringBuilder.append(paramString);
    if (paramCharset != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramCharset.name());
    }
    return localStringBuilder.toString();
  }
  
  public void a(oa paramoa)
  {
    this.b.a(paramoa);
    this.e = true;
  }
  
  public void a(String paramString, oj paramoj)
  {
    a(new oa(paramString, paramoj));
  }
  
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  public InputStream getContent()
    throws IOException, UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
  }
  
  public Header getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    if (this.e)
    {
      this.d = this.b.c();
      this.e = false;
    }
    return this.d;
  }
  
  public Header getContentType()
  {
    return this.c;
  }
  
  public boolean isChunked()
  {
    return !isRepeatable();
  }
  
  public boolean isRepeatable()
  {
    Iterator localIterator = this.b.a().iterator();
    while (localIterator.hasNext()) {
      if (((oa)localIterator.next()).b().e() < 0L) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isStreaming()
  {
    return !isRepeatable();
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    this.b.a(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/oh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */