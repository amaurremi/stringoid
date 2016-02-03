package com.flurry.android.monolithic.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

public class oc
{
  private static final ByteArrayBuffer a = a(of.a, ": ");
  private static final ByteArrayBuffer b = a(of.a, "\r\n");
  private static final ByteArrayBuffer c = a(of.a, "--");
  private final String d;
  private final Charset e;
  private final String f;
  private final List<oa> g;
  private final oe h;
  
  public oc(String paramString1, Charset paramCharset, String paramString2, oe paramoe)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Multipart subtype may not be null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Multipart boundary may not be null");
    }
    this.d = paramString1;
    if (paramCharset != null) {}
    for (;;)
    {
      this.e = paramCharset;
      this.f = paramString2;
      this.g = new ArrayList();
      this.h = paramoe;
      return;
      paramCharset = of.a;
    }
  }
  
  private static ByteArrayBuffer a(Charset paramCharset, String paramString)
  {
    paramCharset = paramCharset.encode(CharBuffer.wrap(paramString));
    paramString = new ByteArrayBuffer(paramCharset.remaining());
    paramString.append(paramCharset.array(), paramCharset.position(), paramCharset.remaining());
    return paramString;
  }
  
  private void a(oe paramoe, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    ByteArrayBuffer localByteArrayBuffer = a(this.e, b());
    Iterator localIterator = this.g.iterator();
    if (localIterator.hasNext())
    {
      oa localoa = (oa)localIterator.next();
      a(c, paramOutputStream);
      a(localByteArrayBuffer, paramOutputStream);
      a(b, paramOutputStream);
      Object localObject = localoa.c();
      switch (od.a[paramoe.ordinal()])
      {
      }
      for (;;)
      {
        a(b, paramOutputStream);
        if (paramBoolean) {
          localoa.b().a(paramOutputStream);
        }
        a(b, paramOutputStream);
        break;
        localObject = ((ob)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((og)((Iterator)localObject).next(), paramOutputStream);
        }
        a(localoa.c().a("Content-Disposition"), this.e, paramOutputStream);
        if (localoa.b().b() != null) {
          a(localoa.c().a("Content-Type"), this.e, paramOutputStream);
        }
      }
    }
    a(c, paramOutputStream);
    a(localByteArrayBuffer, paramOutputStream);
    a(c, paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(og paramog, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramog.a(), paramOutputStream);
    a(a, paramOutputStream);
    a(paramog.b(), paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(og paramog, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramog.a(), paramCharset, paramOutputStream);
    a(a, paramOutputStream);
    a(paramog.b(), paramCharset, paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    a(a(of.a, paramString), paramOutputStream);
  }
  
  private static void a(String paramString, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException
  {
    a(a(paramCharset, paramString), paramOutputStream);
  }
  
  private static void a(ByteArrayBuffer paramByteArrayBuffer, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramByteArrayBuffer.buffer(), 0, paramByteArrayBuffer.length());
  }
  
  public List<oa> a()
  {
    return this.g;
  }
  
  public void a(oa paramoa)
  {
    if (paramoa == null) {
      return;
    }
    this.g.add(paramoa);
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    a(this.h, paramOutputStream, true);
  }
  
  public String b()
  {
    return this.f;
  }
  
  public long c()
  {
    Object localObject = this.g.iterator();
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      long l2 = ((oa)((Iterator)localObject).next()).b().e();
      if (l2 >= 0L) {
        l1 += l2;
      } else {
        return -1L;
      }
    }
    localObject = new ByteArrayOutputStream();
    try
    {
      a(this.h, (OutputStream)localObject, false);
      int i = ((ByteArrayOutputStream)localObject).toByteArray().length;
      return l1 + i;
    }
    catch (IOException localIOException) {}
    return -1L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/oc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */