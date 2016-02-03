package com.jiubang.playsdk.imageload;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import com.android.a.a.m;
import com.android.a.aa;
import com.android.a.p;
import com.android.a.s;
import java.util.HashMap;

public class d
{
  private final s a;
  private int b = 100;
  private final i c;
  private final HashMap d = new HashMap();
  private final HashMap e = new HashMap();
  private final Handler f = new Handler(Looper.getMainLooper());
  private Runnable g;
  
  public d(s params, i parami)
  {
    this.a = params;
    this.c = parami;
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2)
  {
    return paramString.length() + 12 + "#W" + paramInt1 + "#H" + paramInt2 + paramString;
  }
  
  private void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.c.a(paramString, paramBitmap);
    }
    h localh = (h)this.d.remove(paramString);
    if (localh != null)
    {
      h.a(localh, paramBitmap);
      a(paramString, localh);
    }
  }
  
  private void a(String paramString, aa paramaa)
  {
    h localh = (h)this.d.remove(paramString);
    if (localh != null)
    {
      localh.a(paramaa);
      a(paramString, localh);
    }
  }
  
  private void a(String paramString, h paramh)
  {
    this.e.put(paramString, paramh);
    if (this.g == null)
    {
      this.g = new g(this);
      this.f.postDelayed(this.g, this.b);
    }
  }
  
  public j a(String paramString, k paramk, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a();
    String str = a(paramString, paramInt1, paramInt2);
    Object localObject = this.c.a(str);
    if (localObject != null)
    {
      paramString = new j(this, (Bitmap)localObject, paramString, null, null);
      paramk.a(paramString, true);
      return paramString;
    }
    localObject = new j(this, null, paramString, str, paramk);
    paramk.a((j)localObject, true);
    paramk = (h)this.d.get(str);
    if (paramk != null)
    {
      paramk.a((j)localObject);
      return (j)localObject;
    }
    paramString = new m(paramString, new e(this, str, paramBoolean1), paramInt1, paramInt2, Bitmap.Config.RGB_565, new f(this, str));
    paramString.a(paramBoolean2);
    this.a.a(paramString);
    this.d.put(str, new h(this, paramString, (j)localObject));
    return (j)localObject;
  }
  
  public j a(String paramString, k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString, paramk, 0, 0, paramBoolean1, paramBoolean2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/imageload/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */