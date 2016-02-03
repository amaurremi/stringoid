package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.fg;
import java.lang.ref.WeakReference;

public final class a
{
  final a op;
  private int oq = 0;
  private int or = 0;
  int os;
  private int ot;
  private WeakReference<ImageManager.OnImageLoadedListener> ou;
  private WeakReference<ImageView> ov;
  private WeakReference<TextView> ow;
  private int ox = -1;
  private boolean oy = true;
  private boolean oz = false;
  
  public a(int paramInt)
  {
    this.op = new a(null);
    this.or = paramInt;
  }
  
  public a(Uri paramUri)
  {
    this.op = new a(paramUri);
    this.or = 0;
  }
  
  private dq a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof dq)) {}
    }
    for (Drawable localDrawable = ((dq)paramDrawable1).bC();; localDrawable = null) {
      return new dq(localDrawable, paramDrawable2);
    }
  }
  
  private void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    switch (this.os)
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
          localObject = (ImageManager.OnImageLoadedListener)this.ou.get();
        } while (localObject == null);
        ((ImageManager.OnImageLoadedListener)localObject).onImageLoaded(this.op.uri, paramDrawable, paramBoolean3);
        return;
        localObject = (ImageView)this.ov.get();
      } while (localObject == null);
      a((ImageView)localObject, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      return;
      localObject = (TextView)this.ow.get();
    } while (localObject == null);
    a((TextView)localObject, this.ox, paramDrawable, paramBoolean1, paramBoolean2);
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean2) && (!paramBoolean3)) {}
    for (int i = 1; (i != 0) && ((paramImageView instanceof dr)); i = 0)
    {
      int j = ((dr)paramImageView).bE();
      if ((this.or == 0) || (j != this.or)) {
        break;
      }
      return;
    }
    paramBoolean1 = a(paramBoolean1, paramBoolean2);
    if (paramBoolean1) {
      paramDrawable = a(paramImageView.getDrawable(), paramDrawable);
    }
    for (;;)
    {
      paramImageView.setImageDrawable(paramDrawable);
      dr localdr;
      if ((paramImageView instanceof dr))
      {
        localdr = (dr)paramImageView;
        if (!paramBoolean3) {
          break label149;
        }
        paramImageView = this.op.uri;
        label110:
        localdr.d(paramImageView);
        if (i == 0) {
          break label154;
        }
      }
      label149:
      label154:
      for (i = this.or;; i = 0)
      {
        localdr.H(i);
        if (!paramBoolean1) {
          break;
        }
        ((dq)paramDrawable).startTransition(250);
        return;
        paramImageView = null;
        break label110;
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = a(paramBoolean1, paramBoolean2);
    Object localObject;
    Drawable localDrawable1;
    if (fg.cI())
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
        if (!fg.cI()) {
          break label151;
        }
        paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, (Drawable)localObject);
      }
      for (;;)
      {
        if (paramBoolean1) {
          ((dq)paramDrawable).startTransition(250);
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
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.oy) && (!paramBoolean2) && ((!paramBoolean1) || (this.oz));
  }
  
  public void F(int paramInt)
  {
    this.or = paramInt;
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    ds.d(paramBitmap);
    a(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }
  
  public void a(ImageView paramImageView)
  {
    ds.d(paramImageView);
    this.ou = null;
    this.ov = new WeakReference(paramImageView);
    this.ow = null;
    this.ox = -1;
    this.os = 2;
    this.ot = paramImageView.hashCode();
  }
  
  public void a(ImageManager.OnImageLoadedListener paramOnImageLoadedListener)
  {
    ds.d(paramOnImageLoadedListener);
    this.ou = new WeakReference(paramOnImageLoadedListener);
    this.ov = null;
    this.ow = null;
    this.ox = -1;
    this.os = 1;
    this.ot = ee.hashCode(new Object[] { paramOnImageLoadedListener, this.op });
  }
  
  void b(Context paramContext, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.or != 0) {
      localDrawable = paramContext.getResources().getDrawable(this.or);
    }
    a(localDrawable, paramBoolean, false, false);
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
    return this.ot;
  }
  
  void r(Context paramContext)
  {
    Drawable localDrawable = null;
    if (this.oq != 0) {
      localDrawable = paramContext.getResources().getDrawable(this.oq);
    }
    a(localDrawable, false, true, false);
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
      return ee.hashCode(new Object[] { this.uri });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/images/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */