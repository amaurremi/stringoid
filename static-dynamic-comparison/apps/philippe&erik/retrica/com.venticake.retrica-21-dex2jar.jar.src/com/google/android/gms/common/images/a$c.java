package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import java.lang.ref.WeakReference;

public final class a$c
  extends a
{
  private WeakReference<ImageManager.OnImageLoadedListener> Ft;
  
  public a$c(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    super(paramUri, 0);
    gx.c(paramOnImageLoadedListener);
    this.Ft = new WeakReference(paramOnImageLoadedListener);
  }
  
  protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean2)
    {
      ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.Ft.get();
      if (localOnImageLoadedListener != null) {
        localOnImageLoadedListener.onImageLoaded(this.Fm.a, paramDrawable, paramBoolean3);
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (c)paramObject;
    ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.Ft.get();
    ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)((c)paramObject).Ft.get();
    if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (hk.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (hk.equal(((c)paramObject).Fm, this.Fm))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { this.Fm });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/a$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */