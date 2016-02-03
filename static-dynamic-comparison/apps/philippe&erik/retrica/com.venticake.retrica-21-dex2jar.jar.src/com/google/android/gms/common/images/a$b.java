package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import java.lang.ref.WeakReference;

public final class a$b
  extends a
{
  private WeakReference<ImageView> Fs;
  
  public a$b(ImageView paramImageView, int paramInt)
  {
    super(null, paramInt);
    gx.c(paramImageView);
    this.Fs = new WeakReference(paramImageView);
  }
  
  public a$b(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    gx.c(paramImageView);
    this.Fs = new WeakReference(paramImageView);
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean2) && (!paramBoolean3)) {}
    for (int i = 1; (i != 0) && ((paramImageView instanceof gv)); i = 0)
    {
      int j = ((gv)paramImageView).fi();
      if ((this.Fo == 0) || (j != this.Fo)) {
        break;
      }
      return;
    }
    paramBoolean1 = b(paramBoolean1, paramBoolean2);
    if (paramBoolean1) {
      paramDrawable = a(paramImageView.getDrawable(), paramDrawable);
    }
    for (;;)
    {
      paramImageView.setImageDrawable(paramDrawable);
      gv localgv;
      if ((paramImageView instanceof gv))
      {
        localgv = (gv)paramImageView;
        if (!paramBoolean3) {
          break label149;
        }
        paramImageView = this.Fm.a;
        label110:
        localgv.g(paramImageView);
        if (i == 0) {
          break label154;
        }
      }
      label149:
      label154:
      for (i = this.Fo;; i = 0)
      {
        localgv.al(i);
        if (!paramBoolean1) {
          break;
        }
        ((gt)paramDrawable).startTransition(250);
        return;
        paramImageView = null;
        break label110;
      }
    }
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ImageView localImageView = (ImageView)this.Fs.get();
    if (localImageView != null) {
      a(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    Object localObject = (b)paramObject;
    paramObject = (ImageView)this.Fs.get();
    localObject = (ImageView)((b)localObject).Fs.get();
    if ((localObject != null) && (paramObject != null) && (hk.equal(localObject, paramObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/a$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */