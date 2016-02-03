package com.android.a.a;

import com.android.a.ab;
import com.android.a.p;
import com.android.a.u;
import com.android.a.v;
import java.io.UnsupportedEncodingException;

public abstract class n
  extends p
{
  private static final String a = String.format("application/json; charset=%s", new Object[] { "utf-8" });
  private final v b;
  private final String c;
  
  public n(int paramInt, String paramString1, String paramString2, v paramv, u paramu)
  {
    super(paramInt, paramString1, paramu);
    this.b = paramv;
    this.c = paramString2;
  }
  
  protected void b(Object paramObject)
  {
    this.b.a(paramObject);
  }
  
  public String l()
  {
    return p();
  }
  
  public byte[] m()
  {
    return q();
  }
  
  public String p()
  {
    return a;
  }
  
  public byte[] q()
  {
    try
    {
      if (this.c == null) {
        return null;
      }
      byte[] arrayOfByte = this.c.getBytes("utf-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ab.d("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[] { this.c, "utf-8" });
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */