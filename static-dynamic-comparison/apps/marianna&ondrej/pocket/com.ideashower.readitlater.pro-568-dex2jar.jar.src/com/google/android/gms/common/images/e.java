package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.p;
import com.google.android.gms.internal.q;
import java.lang.ref.WeakReference;

public final class e
{
  final f a;
  int b;
  private int c;
  private int d;
  private WeakReference e;
  private WeakReference f;
  private WeakReference g;
  private int h;
  private boolean i;
  private boolean j;
  
  private k a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof k)) {}
    }
    for (Drawable localDrawable = ((k)paramDrawable1).b();; localDrawable = null) {
      return new k(localDrawable, paramDrawable2);
    }
  }
  
  private void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    switch (this.b)
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
          localObject = (a)this.e.get();
        } while (localObject == null);
        ((a)localObject).a(this.a.a, paramDrawable);
        return;
        localObject = (ImageView)this.f.get();
      } while (localObject == null);
      a((ImageView)localObject, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      return;
      localObject = (TextView)this.g.get();
    } while (localObject == null);
    a((TextView)localObject, this.h, paramDrawable, paramBoolean1, paramBoolean2);
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean2) && (!paramBoolean3)) {}
    for (int k = 1; (k != 0) && ((paramImageView instanceof p)); k = 0)
    {
      int m = ((p)paramImageView).a();
      if ((this.c == 0) || (m != this.c)) {
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
      p localp;
      if ((paramImageView instanceof p))
      {
        localp = (p)paramImageView;
        if (!paramBoolean3) {
          break label149;
        }
        paramImageView = this.a.a;
        label110:
        localp.a(paramImageView);
        if (k == 0) {
          break label154;
        }
      }
      label149:
      label154:
      for (k = this.c;; k = 0)
      {
        localp.a(k);
        if (!paramBoolean1) {
          break;
        }
        ((k)paramDrawable).a(250);
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
    if (bd.c())
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
        if (!bd.c()) {
          break label151;
        }
        paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, (Drawable)localObject);
      }
      for (;;)
      {
        if (paramBoolean1) {
          ((k)paramDrawable).a(250);
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
    return (this.i) && (!paramBoolean2) && ((!paramBoolean1) || (this.j));
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    q.a(paramBitmap);
    a(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.c != 0) {
      localDrawable = paramContext.getResources().getDrawable(this.c);
    }
    a(localDrawable, paramBoolean, false, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof e)) {
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
    } while (((e)paramObject).hashCode() == hashCode());
    return false;
  }
  
  public int hashCode()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/images/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */