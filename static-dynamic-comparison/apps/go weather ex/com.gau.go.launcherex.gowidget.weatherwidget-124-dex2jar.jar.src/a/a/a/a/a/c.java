package a.a.a.a.a;

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

public class c
{
  private static final ByteArrayBuffer a = a(f.a, ": ");
  private static final ByteArrayBuffer b = a(f.a, "\r\n");
  private static final ByteArrayBuffer c = a(f.a, "--");
  private final String d;
  private final Charset e;
  private final String f;
  private final List g;
  private final e h;
  
  public c(String paramString1, Charset paramCharset, String paramString2, e parame)
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
      this.h = parame;
      return;
      paramCharset = f.a;
    }
  }
  
  private static ByteArrayBuffer a(Charset paramCharset, String paramString)
  {
    paramCharset = paramCharset.encode(CharBuffer.wrap(paramString));
    paramString = new ByteArrayBuffer(paramCharset.remaining());
    paramString.append(paramCharset.array(), paramCharset.position(), paramCharset.remaining());
    return paramString;
  }
  
  private void a(e parame, OutputStream paramOutputStream, boolean paramBoolean)
  {
    ByteArrayBuffer localByteArrayBuffer = a(this.e, b());
    Iterator localIterator = this.g.iterator();
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      a(c, paramOutputStream);
      a(localByteArrayBuffer, paramOutputStream);
      a(b, paramOutputStream);
      Object localObject = locala.c();
      switch (d.a[parame.ordinal()])
      {
      }
      for (;;)
      {
        a(b, paramOutputStream);
        if (paramBoolean) {
          locala.b().a(paramOutputStream);
        }
        a(b, paramOutputStream);
        break;
        localObject = ((b)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((g)((Iterator)localObject).next(), paramOutputStream);
        }
        a(locala.c().a("Content-Disposition"), this.e, paramOutputStream);
        if (locala.b().b() != null) {
          a(locala.c().a("Content-Type"), this.e, paramOutputStream);
        }
      }
    }
    a(c, paramOutputStream);
    a(localByteArrayBuffer, paramOutputStream);
    a(c, paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(g paramg, OutputStream paramOutputStream)
  {
    a(paramg.a(), paramOutputStream);
    a(a, paramOutputStream);
    a(paramg.b(), paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(g paramg, Charset paramCharset, OutputStream paramOutputStream)
  {
    a(paramg.a(), paramCharset, paramOutputStream);
    a(a, paramOutputStream);
    a(paramg.b(), paramCharset, paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(String paramString, OutputStream paramOutputStream)
  {
    a(a(f.a, paramString), paramOutputStream);
  }
  
  private static void a(String paramString, Charset paramCharset, OutputStream paramOutputStream)
  {
    a(a(paramCharset, paramString), paramOutputStream);
  }
  
  private static void a(ByteArrayBuffer paramByteArrayBuffer, OutputStream paramOutputStream)
  {
    paramOutputStream.write(paramByteArrayBuffer.buffer(), 0, paramByteArrayBuffer.length());
  }
  
  public List a()
  {
    return this.g;
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.g.add(parama);
  }
  
  public void a(OutputStream paramOutputStream)
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
      long l2 = ((a)((Iterator)localObject).next()).b().e();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/a/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */