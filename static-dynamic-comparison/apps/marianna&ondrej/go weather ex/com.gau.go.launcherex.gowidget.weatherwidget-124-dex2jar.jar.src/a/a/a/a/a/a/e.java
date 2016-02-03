package a.a.a.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class e
  extends a
{
  private final byte[] a;
  private final Charset b;
  
  public e(String paramString)
  {
    this(paramString, "text/plain", null);
  }
  
  public e(String paramString1, String paramString2, Charset paramCharset)
  {
    super(paramString2);
    if (paramString1 == null) {
      throw new IllegalArgumentException("Text may not be null");
    }
    paramString2 = paramCharset;
    if (paramCharset == null) {
      paramString2 = Charset.forName("US-ASCII");
    }
    this.a = paramString1.getBytes(paramString2.name());
    this.b = paramString2;
  }
  
  public e(String paramString, Charset paramCharset)
  {
    this(paramString, "text/plain", paramCharset);
  }
  
  public void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.a);
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = localByteArrayInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    paramOutputStream.flush();
  }
  
  public String b()
  {
    return null;
  }
  
  public String c()
  {
    return this.b.name();
  }
  
  public String d()
  {
    return "8bit";
  }
  
  public long e()
  {
    return this.a.length;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/a/a/a/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */