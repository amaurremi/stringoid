package com.gtp.go.weather.sharephoto.photo;

import android.content.Context;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.a.a.c.d;
import com.gtp.go.weather.sharephoto.b.g;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class f
{
  private static f b;
  private int a = 3;
  private Context c;
  private int d = 0;
  private HashMap e;
  private ArrayList f;
  
  private f(Context paramContext)
  {
    this.c = paramContext;
    this.d = 0;
    this.e = new HashMap();
    a();
  }
  
  public static f a(Context paramContext)
  {
    if (b == null) {
      b = new f(paramContext);
    }
    return b;
  }
  
  private String a(String paramString)
  {
    String str = b(paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    paramString = paramString.split("=");
    if ((paramString != null) && (paramString.length == 2) && (!TextUtils.isEmpty(paramString[1]))) {
      return paramString[1];
    }
    return y.c();
  }
  
  private void a()
  {
    switch (d.a(this.c))
    {
    default: 
      this.a = 3;
      return;
    case 1: 
      this.a = 4;
      return;
    case 2: 
      this.a = 2;
      return;
    case 3: 
      this.a = 3;
      return;
    }
    this.a = 4;
  }
  
  private String b(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder(paramString.length * 2);
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        int k = paramString[i];
        if ((k & 0xFF) < 16) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(Integer.toHexString(k & 0xFF));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException("oh, MD5 not be supported?", paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("oh, UTF-8 should be supported?", paramString);
    }
  }
  
  private void b()
  {
    int j = this.d;
    int i = j;
    if (this.f != null) {
      i = j + this.f.size();
    }
    if (i == 0) {
      c();
    }
    while ((this.f == null) || (this.f.size() <= 0) || (this.d >= this.a)) {
      return;
    }
    g localg = (g)this.f.remove(0);
    this.d += 1;
    new h(this, null).execute(new g[] { localg });
  }
  
  private void c()
  {
    b = null;
    this.e.clear();
  }
  
  public String a(long paramLong)
  {
    return (String)this.e.get(Long.valueOf(paramLong));
  }
  
  public void a(g paramg)
  {
    if (!this.e.containsKey(Long.valueOf(paramg.a())))
    {
      this.e.put(Long.valueOf(paramg.a()), paramg.x());
      if (this.d < this.a)
      {
        this.d += 1;
        new h(this, null).execute(new g[] { paramg });
      }
    }
    else
    {
      return;
    }
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramg);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */