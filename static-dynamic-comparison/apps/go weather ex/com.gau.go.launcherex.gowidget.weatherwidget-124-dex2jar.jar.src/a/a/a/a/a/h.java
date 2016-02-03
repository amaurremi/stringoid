package a.a.a.a.a;

import a.a.a.a.a.a.b;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class h
  implements HttpEntity
{
  private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private final c b;
  private final Header c;
  private long d;
  private volatile boolean e;
  
  public h()
  {
    this(e.a, null, null);
  }
  
  public h(e parame)
  {
    this(parame, null, null);
  }
  
  public h(e parame, String paramString, Charset paramCharset)
  {
    String str = paramString;
    if (paramString == null) {
      str = a();
    }
    paramString = parame;
    if (parame == null) {
      paramString = e.a;
    }
    this.b = new c("form-data", paramCharset, str, paramString);
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
  
  public void a(a parama)
  {
    this.b.a(parama);
    this.e = true;
  }
  
  public void a(String paramString, b paramb)
  {
    a(new a(paramString, paramb));
  }
  
  public void consumeContent()
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  public InputStream getContent()
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
      if (((a)localIterator.next()).b().e() < 0L) {
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
  {
    this.b.a(paramOutputStream);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/a/a/a/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */