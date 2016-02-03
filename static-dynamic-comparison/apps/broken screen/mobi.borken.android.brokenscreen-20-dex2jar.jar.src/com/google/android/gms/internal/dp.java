package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public class dp
  implements Runnable
{
  private final int ks;
  private final int kt;
  protected final ey lL;
  private final Handler pI;
  private final long pJ;
  private long pK;
  private ez.a pL;
  protected boolean pM;
  protected boolean pN;
  
  public dp(ez.a parama, ey paramey, int paramInt1, int paramInt2)
  {
    this(parama, paramey, paramInt1, paramInt2, 200L, 50L);
  }
  
  public dp(ez.a parama, ey paramey, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.pJ = paramLong1;
    this.pK = paramLong2;
    this.pI = new Handler(Looper.getMainLooper());
    this.lL = paramey;
    this.pL = parama;
    this.pM = false;
    this.pN = false;
    this.kt = paramInt2;
    this.ks = paramInt1;
  }
  
  public void a(dv paramdv, fd paramfd)
  {
    this.lL.setWebViewClient(paramfd);
    ey localey = this.lL;
    if (TextUtils.isEmpty(paramdv.oy)) {}
    for (paramfd = null;; paramfd = ep.v(paramdv.oy))
    {
      localey.loadDataWithBaseURL(paramfd, paramdv.qb, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public void b(dv paramdv)
  {
    a(paramdv, new fd(this, this.lL, paramdv.qk));
  }
  
  public void bj()
  {
    this.pI.postDelayed(this, this.pJ);
  }
  
  public void bk()
  {
    try
    {
      this.pM = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean bl()
  {
    try
    {
      boolean bool = this.pM;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean bm()
  {
    return this.pN;
  }
  
  public void run()
  {
    if ((this.lL == null) || (bl()))
    {
      this.pL.a(this.lL);
      return;
    }
    new a(this.lL).execute(new Void[0]);
  }
  
  protected final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private final WebView pO;
    private Bitmap pP;
    
    public a(WebView paramWebView)
    {
      this.pO = paramWebView;
    }
    
    protected Boolean a(Void... paramVarArgs)
    {
      for (;;)
      {
        int i;
        int m;
        try
        {
          int n = this.pP.getWidth();
          int i1 = this.pP.getHeight();
          if ((n == 0) || (i1 == 0))
          {
            paramVarArgs = Boolean.valueOf(false);
            return paramVarArgs;
          }
          i = 0;
          j = 0;
          int k;
          if (i < n)
          {
            k = 0;
            if (k >= i1) {
              break label139;
            }
            m = j;
            if (this.pP.getPixel(i, k) != 0) {
              m = j + 1;
            }
          }
          else
          {
            if (j / (n * i1 / 100.0D) > 0.1D)
            {
              bool = true;
              paramVarArgs = Boolean.valueOf(bool);
              continue;
            }
            boolean bool = false;
            continue;
          }
          k += 10;
        }
        finally {}
        int j = m;
        continue;
        label139:
        i += 10;
      }
    }
    
    protected void a(Boolean paramBoolean)
    {
      dp.c(dp.this);
      if ((paramBoolean.booleanValue()) || (dp.this.bl()) || (dp.d(dp.this) <= 0L))
      {
        dp.this.pN = paramBoolean.booleanValue();
        dp.e(dp.this).a(dp.this.lL);
      }
      while (dp.d(dp.this) <= 0L) {
        return;
      }
      if (ev.p(2)) {
        ev.z("Ad not detected, scheduling another run.");
      }
      dp.g(dp.this).postDelayed(dp.this, dp.f(dp.this));
    }
    
    protected void onPreExecute()
    {
      try
      {
        this.pP = Bitmap.createBitmap(dp.a(dp.this), dp.b(dp.this), Bitmap.Config.ARGB_8888);
        this.pO.setVisibility(0);
        this.pO.measure(View.MeasureSpec.makeMeasureSpec(dp.a(dp.this), 0), View.MeasureSpec.makeMeasureSpec(dp.b(dp.this), 0));
        this.pO.layout(0, 0, dp.a(dp.this), dp.b(dp.this));
        Canvas localCanvas = new Canvas(this.pP);
        this.pO.draw(localCanvas);
        this.pO.invalidate();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */