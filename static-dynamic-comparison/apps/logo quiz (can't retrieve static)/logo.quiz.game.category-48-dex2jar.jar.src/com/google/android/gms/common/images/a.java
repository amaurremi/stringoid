package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.iw;
import com.google.android.gms.internal.ix;
import com.google.android.gms.internal.iy;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.iz.a;
import java.lang.ref.WeakReference;

public abstract class a
{
  final a KA;
  protected int KB = 0;
  protected int KC = 0;
  protected ImageManager.OnImageLoadedListener KD;
  private boolean KE = true;
  private boolean KF = false;
  protected int KG;
  
  public a(Uri paramUri, int paramInt)
  {
    this.KA = new a(paramUri);
    this.KC = paramInt;
  }
  
  private Drawable a(Context paramContext, iz paramiz, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (this.KG > 0)
    {
      iz.a locala = new iz.a(paramInt, this.KG);
      Drawable localDrawable = (Drawable)paramiz.get(locala);
      paramContext = localDrawable;
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        paramContext = localDrawable;
        if ((this.KG & 0x1) != 0) {
          paramContext = a(localResources, localDrawable);
        }
        paramiz.put(locala, paramContext);
      }
      return paramContext;
    }
    return localResources.getDrawable(paramInt);
  }
  
  protected Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return ix.a(paramResources, paramDrawable);
  }
  
  protected iw a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof iw)) {}
    }
    for (Drawable localDrawable = ((iw)paramDrawable1).gL();; localDrawable = null) {
      return new iw(localDrawable, paramDrawable2);
    }
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    com.google.android.gms.common.internal.a.f(paramBitmap);
    Bitmap localBitmap = paramBitmap;
    if ((this.KG & 0x1) != 0) {
      localBitmap = ix.a(paramBitmap);
    }
    paramContext = new BitmapDrawable(paramContext.getResources(), localBitmap);
    if (this.KD != null) {
      this.KD.onImageLoaded(this.KA.uri, paramContext, true);
    }
    a(paramContext, paramBoolean, false, true);
  }
  
  void a(Context paramContext, iz paramiz)
  {
    Drawable localDrawable = null;
    if (this.KB != 0) {
      localDrawable = a(paramContext, paramiz, this.KB);
    }
    a(localDrawable, false, true, false);
  }
  
  void a(Context paramContext, iz paramiz, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.KC != 0) {
      localDrawable = a(paramContext, paramiz, this.KC);
    }
    if (this.KD != null) {
      this.KD.onImageLoaded(this.KA.uri, localDrawable, false);
    }
    a(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public void aw(int paramInt)
  {
    this.KC = paramInt;
  }
  
  protected boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.KE) && (!paramBoolean2) && ((!paramBoolean1) || (this.KF));
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
      return m.equal(((a)paramObject).uri, this.uri);
    }
    
    public int hashCode()
    {
      return m.hashCode(new Object[] { this.uri });
    }
  }
  
  public static final class b
    extends a
  {
    private WeakReference<ImageView> KH;
    
    public b(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      com.google.android.gms.common.internal.a.f(paramImageView);
      this.KH = new WeakReference(paramImageView);
    }
    
    public b(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      com.google.android.gms.common.internal.a.f(paramImageView);
      this.KH = new WeakReference(paramImageView);
    }
    
    private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((!paramBoolean2) && (!paramBoolean3)) {}
      for (int i = 1; (i != 0) && ((paramImageView instanceof iy)); i = 0)
      {
        int j = ((iy)paramImageView).gN();
        if ((this.KC == 0) || (j != this.KC)) {
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
        iy localiy;
        if ((paramImageView instanceof iy))
        {
          localiy = (iy)paramImageView;
          if (!paramBoolean3) {
            break label149;
          }
          paramImageView = this.KA.uri;
          label110:
          localiy.g(paramImageView);
          if (i == 0) {
            break label154;
          }
        }
        label149:
        label154:
        for (i = this.KC;; i = 0)
        {
          localiy.ay(i);
          if (!paramBoolean1) {
            break;
          }
          ((iw)paramDrawable).startTransition(250);
          return;
          paramImageView = null;
          break label110;
        }
      }
    }
    
    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.KH.get();
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
      paramObject = (ImageView)this.KH.get();
      localObject = (ImageView)((b)localObject).KH.get();
      if ((localObject != null) && (paramObject != null) && (m.equal(localObject, paramObject))) {}
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
    private WeakReference<ImageManager.OnImageLoadedListener> KI;
    
    public c(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      com.google.android.gms.common.internal.a.f(paramOnImageLoadedListener);
      this.KI = new WeakReference(paramOnImageLoadedListener);
    }
    
    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.KI.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.KA.uri, paramDrawable, paramBoolean3);
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
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.KI.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)((c)paramObject).KI.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (m.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (m.equal(((c)paramObject).KA, this.KA))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return m.hashCode(new Object[] { this.KA });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/images/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */