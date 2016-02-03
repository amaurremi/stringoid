package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.gx.a;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import java.lang.ref.WeakReference;

public abstract class a
{
  final a Fj;
  protected int Fk = 0;
  protected int Fl = 0;
  private boolean Fm = true;
  private boolean Fn = false;
  protected int Fo;
  
  public a(Uri paramUri, int paramInt)
  {
    this.Fj = new a(paramUri);
    this.Fl = paramInt;
  }
  
  private Drawable a(Context paramContext, gx paramgx, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (this.Fo > 0)
    {
      gx.a locala = new gx.a(paramInt, this.Fo);
      Drawable localDrawable = (Drawable)paramgx.get(locala);
      paramContext = localDrawable;
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        paramContext = localDrawable;
        if ((this.Fo & 0x1) != 0) {
          paramContext = a(localResources, localDrawable);
        }
        paramgx.put(locala, paramContext);
      }
      return paramContext;
    }
    return localResources.getDrawable(paramInt);
  }
  
  protected Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return gv.a(paramResources, paramDrawable);
  }
  
  protected gu a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof gu)) {}
    }
    for (Drawable localDrawable = ((gu)paramDrawable1).fb();; localDrawable = null) {
      return new gu(localDrawable, paramDrawable2);
    }
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    gy.c(paramBitmap);
    Bitmap localBitmap = paramBitmap;
    if ((this.Fo & 0x1) != 0) {
      localBitmap = gv.a(paramBitmap);
    }
    a(new BitmapDrawable(paramContext.getResources(), localBitmap), paramBoolean, false, true);
  }
  
  void a(Context paramContext, gx paramgx)
  {
    Drawable localDrawable = null;
    if (this.Fk != 0) {
      localDrawable = a(paramContext, paramgx, this.Fk);
    }
    a(localDrawable, false, true, false);
  }
  
  void a(Context paramContext, gx paramgx, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.Fl != 0) {
      localDrawable = a(paramContext, paramgx, this.Fl);
    }
    a(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public void aj(int paramInt)
  {
    this.Fl = paramInt;
  }
  
  protected boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.Fm) && (!paramBoolean2) && ((!paramBoolean1) || (this.Fn));
  }
  
  static final class a
  {
    public final Uri uri;
    
    public a(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      return hl.equal(((a)paramObject).uri, this.uri);
    }
    
    public int hashCode()
    {
      return hl.hashCode(new Object[] { this.uri });
    }
  }
  
  public static final class b
    extends a
  {
    private WeakReference<ImageView> Fp;
    
    public b(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      gy.c(paramImageView);
      this.Fp = new WeakReference(paramImageView);
    }
    
    public b(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      gy.c(paramImageView);
      this.Fp = new WeakReference(paramImageView);
    }
    
    private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((!paramBoolean2) && (!paramBoolean3)) {}
      for (int i = 1; (i != 0) && ((paramImageView instanceof gw)); i = 0)
      {
        int j = ((gw)paramImageView).fd();
        if ((this.Fl == 0) || (j != this.Fl)) {
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
        gw localgw;
        if ((paramImageView instanceof gw))
        {
          localgw = (gw)paramImageView;
          if (!paramBoolean3) {
            break label149;
          }
          paramImageView = this.Fj.uri;
          label110:
          localgw.f(paramImageView);
          if (i == 0) {
            break label154;
          }
        }
        label149:
        label154:
        for (i = this.Fl;; i = 0)
        {
          localgw.al(i);
          if (!paramBoolean1) {
            break;
          }
          ((gu)paramDrawable).startTransition(250);
          return;
          paramImageView = null;
          break label110;
        }
      }
    }
    
    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.Fp.get();
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
      paramObject = (ImageView)this.Fp.get();
      localObject = (ImageView)((b)localObject).Fp.get();
      if ((localObject != null) && (paramObject != null) && (hl.equal(localObject, paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return 0;
    }
  }
  
  public static final class c
    extends a
  {
    private WeakReference<ImageManager.OnImageLoadedListener> Fq;
    
    public c(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      gy.c(paramOnImageLoadedListener);
      this.Fq = new WeakReference(paramOnImageLoadedListener);
    }
    
    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.Fq.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.Fj.uri, paramDrawable, paramBoolean3);
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
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.Fq.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)((c)paramObject).Fq.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (hl.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (hl.equal(((c)paramObject).Fj, this.Fj))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return hl.hashCode(new Object[] { this.Fj });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/images/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */