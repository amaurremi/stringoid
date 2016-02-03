package com.android.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.android.a.ab;
import com.android.a.f;
import com.android.a.o;
import com.android.a.p;
import com.android.a.r;
import com.android.a.t;
import com.android.a.u;
import com.android.a.v;

public class m
  extends p
{
  private static final Object e = new Object();
  private final v a;
  private Bitmap.Config b;
  private final int c;
  private final int d;
  
  public m(String paramString, v paramv, int paramInt1, int paramInt2, Bitmap.Config paramConfig, u paramu)
  {
    super(0, paramString, paramu);
    a(new f(1000, 2, 2.0F));
    this.a = paramv;
    this.b = paramConfig;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    for (float f = 1.0F;; f *= 2.0F) {
      if (f * 2.0F > d1) {
        return (int)f;
      }
    }
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      i = paramInt3;
    }
    double d1;
    do
    {
      do
      {
        return i;
        if (paramInt1 == 0) {
          return (int)(paramInt2 / paramInt4 * paramInt3);
        }
        i = paramInt1;
      } while (paramInt2 == 0);
      d1 = paramInt4 / paramInt3;
      i = paramInt1;
    } while (paramInt1 * d1 <= paramInt2);
    return (int)(paramInt2 / d1);
  }
  
  private t b(com.android.a.m paramm)
  {
    Object localObject1 = paramm.b;
    if ((localObject1 != null) && (localObject1.length >= 4) && (localObject1[1] == 80) && (localObject1[2] == 78) && (localObject1[3] == 71)) {
      this.b = Bitmap.Config.ARGB_8888;
    }
    Object localObject2 = new BitmapFactory.Options();
    if ((this.c == 0) && (this.d == 0))
    {
      ((BitmapFactory.Options)localObject2).inPreferredConfig = this.b;
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
    }
    while (localObject1 == null)
    {
      return t.a(new o(paramm));
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      int i = ((BitmapFactory.Options)localObject2).outWidth;
      int j = ((BitmapFactory.Options)localObject2).outHeight;
      ((BitmapFactory.Options)localObject2).inPreferredConfig = this.b;
      int k = b(this.c, this.d, i, j);
      int m = b(this.d, this.c, j, i);
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject2).inSampleSize = a(i, j, k, m);
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      if ((localObject1 != null) && ((((Bitmap)localObject1).getWidth() > k) || (((Bitmap)localObject1).getHeight() > m)))
      {
        localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, k, m, true);
        ((Bitmap)localObject1).recycle();
        localObject1 = localObject2;
      }
    }
    return t.a(localObject1, i.a(paramm));
  }
  
  protected t a(com.android.a.m paramm)
  {
    synchronized (e)
    {
      try
      {
        t localt = b(paramm);
        return localt;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ab.c("Caught OOM for %d byte image, url=%s", new Object[] { Integer.valueOf(paramm.b.length), d() });
        paramm = t.a(new o(localOutOfMemoryError));
        return paramm;
      }
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.a.a(paramBitmap);
  }
  
  public r s()
  {
    return r.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */