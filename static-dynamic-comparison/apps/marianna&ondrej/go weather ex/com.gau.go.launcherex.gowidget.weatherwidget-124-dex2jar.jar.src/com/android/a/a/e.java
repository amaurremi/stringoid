package com.android.a.a;

import com.android.a.ab;
import com.android.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

class e
{
  public long a;
  public String b;
  public String c;
  public long d;
  public long e;
  public long f;
  public Map g;
  
  private e() {}
  
  public e(String paramString, c paramc)
  {
    this.b = paramString;
    this.a = paramc.a.length;
    this.c = paramc.b;
    this.d = paramc.c;
    this.e = paramc.d;
    this.f = paramc.e;
    this.g = paramc.f;
  }
  
  public static e a(InputStream paramInputStream)
  {
    e locale = new e();
    if (d.a(paramInputStream) != 538051844) {
      throw new IOException();
    }
    locale.b = d.c(paramInputStream);
    locale.c = d.c(paramInputStream);
    if (locale.c.equals("")) {
      locale.c = null;
    }
    locale.d = d.b(paramInputStream);
    locale.e = d.b(paramInputStream);
    locale.f = d.b(paramInputStream);
    locale.g = d.d(paramInputStream);
    return locale;
  }
  
  public c a(byte[] paramArrayOfByte)
  {
    c localc = new c();
    localc.a = paramArrayOfByte;
    localc.b = this.c;
    localc.c = this.d;
    localc.d = this.e;
    localc.e = this.f;
    localc.f = this.g;
    return localc;
  }
  
  public boolean a(OutputStream paramOutputStream)
  {
    try
    {
      d.a(paramOutputStream, 538051844);
      d.a(paramOutputStream, this.b);
      if (this.c == null) {}
      for (String str = "";; str = this.c)
      {
        d.a(paramOutputStream, str);
        d.a(paramOutputStream, this.d);
        d.a(paramOutputStream, this.e);
        d.a(paramOutputStream, this.f);
        d.a(this.g, paramOutputStream);
        paramOutputStream.flush();
        return true;
      }
      return false;
    }
    catch (IOException paramOutputStream)
    {
      ab.b("%s", new Object[] { paramOutputStream.toString() });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */