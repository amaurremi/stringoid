package com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.gowidget.scriptengine.parser.ab;
import com.gau.go.launcherex.gowidget.scriptengine.parser.ad;
import com.gau.go.launcherex.gowidget.scriptengine.parser.b;
import com.gau.go.launcherex.gowidget.scriptengine.parser.d;
import com.gau.go.launcherex.gowidget.scriptengine.parser.g;
import com.gau.go.launcherex.gowidget.scriptengine.parser.q;
import com.gau.go.launcherex.gowidget.scriptengine.parser.t;
import com.gau.go.launcherex.gowidget.scriptengine.parser.y;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import com.jiubang.core.a.e;
import com.jiubang.core.a.h;
import com.jiubang.core.a.i;
import com.jiubang.core.a.j;
import com.jiubang.core.a.k;
import com.jiubang.core.a.l;
import com.jiubang.core.a.m;
import com.jiubang.core.a.n;
import com.jiubang.core.a.w;
import java.util.HashMap;

public class a
{
  private z a;
  private Context b;
  private Context c;
  private String d;
  private int e;
  private int f;
  private float g;
  private float h;
  
  public a(z paramz, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramz;
    this.b = paramContext;
    this.d = paramString;
    this.h = 200.0F;
    this.g = paramContext.getResources().getDisplayMetrics().density;
    this.f = paramInt1;
    this.e = paramInt2;
    e.a(this.f, this.e);
    a(paramContext, paramString);
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
      return (int)(paramFloat1 / this.h * this.f);
    case 1: 
      return (int)(paramFloat1 / this.h * this.f);
    case 2: 
      return (int)(paramFloat1 / this.h * this.f);
    case 3: 
      return (int)((paramFloat1 + paramFloat3) / this.h * this.f - paramFloat2) + 1;
    case 4: 
      return (int)((paramFloat1 + paramFloat3) / this.h * this.f - paramFloat2) + 1;
    }
    return (int)((paramFloat3 * 0.5F + paramFloat1) / this.h * this.f - paramFloat2 * 0.5F);
  }
  
  private int a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5)
  {
    switch (paramInt)
    {
    default: 
      return (int)(paramFloat1 / 200.0F * (this.e - paramFloat5));
    case 1: 
      return (int)(paramFloat1 / 200.0F * (this.e - paramFloat5));
    case 2: 
      return (int)(a(paramFloat1 / 200.0F * (200.0F - paramFloat4) + paramFloat3, 200.0F, this.e, paramFloat4, paramFloat5) - paramFloat2) + 1;
    case 3: 
      return (int)(paramFloat1 / 200.0F * (this.e - paramFloat5));
    case 4: 
      return (int)(a(paramFloat1 / 200.0F * (200.0F - paramFloat4) + paramFloat3, 200.0F, this.e, paramFloat4, paramFloat5) - paramFloat2) + 1;
    }
    return (int)(a(paramFloat3 * 0.5F + paramFloat1 / 200.0F * (200.0F - paramFloat4), 200.0F, this.e, paramFloat4, paramFloat5) - paramFloat2 * 0.5F);
  }
  
  private int a(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4)
  {
    if (paramInt1 == 1) {
      return a(paramFloat1, paramFloat3, paramFloat4, paramInt2, 0.0F, 0.0F);
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
    int i;
    if (paramString1 != null)
    {
      i = paramResources.getIdentifier(paramString1, "drawable", paramString2);
      localObject1 = localObject2;
      if (i != 0)
      {
        paramString1 = new BitmapFactory.Options();
        paramString1.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
    }
    try
    {
      localObject1 = BitmapFactory.decodeResource(paramResources, i, paramString1);
      return (Bitmap)localObject1;
    }
    catch (OutOfMemoryError paramResources)
    {
      paramResources.printStackTrace();
      System.gc();
    }
    return null;
  }
  
  private Bitmap a(Resources paramResources, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    int i;
    if (paramString1 != null)
    {
      i = paramResources.getIdentifier(paramString1, "drawable", paramString2);
      localObject1 = localObject3;
      if (i != 0)
      {
        paramString1 = new BitmapFactory.Options();
        paramString1.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
    }
    try
    {
      paramResources = BitmapFactory.decodeResource(paramResources, i, paramString1);
      localObject1 = paramResources;
      if (paramResources != null) {
        if (paramResources.getWidth() == paramInt1)
        {
          localObject1 = paramResources;
          if (paramResources.getHeight() == paramInt2) {
            break label95;
          }
        }
      }
    }
    catch (OutOfMemoryError paramResources)
    {
      for (;;)
      {
        try
        {
          localObject1 = Bitmap.createScaledBitmap(paramResources, paramInt1, paramInt2, true);
          label95:
          return (Bitmap)localObject1;
        }
        catch (OutOfMemoryError paramString1)
        {
          paramString1.printStackTrace();
          System.gc();
        }
        paramResources = paramResources;
        paramResources.printStackTrace();
        System.gc();
        paramResources = (Resources)localObject2;
      }
    }
    return paramResources;
  }
  
  private j a(com.gau.go.launcherex.gowidget.scriptengine.parser.a parama)
  {
    return new i(1, parama.a(), parama.b(), parama.h(), 2, parama.f(), parama.g(), parama.c(), parama.d());
  }
  
  private j a(ad paramad, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    int i = paramad.q();
    int j = b(paramad.i(), paramad.m(), paramFloat3, i, paramFloat1, paramFloat5);
    int k = b(paramad.j(), paramad.n(), paramFloat3, i, paramFloat1, paramFloat5);
    return new h(1, 2, j, a(paramad.k(), paramad.o(), paramFloat4, i, paramFloat2, paramFloat6), k, a(paramad.l(), paramad.p(), paramFloat4, i, paramFloat2, paramFloat6), paramad.h(), 2, paramad.f(), paramad.g(), 0.0F, 0.0F, paramad.a(), paramad.b(), paramad.c(), paramad.d());
  }
  
  private j a(com.gau.go.launcherex.gowidget.scriptengine.parser.p paramp, int paramInt1, int paramInt2, HashMap paramHashMap)
  {
    com.jiubang.core.a.p localp = new com.jiubang.core.a.p(1, paramp.f(), paramp.g(), paramp.h(), 2, paramp.c(), paramp.d());
    Resources localResources = this.c.getResources();
    int j = paramp.a();
    int i = 0;
    if (i < j)
    {
      q localq = paramp.a(i);
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
        i += 1;
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
  
  private j a(com.gau.go.launcherex.gowidget.scriptengine.parser.x paramx, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramx.a();
    float f2 = paramx.b();
    int i = paramx.k();
    paramFloat1 = paramx.i();
    if (i == 0)
    {
      paramFloat1 = paramFloat1 / this.h * this.f;
      paramInt1 = paramx.l();
      paramFloat2 = paramx.j();
      if (paramInt1 != 0) {
        break label138;
      }
    }
    label138:
    for (paramFloat2 = paramFloat2 / 200.0F * this.e;; paramFloat2 *= paramInt2)
    {
      paramInt1 = paramx.h();
      paramInt2 = paramx.f();
      i = paramx.g();
      return new w(1, f1, f2, paramx.k(), paramFloat1, paramx.l(), paramFloat2, paramInt1, 2, paramInt2, i, paramx.c(), paramx.d());
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
    int i = paramy.s();
    int j = paramy.m();
    paramFloat1 = paramy.k();
    if (j == 0)
    {
      paramFloat1 = a(paramFloat1, paramInt1, paramFloat3, i);
      paramInt1 = paramy.n();
      paramFloat2 = paramy.l();
      if (paramInt1 != 0) {
        break label192;
      }
    }
    label192:
    for (paramFloat2 = a(paramFloat2, paramInt2, paramFloat4, i, 0.0F, 0.0F);; paramFloat2 *= paramInt2)
    {
      return new com.jiubang.core.a.x(1, f1, f2, f3, f4, paramy.m(), paramFloat1, paramy.n(), paramFloat2, paramy.h(), 2, paramy.f(), paramy.g(), paramy.c(), paramy.d());
      paramFloat1 *= paramInt1;
      break;
    }
  }
  
  private k a(ab paramab, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, HashMap paramHashMap, float paramFloat3, float paramFloat4)
  {
    k localk = new k(1);
    int j = paramab.a();
    int i = 0;
    if (i < j)
    {
      Object localObject = paramab.b(i);
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
        i += 1;
        break;
        localObject = a((com.gau.go.launcherex.gowidget.scriptengine.parser.a)localObject);
        continue;
        localObject = a((com.gau.go.launcherex.gowidget.scriptengine.parser.x)localObject, paramInt1, paramInt2, paramFloat3, paramFloat4);
        continue;
        localObject = a((y)localObject, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        continue;
        localObject = a((ad)localObject, paramInt1, paramInt2, this.f, this.e, paramFloat3, paramFloat4);
        continue;
        localObject = a((ab)localObject, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramHashMap, paramFloat3, paramFloat4);
        continue;
        localObject = a((com.gau.go.launcherex.gowidget.scriptengine.parser.p)localObject, paramInt1, paramInt2, paramHashMap);
      }
    }
    return localk;
  }
  
  private k a(ab paramab, l paraml, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2)
  {
    k localk = new k(1);
    int i3 = paramab.a();
    int k = 0;
    Object localObject;
    m localm;
    int i4;
    int i5;
    int j;
    int n;
    int i1;
    int i2;
    int i;
    int m;
    if (k < i3)
    {
      localObject = paramab.b(k);
      if ((localObject != null) && (((d)localObject).e() == 7))
      {
        localObject = (g)localObject;
        localm = new m(1, ((g)localObject).f(), ((g)localObject).g(), ((g)localObject).h(), 2, ((g)localObject).c(), ((g)localObject).d());
        i4 = paraml.o().getWidth();
        i5 = paraml.o().getHeight();
        j = paraml.f();
        n = paraml.g();
        i1 = j + paraml.a();
        i2 = n + paraml.b();
        i = a(((g)localObject).a(), paramInt1, paramFloat1, 1);
        m = a(((g)localObject).b(), paramInt2, paramFloat2, 1, 0.0F, 0.0F);
        switch (((g)localObject).i())
        {
        default: 
          if (i > j)
          {
            i = j;
            j = m;
          }
          break;
        }
      }
    }
    for (;;)
    {
      localm.a(i, j, ((g)localObject).i());
      localk.a(localm);
      k += 1;
      break;
      if (i > j)
      {
        i = j;
        j = m;
      }
      else
      {
        if (i < j - i4)
        {
          i = j - i4;
          j = m;
          continue;
          if (i < i1)
          {
            i = i1;
            j = m;
            continue;
          }
          if (i > i1 + i4)
          {
            i = i1 + i4;
            j = m;
            continue;
            if (m > n)
            {
              j = n;
              continue;
            }
            if (m < n - i5)
            {
              j = n - i5;
              continue;
              if (m < i2)
              {
                j = i2;
                continue;
              }
              if (m > i2 + i5)
              {
                j = i2 + i5;
                continue;
                if (i < j - i4)
                {
                  i = j - i4;
                  j = m;
                  continue;
                  return localk;
                }
              }
            }
          }
        }
        j = m;
      }
    }
  }
  
  private l a(com.gau.go.launcherex.gowidget.scriptengine.parser.r paramr, Resources paramResources, String paramString, int paramInt1, int paramInt2, HashMap paramHashMap)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    int k;
    int m;
    int i;
    int j;
    float f2;
    float f1;
    if (paramr != null)
    {
      str = paramr.s();
      k = paramr.o();
      m = paramr.p();
      float f3 = 0.0F;
      float f4 = 0.0F;
      i = k;
      j = m;
      f2 = f3;
      f1 = f4;
      if (k > 0)
      {
        i = k;
        j = m;
        f2 = f3;
        f1 = f4;
        if (m > 0)
        {
          f2 = k;
          f1 = m;
          i = (int)(f2 / this.h * this.f);
          j = (int)(f1 / 200.0F * this.e);
        }
      }
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = (Bitmap)paramHashMap.get(str);
        if (localObject1 != null) {
          break label578;
        }
        if ((i <= 0) || (j <= 0)) {
          break label566;
        }
        paramResources = a(paramResources, str, paramString, i, j);
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
            if ((i > 0) && (j > 0)) {
              break label584;
            }
            i = paramString.getWidth();
            j = paramString.getHeight();
            f2 = i / this.g * 1.5F;
            f1 = j / this.g * 1.5F;
          }
        }
      }
    }
    label566:
    label578:
    label584:
    for (;;)
    {
      m = paramr.v();
      k = b(paramr.q(), paramr.t(), paramInt1, m, i, f2);
      m = a(paramr.r(), paramr.u(), paramInt2, m, j, f1);
      paramResources = new com.jiubang.core.a.r(this.b, 1, k, m, i, j, paramString);
      paramResources.a(paramr.b());
      paramResources.e(paramr.d());
      i = paramr.k();
      paramResources.f(a(k, paramr.g(), i, paramResources.a(), this.h, this.f, 0.0F));
      i = paramr.l();
      paramResources.g(a(m, paramr.h(), i, paramResources.b(), 200.0F, this.e, 0.0F));
      paramResources.b(paramr.c());
      i = paramr.i();
      paramResources.c(a(k, paramr.e(), i, paramResources.a(), this.h, this.f, 0.0F));
      i = paramr.j();
      paramResources.d(a(m, paramr.f(), i, paramResources.b(), 200.0F, this.e, 0.0F));
      paramResources.b(paramr.a());
      paramr = a(paramr.n(), paramResources.a(), paramResources.b(), paramInt1, paramInt2, k, m, paramHashMap, f2, f1);
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
    int i;
    int j;
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
          i = paramt.o();
          j = paramt.p();
          if ((i > 0) && (j > 0)) {
            break label289;
          }
          i = paramResources.getWidth();
          j = paramResources.getHeight();
          f1 = i / this.g * 1.5F;
          f2 = j / this.g * 1.5F;
        }
      }
    }
    for (;;)
    {
      int k = paramt.v();
      paramInt1 = b(paramt.q(), paramt.t(), paramInt1, k, i, f1);
      paramInt2 = a(paramt.r(), paramt.u(), paramInt2, k, j, f2);
      paramResources = new n(this.b, 1, paramInt1, paramInt2, i, j, paramResources);
      paramString = paramt.n();
      paramt = new k(1);
      paramString = (ab)paramString.b(0);
      localObject1 = paramResources;
      if (paramString != null)
      {
        paramString = a(paramString, paramResources, i, f1, j, f2);
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
      f1 = i;
      f2 = j;
      i = (int)(f1 / this.h * this.f);
      j = (int)(f2 / 200.0F * this.e);
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
    Object localObject4 = this.a.d();
    Object localObject3 = this.a.f();
    Object localObject2;
    Object localObject1;
    int i;
    int m;
    int j;
    int k;
    if (localObject4 != null)
    {
      String str = ((b)localObject4).a();
      localObject2 = (Bitmap)localHashMap.get(str);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (str != null)
        {
          localObject1 = a(localResources, str, paramString);
          if (localObject1 != null) {
            localHashMap.put(str, localObject1);
          }
        }
      }
      else
      {
        i = ((b)localObject4).b();
        if (localObject1 != null)
        {
          m = ((Bitmap)localObject1).getWidth();
          j = ((Bitmap)localObject1).getHeight();
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      if (localObject3 != null)
      {
        localObject3 = ((com.gau.go.launcherex.gowidget.scriptengine.parser.o)localObject3).a();
        localObject2 = (Bitmap)localHashMap.get(localObject3);
        if (localObject2 == null)
        {
          if (localObject3 == null) {
            break label393;
          }
          localObject2 = a(localResources, (String)localObject3, paramString);
          if (localObject2 == null) {
            break label393;
          }
          localHashMap.put(localObject3, localObject2);
        }
      }
      for (;;)
      {
        label190:
        localObject3 = new com.jiubang.core.a.o(this.b, 1, 0, 0, i, j, (Bitmap)localObject1, (Bitmap)localObject2);
        ((com.jiubang.core.a.o)localObject3).a(k);
        m = this.a.h();
        k = 0;
        localObject1 = null;
        label234:
        if (k < m)
        {
          localObject4 = this.a.b(k);
          localObject2 = localObject1;
          if (localObject4 != null) {
            switch (((t)localObject4).m())
            {
            }
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              ((com.jiubang.core.a.o)localObject3).a((l)localObject1);
              localObject2 = localObject1;
            }
            k += 1;
            localObject1 = localObject2;
            break label234;
            m = ((b)localObject4).c();
            j = ((b)localObject4).d();
            k = i;
            i = m;
            break;
            break label190;
            localObject1 = a((com.gau.go.launcherex.gowidget.scriptengine.parser.r)localObject4, localResources, paramString, i, j, localHashMap);
            continue;
            localObject1 = a((t)localObject4, localResources, paramString, i, j, localHashMap);
          }
        }
        localHashMap.clear();
        return (com.jiubang.core.a.o)localObject3;
        label393:
        localObject2 = null;
      }
      localObject1 = null;
      break;
      j = 1;
      i = 1;
      k = -1;
      localObject1 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/widget/dynamicicon/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */