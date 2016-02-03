package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gw.a;
import com.google.android.gms.internal.gx;

public abstract class a
{
  final i Fm;
  protected int Fn = 0;
  protected int Fo = 0;
  private boolean Fp = true;
  private boolean Fq = false;
  protected int Fr;
  
  public a(Uri paramUri, int paramInt)
  {
    this.Fm = new i(paramUri);
    this.Fo = paramInt;
  }
  
  private Drawable a(Context paramContext, gw paramgw, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (this.Fr > 0)
    {
      gw.a locala = new gw.a(paramInt, this.Fr);
      Drawable localDrawable = (Drawable)paramgw.get(locala);
      paramContext = localDrawable;
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        paramContext = localDrawable;
        if ((this.Fr & 0x1) != 0) {
          paramContext = a(localResources, localDrawable);
        }
        paramgw.put(locala, paramContext);
      }
      return paramContext;
    }
    return localResources.getDrawable(paramInt);
  }
  
  protected Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return gu.a(paramResources, paramDrawable);
  }
  
  protected gt a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof gt)) {}
    }
    for (Drawable localDrawable = ((gt)paramDrawable1).fg();; localDrawable = null) {
      return new gt(localDrawable, paramDrawable2);
    }
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    gx.c(paramBitmap);
    Bitmap localBitmap = paramBitmap;
    if ((this.Fr & 0x1) != 0) {
      localBitmap = gu.a(paramBitmap);
    }
    a(new BitmapDrawable(paramContext.getResources(), localBitmap), paramBoolean, false, true);
  }
  
  void a(Context paramContext, gw paramgw)
  {
    Drawable localDrawable = null;
    if (this.Fn != 0) {
      localDrawable = a(paramContext, paramgw, this.Fn);
    }
    a(localDrawable, false, true, false);
  }
  
  void a(Context paramContext, gw paramgw, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.Fo != 0) {
      localDrawable = a(paramContext, paramgw, this.Fo);
    }
    a(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public void aj(int paramInt)
  {
    this.Fo = paramInt;
  }
  
  protected boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.Fp) && (!paramBoolean2) && ((!paramBoolean1) || (this.Fq));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */