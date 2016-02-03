package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.cp;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.dy;
import com.google.android.gms.internal.ec;
import java.lang.ref.WeakReference;

public final class a
{
  private WeakReference<TextView> sA;
  private int sB;
  private boolean sC;
  private boolean sD;
  private int sE;
  final a su;
  private int sv;
  int sw;
  private int sx;
  private WeakReference<ImageManager.a> sy;
  private WeakReference<ImageView> sz;
  
  private co a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof co)) {}
    }
    for (Drawable localDrawable = ((co)paramDrawable1).qf();; localDrawable = null) {
      return new co(localDrawable, paramDrawable2);
    }
  }
  
  private void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    switch (this.sw)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramBoolean2);
          localObject = (ImageManager.a)this.sy.get();
        } while (localObject == null);
        ((ImageManager.a)localObject).a(this.su.uri, paramDrawable, paramBoolean3);
        return;
        localObject = (ImageView)this.sz.get();
      } while (localObject == null);
      a((ImageView)localObject, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      return;
      localObject = (TextView)this.sA.get();
    } while (localObject == null);
    a((TextView)localObject, this.sB, paramDrawable, paramBoolean1, paramBoolean2);
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean2) && (!paramBoolean3)) {}
    for (int i = 1; (i != 0) && ((paramImageView instanceof ec)); i = 0)
    {
      int j = ((ec)paramImageView).qh();
      if ((this.sv == 0) || (j != this.sv)) {
        break;
      }
      return;
    }
    paramBoolean1 = c(paramBoolean1, paramBoolean2);
    if (paramBoolean1) {
      paramDrawable = a(paramImageView.getDrawable(), paramDrawable);
    }
    for (;;)
    {
      paramImageView.setImageDrawable(paramDrawable);
      ec localec;
      if ((paramImageView instanceof ec))
      {
        localec = (ec)paramImageView;
        if (!paramBoolean3) {
          break label149;
        }
        paramImageView = this.su.uri;
        label110:
        localec.d(paramImageView);
        if (i == 0) {
          break label154;
        }
      }
      label149:
      label154:
      for (i = this.sv;; i = 0)
      {
        localec.cE(i);
        if (!paramBoolean1) {
          break;
        }
        ((co)paramDrawable).startTransition(250);
        return;
        paramImageView = null;
        break label110;
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = c(paramBoolean1, paramBoolean2);
    Object localObject;
    Drawable localDrawable1;
    if (dy.ra())
    {
      localObject = paramTextView.getCompoundDrawablesRelative();
      localDrawable1 = localObject[paramInt];
      if (!paramBoolean1) {
        break label166;
      }
      paramDrawable = a(localDrawable1, paramDrawable);
    }
    label48:
    label56:
    label64:
    label72:
    label124:
    label133:
    label142:
    label151:
    label166:
    for (;;)
    {
      Drawable localDrawable2;
      Drawable localDrawable3;
      if (paramInt == 0)
      {
        localDrawable1 = paramDrawable;
        if (paramInt != 1) {
          break label124;
        }
        localDrawable2 = paramDrawable;
        if (paramInt != 2) {
          break label133;
        }
        localDrawable3 = paramDrawable;
        if (paramInt != 3) {
          break label142;
        }
        localObject = paramDrawable;
        if (!dy.ra()) {
          break label151;
        }
        paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, (Drawable)localObject);
      }
      for (;;)
      {
        if (paramBoolean1) {
          ((co)paramDrawable).startTransition(250);
        }
        return;
        localObject = paramTextView.getCompoundDrawables();
        break;
        localDrawable1 = localObject[0];
        break label48;
        localDrawable2 = localObject[1];
        break label56;
        localDrawable3 = localObject[2];
        break label64;
        localObject = localObject[3];
        break label72;
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, (Drawable)localObject);
      }
    }
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.sC) && (!paramBoolean2) && ((!paramBoolean1) || (this.sD));
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    cq.K(paramBitmap);
    Bitmap localBitmap = paramBitmap;
    if ((this.sE & 0x1) != 0) {
      localBitmap = cp.a(paramBitmap);
    }
    a(new BitmapDrawable(paramContext.getResources(), localBitmap), paramBoolean, false, true);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.sv != 0)
    {
      Resources localResources = paramContext.getResources();
      paramContext = localResources.getDrawable(this.sv);
      localObject = paramContext;
      if ((this.sE & 0x1) != 0) {
        localObject = cp.a(localResources, paramContext);
      }
    }
    a((Drawable)localObject, paramBoolean, false, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof a)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      bool1 = bool2;
    } while (((a)paramObject).hashCode() == hashCode());
    return false;
  }
  
  public int hashCode()
  {
    return this.sx;
  }
  
  public static final class a
  {
    public final Uri uri;
    
    public a(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool1;
      if (!(paramObject instanceof a)) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this == paramObject);
        bool1 = bool2;
      } while (((a)paramObject).hashCode() == hashCode());
      return false;
    }
    
    public int hashCode()
    {
      return cz.hashCode(new Object[] { this.uri });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/images/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */