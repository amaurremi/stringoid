package com.gau.go.launcherex.gowidget.weather.globaltheme.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView.ScaleType;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a;
import com.gau.go.launcherex.gowidget.weather.util.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class e
  extends i
{
  private static Comparator u = null;
  private WeakReference a;
  private WeakReference b;
  private int c = -1;
  private boolean d;
  private boolean e;
  private int f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = true;
  private ArrayList o;
  private long p;
  private long q;
  private ImageView.ScaleType r = ImageView.ScaleType.FIT_CENTER;
  private boolean s = false;
  private l t;
  
  public static List a(List paramList)
  {
    if (u == null) {
      u = Collections.reverseOrder(new f());
    }
    Collections.sort(paramList, u);
    return paramList;
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setCallback(null);
  }
  
  public Drawable a(Context paramContext)
  {
    Object localObject2;
    if (this.b != null)
    {
      localObject2 = (Drawable)this.b.get();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof BitmapDrawable))
        {
          Bitmap localBitmap = ((BitmapDrawable)localObject2).getBitmap();
          if (localBitmap != null)
          {
            localObject1 = localObject2;
            if (!localBitmap.isRecycled()) {
              break label59;
            }
          }
        }
      }
    }
    for (Object localObject1 = null;; localObject1 = null)
    {
      label59:
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramContext = a.a(paramContext, this);
        localObject2 = paramContext;
        if (paramContext != null)
        {
          a(paramContext);
          localObject2 = paramContext;
        }
      }
      return (Drawable)localObject2;
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.p = paramLong;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.b != null)
    {
      b((Drawable)this.b.get());
      this.b = null;
    }
    if (paramDrawable != null) {
      this.b = new WeakReference(paramDrawable);
    }
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    this.r = paramScaleType;
  }
  
  public void a(l paraml)
  {
    this.t = paraml;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.o = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public boolean a()
  {
    return this.s;
  }
  
  public long b()
  {
    return this.q;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.q = paramLong;
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public String c(int paramInt)
  {
    if (this.t != null) {
      return this.t.b(paramInt);
    }
    return null;
  }
  
  public ArrayList c()
  {
    return this.o;
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public String d(int paramInt)
  {
    if (this.t != null) {
      return this.t.c(paramInt);
    }
    return null;
  }
  
  public void d(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.o != null)
    {
      bool1 = bool2;
      if (this.o.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean e()
  {
    return this.m;
  }
  
  public void f(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean f()
  {
    return this.n;
  }
  
  public void g(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean g()
  {
    return this.l;
  }
  
  public void h(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean h()
  {
    return this.j;
  }
  
  public void i(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean i()
  {
    return this.k;
  }
  
  public void j(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean j()
  {
    return this.g;
  }
  
  public boolean k()
  {
    return this.h;
  }
  
  public int l()
  {
    return this.c;
  }
  
  public boolean m()
  {
    return this.d;
  }
  
  public boolean n()
  {
    return this.e;
  }
  
  public int o()
  {
    return this.f;
  }
  
  public void p()
  {
    if (this.a != null)
    {
      b((Drawable)this.a.get());
      this.a = null;
    }
    if (this.b != null)
    {
      b((Drawable)this.b.get());
      this.b = null;
    }
  }
  
  public boolean q()
  {
    return this.i;
  }
  
  public ImageView.ScaleType r()
  {
    return this.r;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */