package com.mobisystems.mobiscanner.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.mobisystems.mobiscanner.common.c;
import java.lang.ref.WeakReference;

public abstract class e
{
  private static final c apd = new c();
  protected d aHM = null;
  protected int aHN = 0;
  protected int aHO = 0;
  protected Context mContext;
  private final c mLog = new c(this);
  
  public e(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  protected static b af(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof a)) {
        return ((a)paramView).Ij();
      }
    }
    return null;
  }
  
  protected static boolean c(String paramString, View paramView)
  {
    boolean bool2 = true;
    b localb = af(paramView);
    apd.dl("cancelPotentialBitmapLoad called, imageId=" + paramString + ", imageView=" + com.mobisystems.mobiscanner.common.d.ay(paramView));
    boolean bool1 = bool2;
    if (localb != null)
    {
      paramView = b.a(localb);
      if ((paramView == null) || (paramView.equals(paramString))) {
        break label145;
      }
      apd.dl("cancelPotentialBitmapLoad: different page has to be loaded (" + paramView + ", " + paramString + ") - cancel existing load");
      localb.cancel(true);
      bool1 = bool2;
    }
    for (;;)
    {
      apd.dl("cancelPotentialBitmapLoad return:" + bool1);
      return bool1;
      label145:
      if (paramView == null)
      {
        apd.dl("cancelPotentialBitmapLoad: null task image id");
        localb.cancel(true);
        bool1 = bool2;
      }
      else
      {
        apd.dl("cancelPotentialBitmapLoad: the same image " + paramString + " is already being loaded - continue");
        bool1 = false;
      }
    }
  }
  
  public void Ih()
  {
    new c().execute(new Object[] { Integer.valueOf(1) });
  }
  
  public void Ii()
  {
    new c().execute(new Object[] { Integer.valueOf(3) });
  }
  
  public void N(int paramInt1, int paramInt2)
  {
    this.aHN = paramInt1;
    this.aHO = paramInt2;
  }
  
  protected void a(View paramView, BitmapDrawable paramBitmapDrawable, String paramString)
  {
    ImageView localImageView = ad(paramView);
    if (localImageView != null)
    {
      this.mLog.dl("displayImage: image " + paramString + " in view(" + com.mobisystems.mobiscanner.common.d.ay(paramView) + ")");
      localImageView.setImageDrawable(paramBitmapDrawable);
      paramView.setTag(paramString);
    }
    k(paramView, 4);
  }
  
  protected void a(String paramString, View paramView)
  {
    this.mLog.dl("loadImage: image id " + paramString + " in view(" + com.mobisystems.mobiscanner.common.d.ay(paramView) + ")");
    BitmapDrawable localBitmapDrawable = null;
    if (this.aHM != null) {
      localBitmapDrawable = this.aHM.dO(paramString);
    }
    if (localBitmapDrawable == null)
    {
      this.mLog.dl("loadImage: image " + paramString + " not found in memory cache - load in background");
      b(paramString, paramView);
      return;
    }
    this.mLog.dl("loadImage: image " + paramString + " found in memory cache - display");
    c(paramString, paramView);
    a(paramView, localBitmapDrawable, paramString);
  }
  
  protected void ac(View paramView)
  {
    paramView = ad(paramView);
    if (paramView != null) {
      paramView.setImageDrawable(null);
    }
  }
  
  protected ImageView ad(View paramView)
  {
    if (ImageView.class.isInstance(paramView)) {
      return (ImageView)paramView;
    }
    if (ViewGroup.class.isInstance(paramView)) {
      return (ImageView)com.mobisystems.mobiscanner.common.d.a((ViewGroup)paramView, ImageView.class);
    }
    return null;
  }
  
  protected Rect ae(View paramView)
  {
    Rect localRect = new Rect();
    int j = paramView.getWidth();
    int k = paramView.getHeight();
    int i;
    if (j > 0)
    {
      i = k;
      if (k > 0) {}
    }
    else
    {
      j = paramView.getLayoutParams().width;
      i = paramView.getLayoutParams().height;
    }
    if (j > 0)
    {
      k = i;
      if (i > 0) {}
    }
    else
    {
      j = paramView.getResources().getDisplayMetrics().widthPixels;
      k = paramView.getResources().getDisplayMetrics().heightPixels;
    }
    localRect.top = 0;
    localRect.left = 0;
    localRect.right = j;
    localRect.bottom = k;
    return localRect;
  }
  
  public void b(FragmentManager paramFragmentManager, String paramString, d.a parama)
  {
    this.aHM = d.a(paramFragmentManager, paramString, parama);
    Ih();
  }
  
  protected void b(String paramString, View paramView)
  {
    this.mLog.dl("forceLoad: image " + paramString + ", in view(" + com.mobisystems.mobiscanner.common.d.ay(paramView) + ")");
    b localb;
    a locala;
    if (c(paramString, paramView))
    {
      localb = new b(paramView, paramString);
      locala = new a(this.mContext.getResources(), localb);
      Object localObject = paramView.getTag();
      if (!(localObject instanceof String)) {
        break label186;
      }
      this.mLog.dl("forceLoad: image id stored in view(" + com.mobisystems.mobiscanner.common.d.ay(paramView) + "): " + (String)localObject);
      if (!paramString.equals((String)localObject)) {
        break label186;
      }
    }
    label186:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ac(paramView);
        k(paramView, 0);
      }
      paramView.setTag(locala);
      localb.execute(new Void[0]);
      return;
    }
  }
  
  protected BitmapDrawable e(Bitmap paramBitmap)
  {
    return new i(this.mContext.getResources(), paramBitmap);
  }
  
  public void flushCache()
  {
    new c().execute(new Object[] { Integer.valueOf(2) });
  }
  
  protected abstract BitmapDrawable h(String paramString, int paramInt1, int paramInt2);
  
  protected void k(View paramView, int paramInt)
  {
    if (ProgressBar.class.isInstance(paramView)) {
      paramView = (ProgressBar)paramView;
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.setIndeterminate(true);
        paramView.setVisibility(paramInt);
      }
      return;
      if (ViewGroup.class.isInstance(paramView)) {
        paramView = (ProgressBar)com.mobisystems.mobiscanner.common.d.a((ViewGroup)paramView, ProgressBar.class);
      } else {
        paramView = null;
      }
    }
  }
  
  protected static class a
    extends BitmapDrawable
  {
    private final WeakReference<e.b> aHP;
    
    public a(Resources paramResources, e.b paramb)
    {
      super();
      this.aHP = new WeakReference(paramb);
    }
    
    public e.b Ij()
    {
      return (e.b)this.aHP.get();
    }
  }
  
  protected class b
    extends AsyncTask<Void, Void, BitmapDrawable>
  {
    private String aHQ;
    private final WeakReference<View> aHR;
    int aHS;
    int aHT;
    
    public b(View paramView, String paramString)
    {
      this.aHQ = paramString;
      this.aHR = new WeakReference(paramView);
      if ((e.this.aHN > 0) && (e.this.aHO > 0))
      {
        this.aHS = e.this.aHN;
        this.aHT = e.this.aHO;
        return;
      }
      this$1 = e.this.ae(e.this.ad(paramView));
      this.aHS = e.this.width();
      this.aHT = e.this.height();
    }
    
    protected void b(BitmapDrawable paramBitmapDrawable)
    {
      e.a(e.this).dl("BitmapLoaderTask.onPostExecute called for image: " + this.aHQ);
      if ((this.aHR != null) && (!isCancelled()))
      {
        View localView = (View)this.aHR.get();
        if (this == e.af(localView)) {
          e.this.a(localView, paramBitmapDrawable, this.aHQ);
        }
      }
    }
    
    protected BitmapDrawable f(Void... paramVarArgs)
    {
      e.a(e.this).dl("BitmapLoaderTask.doInBackground called for image: " + this.aHQ);
      return e.this.h(this.aHQ, this.aHS, this.aHT);
    }
  }
  
  protected class c
    extends AsyncTask<Object, Void, Void>
  {
    protected c() {}
    
    protected Void b(Object... paramVarArgs)
    {
      switch (((Integer)paramVarArgs[0]).intValue())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (e.this.aHM == null);
            e.this.aHM.clearCache();
            return null;
          } while (e.this.aHM == null);
          e.this.aHM.Dr();
          return null;
        } while (e.this.aHM == null);
        e.this.aHM.flush();
        return null;
      } while (e.this.aHM == null);
      e.this.aHM.close();
      e.this.aHM = null;
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */