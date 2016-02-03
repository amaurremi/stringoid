package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.jiubang.core.a.h;
import com.jiubang.core.a.i;
import com.jiubang.core.a.j;
import com.jiubang.core.a.k;
import com.jiubang.core.a.l;
import com.jiubang.core.a.m;
import com.jiubang.core.a.n;
import com.jiubang.core.a.w;
import java.lang.reflect.Field;
import java.util.HashMap;

public class c
{
  private z a;
  private Context b;
  private Context c;
  private String d;
  private int e;
  private boolean f;
  private int g;
  private float h;
  private float i;
  private float j;
  
  public c(z paramz, Context paramContext, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, Boolean paramBoolean1)
  {
    this.a = paramz;
    this.b = paramContext;
    this.d = paramString;
    this.f = paramBoolean1.booleanValue();
    this.j = paramz.a().b();
    this.h = paramContext.getResources().getDisplayMetrics().density;
    if (paramInt1 < paramInt2)
    {
      this.g = ((int)(this.j / 480.0F * paramInt1));
      this.e = paramInt2;
      com.jiubang.core.a.e.a(this.g, this.e);
      if (!paramBoolean) {
        break label211;
      }
    }
    for (;;)
    {
      try
      {
        paramz = Class.forName("com.android.internal.R$dimen");
        paramBoolean1 = paramz.newInstance();
        paramInt1 = Integer.parseInt(paramz.getField("status_bar_height").get(paramBoolean1).toString());
        this.i = paramContext.getResources().getDimensionPixelSize(paramInt1);
        com.gtp.a.a.b.c.a("dynamicbg", "mStatusBarHeight: " + this.i);
        a(paramContext, paramString);
        return;
        this.g = ((int)(this.j / 480.0F * paramInt2));
        this.e = paramInt1;
      }
      catch (Exception paramz)
      {
        paramz.printStackTrace();
        continue;
      }
      label211:
      this.i = 0.0F;
    }
  }
  
  public c(z paramz, Context paramContext, String paramString, boolean paramBoolean, Boolean paramBoolean1)
  {
    this.a = paramz;
    this.b = paramContext;
    this.d = paramString;
    this.f = paramBoolean1.booleanValue();
    this.j = paramz.a().b();
    paramz = paramContext.getResources().getDisplayMetrics();
    this.h = paramz.density;
    com.gtp.a.a.b.c.a("dynamicbg", "dm.widthPixels: " + paramz.widthPixels + " ,dm.heightPixels: " + paramz.heightPixels);
    if (paramz.widthPixels < paramz.heightPixels)
    {
      this.g = ((int)(this.j / 480.0F * paramz.widthPixels));
      this.e = paramz.heightPixels;
      com.gtp.a.a.b.c.a("dynamicbg", "mWidth: " + this.g + " ,mHeight: " + this.e);
      com.jiubang.core.a.e.a(this.g, this.e);
      if (!paramBoolean) {
        break label303;
      }
    }
    for (;;)
    {
      try
      {
        paramz = Class.forName("com.android.internal.R$dimen");
        paramBoolean1 = paramz.newInstance();
        int k = Integer.parseInt(paramz.getField("status_bar_height").get(paramBoolean1).toString());
        this.i = paramContext.getResources().getDimensionPixelSize(k);
        com.gtp.a.a.b.c.a("dynamicbg", "mStatusBarHeight: " + this.i);
        a(paramContext, paramString);
        return;
        this.g = ((int)(this.j / 480.0F * paramz.heightPixels));
        this.e = paramz.widthPixels;
      }
      catch (Exception paramz)
      {
        paramz.printStackTrace();
        continue;
      }
      label303:
      this.i = 0.0F;
    }
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return (paramFloat3 - paramFloat5) * paramFloat1 / (paramFloat2 - paramFloat4);
  }
  
  private float a(float paramFloat1, int paramInt, float paramFloat2)
  {
    if (paramInt == 1) {
      return paramFloat1;
    }
    return paramFloat1 * paramFloat2;
  }
  
  private int a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return (int)(paramFloat1 / this.j * this.g);
    case 1: 
      return (int)(paramFloat1 / this.j * this.g);
    case 2: 
      return (int)(paramFloat1 / this.j * this.g);
    case 3: 
      return (int)((paramFloat1 + paramFloat3) / this.j * this.g - paramFloat2) + 1;
    case 4: 
      return (int)((paramFloat1 + paramFloat3) / this.j * this.g - paramFloat2) + 1;
    }
    return (int)((paramFloat3 * 0.5F + paramFloat1) / this.j * this.g - paramFloat2 * 0.5F);
  }
  
  private int a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5)
  {
    switch (paramInt)
    {
    default: 
      return (int)(paramFloat1 / 800.0F * (this.e - paramFloat5));
    case 1: 
      return (int)(paramFloat1 / 800.0F * (this.e - paramFloat5));
    case 2: 
      return (int)(a(paramFloat1 / 800.0F * (800.0F - paramFloat4) + paramFloat3, 800.0F, this.e, paramFloat4, paramFloat5) - paramFloat2) + 1;
    case 3: 
      return (int)(paramFloat1 / 800.0F * (this.e - paramFloat5));
    case 4: 
      return (int)(a(paramFloat1 / 800.0F * (800.0F - paramFloat4) + paramFloat3, 800.0F, this.e, paramFloat4, paramFloat5) - paramFloat2) + 1;
    }
    return (int)(a(paramFloat3 * 0.5F + paramFloat1 / 800.0F * (800.0F - paramFloat4), 800.0F, this.e, paramFloat4, paramFloat5) - paramFloat2 * 0.5F);
  }
  
  private int a(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4)
  {
    if (paramInt1 == 1) {
      return a(paramFloat1, paramFloat3, paramFloat4, paramInt2, 38.0F, this.i);
    }
    return (int)(paramFloat1 * paramFloat2);
  }
  
  private int a(int paramInt1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramInt2 == 0) {
      return (int)(paramFloat1 / paramFloat2 * (paramFloat3 - paramFloat4));
    }
    return (int)(paramInt3 * paramFloat1 + paramInt1);
  }
  
  private Bitmap a(Resources paramResources, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int k;
    if (paramString1 != null)
    {
      k = paramResources.getIdentifier(paramString1, "drawable", paramString2);
      localObject1 = localObject2;
      if (k != 0)
      {
        paramString1 = new BitmapFactory.Options();
        paramString1.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramResources, k, paramString1);
        if ((!paramString1.outMimeType.equalsIgnoreCase("image/jpeg")) && (!paramString1.outMimeType.equalsIgnoreCase("image/bmp"))) {
          break label102;
        }
        paramString1 = new BitmapFactory.Options();
      }
    }
    for (paramString1.inPreferredConfig = Bitmap.Config.ALPHA_8;; paramString1.inPreferredConfig = Bitmap.Config.ARGB_8888)
    {
      try
      {
        localObject1 = BitmapFactory.decodeResource(paramResources, k, paramString1);
        return (Bitmap)localObject1;
      }
      catch (OutOfMemoryError paramResources)
      {
        label102:
        paramResources.printStackTrace();
        System.gc();
      }
      paramString1 = new BitmapFactory.Options();
    }
    return null;
  }
  
  private Bitmap a(Resources paramResources, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    int k;
    if (paramString1 != null)
    {
      k = paramResources.getIdentifier(paramString1, "drawable", paramString2);
      localObject1 = localObject3;
      if (k != 0)
      {
        paramString1 = new BitmapFactory.Options();
        paramString1.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramResources, k, paramString1);
        if ((!paramString1.outMimeType.equalsIgnoreCase("image/jpeg")) && (!paramString1.outMimeType.equalsIgnoreCase("image/bmp"))) {
          break label143;
        }
        paramString1 = new BitmapFactory.Options();
        paramString1.inPreferredConfig = Bitmap.Config.ALPHA_8;
      }
    }
    try
    {
      for (;;)
      {
        paramResources = BitmapFactory.decodeResource(paramResources, k, paramString1);
        localObject1 = paramResources;
        if (paramResources != null) {
          if (paramResources.getWidth() == paramInt1)
          {
            localObject1 = paramResources;
            if (paramResources.getHeight() == paramInt2) {
              break label140;
            }
          }
        }
        try
        {
          localObject1 = Bitmap.createScaledBitmap(paramResources, paramInt1, paramInt2, true);
          label140:
          return (Bitmap)localObject1;
        }
        catch (OutOfMemoryError paramString1)
        {
          label143:
          paramString1.printStackTrace();
          System.gc();
        }
        paramString1 = new BitmapFactory.Options();
        paramString1.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
    }
    catch (OutOfMemoryError paramResources)
    {
      for (;;)
      {
        paramResources.printStackTrace();
        System.gc();
        paramResources = (Resources)localObject2;
      }
    }
    return paramResources;
  }
  
  private j a(a parama)
  {
    return new i(1, parama.a(), parama.b(), parama.h(), 2, parama.f(), parama.g(), parama.c(), parama.d());
  }
  
  private j a(ad paramad, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    int k = paramad.q();
    int m = b(paramad.i(), paramad.m(), paramFloat3, k, paramFloat1, paramFloat5);
    int n = b(paramad.j(), paramad.n(), paramFloat3, k, paramFloat1, paramFloat5);
    return new h(1, 2, m, a(paramad.k(), paramad.o(), paramFloat4, k, paramFloat2, paramFloat6), n, a(paramad.l(), paramad.p(), paramFloat4, k, paramFloat2, paramFloat6), paramad.h(), 2, paramad.f(), paramad.g(), 0.0F, 0.0F, paramad.a(), paramad.b(), paramad.c(), paramad.d());
  }
  
  private j a(p paramp, int paramInt1, int paramInt2, HashMap paramHashMap)
  {
    com.jiubang.core.a.p localp = new com.jiubang.core.a.p(1, paramp.f(), paramp.g(), paramp.h(), 2, paramp.c(), paramp.d());
    Resources localResources = this.c.getResources();
    int m = paramp.a();
    int k = 0;
    if (k < m)
    {
      q localq = paramp.a(k);
      Bitmap localBitmap;
      if ((localq != null) && (localq.a != null) && (localq.a.length() > 0))
      {
        localBitmap = (Bitmap)paramHashMap.get(localq.a);
        if (localBitmap != null) {
          break label194;
        }
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
          break label174;
        }
        localBitmap = a(localResources, localq.a, this.d, paramInt1, paramInt2);
        label137:
        if (localBitmap != null) {
          localp.a(localBitmap, localq.b, localq.c, localq.d);
        }
      }
      for (;;)
      {
        k += 1;
        break;
        label174:
        localBitmap = a(localResources, localq.a, this.d);
        break label137;
        label194:
        localp.a(localBitmap, localq.b, localq.c, localq.d);
      }
    }
    return localp;
  }
  
  private j a(x paramx, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramx.a();
    float f2 = paramx.b();
    int k = paramx.k();
    paramFloat1 = paramx.i();
    if (k == 0)
    {
      paramFloat1 = paramFloat1 / this.j * this.g;
      paramInt1 = paramx.l();
      paramFloat2 = paramx.j();
      if (paramInt1 != 0) {
        break label143;
      }
    }
    label143:
    for (paramFloat2 = paramFloat2 / 800.0F * (this.e - this.i);; paramFloat2 *= paramInt2)
    {
      paramInt1 = paramx.h();
      paramInt2 = paramx.f();
      k = paramx.g();
      return new w(1, f1, f2, paramx.k(), paramFloat1, paramx.l(), paramFloat2, paramInt1, 2, paramInt2, k, paramx.c(), paramx.d());
      paramFloat1 *= paramInt1;
      break;
    }
  }
  
  private j a(y paramy, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = a(paramy.a(), paramy.o(), 1.0F);
    float f2 = a(paramy.b(), paramy.p(), 1.0F);
    float f3 = a(paramy.i(), paramy.q(), 1.0F);
    float f4 = a(paramy.j(), paramy.r(), 1.0F);
    int k = paramy.s();
    int m = paramy.m();
    paramFloat1 = paramy.k();
    if (m == 0)
    {
      paramFloat1 = a(paramFloat1, paramInt1, paramFloat3, k);
      paramInt1 = paramy.n();
      paramFloat2 = paramy.l();
      if (paramInt1 != 0) {
        break label196;
      }
    }
    label196:
    for (paramFloat2 = a(paramFloat2, paramInt2, paramFloat4, k, 38.0F, this.i);; paramFloat2 *= paramInt2)
    {
      return new com.jiubang.core.a.x(1, f1, f2, f3, f4, paramy.m(), paramFloat1, paramy.n(), paramFloat2, paramy.h(), 2, paramy.f(), paramy.g(), paramy.c(), paramy.d());
      paramFloat1 *= paramInt1;
      break;
    }
  }
  
  private k a(ab paramab, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, HashMap paramHashMap, float paramFloat3, float paramFloat4)
  {
    k localk = new k(1);
    int m = paramab.a();
    int k = 0;
    if (k < m)
    {
      Object localObject = paramab.b(k);
      if (localObject != null) {
        switch (((d)localObject).e())
        {
        default: 
          localObject = null;
        }
      }
      for (;;)
      {
        if (localObject != null) {
          localk.a((j)localObject);
        }
        k += 1;
        break;
        localObject = a((a)localObject);
        continue;
        localObject = a((x)localObject, paramInt1, paramInt2, paramFloat3, paramFloat4);
        continue;
        localObject = a((y)localObject, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        continue;
        localObject = a((ad)localObject, paramInt1, paramInt2, this.g, this.e, paramFloat3, paramFloat4);
        continue;
        localObject = a((ab)localObject, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramHashMap, paramFloat3, paramFloat4);
        continue;
        localObject = a((p)localObject, paramInt1, paramInt2, paramHashMap);
      }
    }
    return localk;
  }
  
  private k a(ab paramab, l paraml, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2)
  {
    k localk = new k(1);
    int i5 = paramab.a();
    int n = 0;
    Object localObject;
    m localm;
    int i6;
    int i7;
    int m;
    int i2;
    int i3;
    int i4;
    int k;
    int i1;
    if (n < i5)
    {
      localObject = paramab.b(n);
      if ((localObject != null) && (((d)localObject).e() == 7))
      {
        localObject = (g)localObject;
        localm = new m(1, ((g)localObject).f(), ((g)localObject).g(), ((g)localObject).h(), 2, ((g)localObject).c(), ((g)localObject).d());
        i6 = paraml.o().getWidth();
        i7 = paraml.o().getHeight();
        m = paraml.f();
        i2 = paraml.g();
        i3 = m + paraml.a();
        i4 = i2 + paraml.b();
        k = a(((g)localObject).a(), paramInt1, paramFloat1, 1);
        i1 = a(((g)localObject).b(), paramInt2, paramFloat2, 1, 38.0F, this.i);
        switch (((g)localObject).i())
        {
        default: 
          if (k > m)
          {
            k = m;
            m = i1;
          }
          break;
        }
      }
    }
    for (;;)
    {
      localm.a(k, m, ((g)localObject).i());
      localk.a(localm);
      n += 1;
      break;
      if (k > m)
      {
        k = m;
        m = i1;
      }
      else
      {
        if (k < m - i6)
        {
          k = m - i6;
          m = i1;
          continue;
          if (k < i3)
          {
            k = i3;
            m = i1;
            continue;
          }
          if (k > i3 + i6)
          {
            k = i3 + i6;
            m = i1;
            continue;
            if (i1 > i2)
            {
              m = i2;
              continue;
            }
            if (i1 < i2 - i7)
            {
              m = i2 - i7;
              continue;
              if (i1 < i4)
              {
                m = i4;
                continue;
              }
              if (i1 > i4 + i7)
              {
                m = i4 + i7;
                continue;
                if (k < m - i6)
                {
                  k = m - i6;
                  m = i1;
                  continue;
                  return localk;
                }
              }
            }
          }
        }
        m = i1;
      }
    }
  }
  
  private l a(r paramr, Resources paramResources, String paramString, int paramInt1, int paramInt2, HashMap paramHashMap)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    int n;
    int i1;
    int k;
    int m;
    float f2;
    float f1;
    if (paramr != null)
    {
      str = paramr.s();
      n = paramr.o();
      i1 = paramr.p();
      float f3 = 0.0F;
      float f4 = 0.0F;
      k = n;
      m = i1;
      f2 = f3;
      f1 = f4;
      if (n > 0)
      {
        k = n;
        m = i1;
        f2 = f3;
        f1 = f4;
        if (i1 > 0)
        {
          f2 = n;
          f1 = i1;
          k = (int)(f2 / this.j * this.g);
          m = (int)(f1 / 800.0F * this.e);
        }
      }
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = (Bitmap)paramHashMap.get(str);
        if (localObject1 != null) {
          break label584;
        }
        if ((k <= 0) || (m <= 0)) {
          break label572;
        }
        paramResources = a(paramResources, str, paramString, k, m);
        paramString = paramResources;
        if (paramResources != null)
        {
          paramHashMap.put(str, paramResources);
          paramString = paramResources;
        }
        label183:
        if (paramString == null)
        {
          localObject1 = localObject2;
          if (paramr.o() != 0)
          {
            localObject1 = localObject2;
            if (paramr.p() == 0) {}
          }
        }
        else
        {
          localObject1 = localObject2;
          if (paramString != null)
          {
            if ((k > 0) && (m > 0)) {
              break label590;
            }
            k = paramString.getWidth();
            m = paramString.getHeight();
            f2 = k / this.h * 1.5F;
            f1 = m / this.h * 1.5F;
          }
        }
      }
    }
    label572:
    label584:
    label590:
    for (;;)
    {
      i1 = paramr.v();
      n = b(paramr.q(), paramr.t(), paramInt1, i1, k, f2);
      i1 = a(paramr.r(), paramr.u(), paramInt2, i1, m, f1);
      paramResources = new com.jiubang.core.a.r(this.b, 1, n, i1, k, m, paramString);
      paramResources.a(paramr.b());
      paramResources.e(paramr.d());
      k = paramr.k();
      paramResources.f(a(n, paramr.g(), k, paramResources.a(), this.j, this.g, 0.0F));
      k = paramr.l();
      paramResources.g(a(i1, paramr.h(), k, paramResources.b(), 800.0F, this.e, this.i));
      paramResources.b(paramr.c());
      k = paramr.i();
      paramResources.c(a(n, paramr.e(), k, paramResources.a(), this.j, this.g, 0.0F));
      k = paramr.j();
      paramResources.d(a(i1, paramr.f(), k, paramResources.b(), 800.0F, this.e, this.i));
      paramResources.b(paramr.a());
      paramr = a(paramr.n(), paramResources.a(), paramResources.b(), paramInt1, paramInt2, n, i1, paramHashMap, f2, f1);
      localObject1 = paramResources;
      if (paramr != null)
      {
        paramResources.a(paramr);
        localObject1 = paramResources;
      }
      return (l)localObject1;
      paramResources = a(paramResources, str, paramString);
      break;
      paramString = (String)localObject1;
      break label183;
    }
  }
  
  private l a(t paramt, Resources paramResources, String paramString, int paramInt1, int paramInt2, HashMap paramHashMap)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int k;
    int m;
    float f1;
    float f2;
    if (paramt != null)
    {
      String str = paramt.s();
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = (Bitmap)paramHashMap.get(str);
        if (localObject1 != null) {
          break label283;
        }
        paramString = a(paramResources, str, paramString);
        paramResources = paramString;
        if (paramString != null)
        {
          paramHashMap.put(str, paramString);
          paramResources = paramString;
        }
        localObject1 = localObject2;
        if (paramResources != null)
        {
          k = paramt.o();
          m = paramt.p();
          if ((k > 0) && (m > 0)) {
            break label289;
          }
          k = paramResources.getWidth();
          m = paramResources.getHeight();
          f1 = k / this.h * 1.5F;
          f2 = m / this.h * 1.5F;
        }
      }
    }
    for (;;)
    {
      int n = paramt.v();
      paramInt1 = b(paramt.q(), paramt.t(), paramInt1, n, k, f1);
      paramInt2 = a(paramt.r(), paramt.u(), paramInt2, n, m, f2);
      paramResources = new n(this.b, 1, paramInt1, paramInt2, k, m, paramResources);
      paramString = paramt.n();
      paramt = new k(1);
      paramString = (ab)paramString.b(0);
      localObject1 = paramResources;
      if (paramString != null)
      {
        paramString = a(paramString, paramResources, k, f1, m, f2);
        localObject1 = paramResources;
        if (paramString != null)
        {
          paramt.a(paramString);
          paramResources.a(paramt);
          localObject1 = paramResources;
        }
      }
      return (l)localObject1;
      label283:
      paramResources = (Resources)localObject1;
      break;
      label289:
      f1 = k;
      f2 = m;
      k = (int)(f1 / this.j * this.g);
      m = (int)(f2 / 800.0F * this.e);
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    this.c = paramContext;
    if (!paramString.equals(paramContext.getPackageName())) {}
    try
    {
      this.c = paramContext.createPackageContext(paramString, 3);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private int b(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4)
  {
    if (paramInt1 == 1) {
      return a(paramFloat1, paramFloat3, paramFloat4, paramInt2);
    }
    return (int)(paramFloat1 * paramFloat2);
  }
  
  public com.jiubang.core.a.o a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Resources localResources = this.c.getResources();
    Object localObject13 = this.a.d();
    Object localObject14 = this.a.f();
    Object localObject1 = null;
    Object localObject12 = null;
    int k = 1;
    int m = 1;
    String str;
    Object localObject8;
    Object localObject10;
    label118:
    int i1;
    int n;
    if (localObject13 != null)
    {
      str = ((b)localObject13).a();
      localObject8 = (Bitmap)localHashMap.get(str);
      if (localObject8 == null)
      {
        localObject8 = localObject1;
        if (str != null)
        {
          localObject10 = a(localResources, str, paramString);
          localObject8 = localObject1;
          if (localObject10 != null)
          {
            localHashMap.put(str, localObject10);
            localObject8 = localObject10;
          }
        }
        if ((!this.f) || (((b)localObject13).g())) {
          break label540;
        }
        localObject1 = localObject12;
        k = ((b)localObject13).b();
        if (localObject8 == null) {
          break label763;
        }
        i1 = ((Bitmap)localObject8).getWidth();
        m = ((Bitmap)localObject8).getHeight();
        localObject10 = localObject8;
        localObject8 = localObject1;
        n = k;
        localObject1 = localObject10;
        k = i1;
      }
    }
    for (;;)
    {
      label179:
      if (localObject14 != null)
      {
        localObject12 = ((o)localObject14).a();
        localObject10 = (Bitmap)localHashMap.get(localObject12);
        if (localObject10 == null)
        {
          if (localObject12 == null) {
            break label1138;
          }
          localObject10 = a(localResources, (String)localObject12, paramString);
          if (localObject10 == null) {
            break label1138;
          }
          localHashMap.put(localObject12, localObject10);
          label239:
          localObject14 = new com.jiubang.core.a.o(this.b, 1, 0, 0, k, m, (Bitmap)localObject1, (Bitmap)localObject10);
          ((com.jiubang.core.a.o)localObject14).b((Bitmap)localObject8);
          ((com.jiubang.core.a.o)localObject14).a(n);
          if (localObject13 != null) {
            ((com.jiubang.core.a.o)localObject14).b(((b)localObject13).e());
          }
          localObject13 = this.a.b();
          localObject1 = null;
          if (localObject13 != null)
          {
            localObject12 = null;
            localObject1 = null;
            str = ((aa)localObject13).a();
            localObject8 = localObject1;
            if ((Bitmap)localHashMap.get(str) == null)
            {
              localObject8 = localObject1;
              if (str != null) {
                localObject8 = a(localResources, str, paramString);
              }
            }
            localObject10 = new com.jiubang.core.a.y(this.b, 1, 0, 0, this.g, this.e, (Bitmap)localObject8);
            ((com.jiubang.core.a.y)localObject10).b(((aa)localObject13).e());
            if ((!this.f) || (((aa)localObject13).g())) {
              break label800;
            }
            localObject1 = localObject12;
            label412:
            ((com.jiubang.core.a.y)localObject10).b((Bitmap)localObject1);
            localObject1 = localObject10;
          }
          if (localObject1 != null) {
            ((com.jiubang.core.a.o)localObject14).a((l)localObject1);
          }
          i1 = this.a.h();
          n = 0;
          localObject1 = null;
          for (;;)
          {
            if (n < i1)
            {
              localObject10 = this.a.b(n);
              localObject8 = localObject1;
              if (localObject10 != null) {}
              switch (((t)localObject10).m())
              {
              default: 
                label504:
                localObject8 = localObject1;
                if (localObject1 != null)
                {
                  ((com.jiubang.core.a.o)localObject14).a((l)localObject1);
                  localObject8 = localObject1;
                }
                n += 1;
                localObject1 = localObject8;
                continue;
                break label118;
                label540:
                if ((this.f) && (((b)localObject13).g()))
                {
                  localObject12 = str + "blur";
                  localObject10 = (Bitmap)localHashMap.get(localObject12);
                  localObject1 = localObject10;
                  if ((localObject10 == null) && ((localObject12 == null) || (localObject8 == null))) {
                    break label1144;
                  }
                }
                break;
              }
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = com.go.weatherex.home.a.e.a(this.b, (Bitmap)localObject8, 15);
          if (localObject1 == null) {
            break label1144;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError6)
        {
          try
          {
            localHashMap.put(localObject12, localObject1);
            break;
            localObject1 = localObject12;
            if (this.f) {
              break;
            }
            localObject1 = localObject12;
            if (!((b)localObject13).f()) {
              break;
            }
            str = str + "blur";
            localObject1 = (Bitmap)localHashMap.get(str);
            if (localObject1 == null)
            {
              localObject1 = localObject12;
              if (str == null) {
                break;
              }
              localObject1 = localObject12;
              if (localObject8 == null) {
                break;
              }
            }
            try
            {
              localObject10 = com.go.weatherex.home.a.e.a(this.b, (Bitmap)localObject8, 15);
              localObject1 = localObject12;
              if (localObject10 == null) {
                break;
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError4)
            {
              label763:
              label800:
              Object localObject5 = localObject12;
            }
            try
            {
              localHashMap.put(str, localObject10);
              localObject1 = localObject10;
            }
            catch (OutOfMemoryError localOutOfMemoryError5)
            {
              Object localObject6 = localObject10;
            }
            break;
            i1 = ((b)localObject13).c();
            m = ((b)localObject13).d();
            n = k;
            localObject10 = localObject1;
            localObject1 = localObject8;
            k = i1;
            localObject8 = localObject10;
            break label179;
            break label239;
            if ((this.f) && (((aa)localObject13).g()))
            {
              localObject13 = str + "blur";
              localObject12 = (Bitmap)localHashMap.get(localObject13);
              localObject1 = localObject12;
              if ((localObject12 == null) && ((localObject13 == null) || (localObject8 == null))) {}
            }
            else
            {
              try
              {
                localObject1 = com.go.weatherex.home.a.e.a(this.b, (Bitmap)localObject8, 15);
                if (localObject1 == null) {
                  continue;
                }
              }
              catch (OutOfMemoryError localOutOfMemoryError3)
              {
                try
                {
                  localHashMap.put(localObject13, localObject1);
                  break label412;
                  localObject1 = localObject12;
                  if (this.f) {
                    break label412;
                  }
                  localObject1 = localObject12;
                  if (!((aa)localObject13).f()) {
                    break label412;
                  }
                  localObject13 = str + "blur";
                  localObject1 = (Bitmap)localHashMap.get(localObject13);
                  if (localObject1 == null)
                  {
                    localObject1 = localObject12;
                    if (localObject13 == null) {
                      break label412;
                    }
                    localObject1 = localObject12;
                    if (localObject8 == null) {
                      break label412;
                    }
                  }
                  try
                  {
                    localObject8 = com.go.weatherex.home.a.e.a(this.b, (Bitmap)localObject8, 15);
                    localObject1 = localObject12;
                    if (localObject8 == null) {
                      break label412;
                    }
                  }
                  catch (OutOfMemoryError localOutOfMemoryError1)
                  {
                    Object localObject2 = localObject12;
                  }
                  try
                  {
                    localHashMap.put(localObject13, localObject8);
                    localObject1 = localObject8;
                  }
                  catch (OutOfMemoryError localOutOfMemoryError2)
                  {
                    Object localObject3 = localObject8;
                  }
                  break label412;
                  localObject1 = a((r)localObject10, localResources, paramString, k, m, localHashMap);
                  break label504;
                  localObject1 = a((t)localObject10, localResources, paramString, k, m, localHashMap);
                  break label504;
                  localHashMap.clear();
                  return (com.jiubang.core.a.o)localObject14;
                  break label412;
                  break label412;
                  localOutOfMemoryError3 = localOutOfMemoryError3;
                  Object localObject4 = null;
                  continue;
                }
                catch (OutOfMemoryError localOutOfMemoryError7)
                {
                  continue;
                }
              }
              break;
              break;
              localOutOfMemoryError6 = localOutOfMemoryError6;
              localObject7 = null;
              continue;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError8)
          {
            continue;
            localObject7 = null;
            continue;
          }
        }
        label1138:
        Object localObject11 = null;
        break label239;
        label1144:
        localObject7 = null;
      }
      n = 0;
      Object localObject9 = null;
      Object localObject7 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */