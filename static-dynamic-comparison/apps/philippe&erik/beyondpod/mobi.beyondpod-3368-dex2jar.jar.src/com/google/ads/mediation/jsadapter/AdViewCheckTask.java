package com.google.ads.mediation.jsadapter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.ct;

public final class AdViewCheckTask
  implements Runnable
{
  public static final int BACKGROUND_COLOR = 0;
  private final JavascriptAdapter r;
  private final Handler s;
  private final long t;
  private long u;
  
  public AdViewCheckTask(JavascriptAdapter paramJavascriptAdapter, long paramLong1, long paramLong2)
  {
    this.r = paramJavascriptAdapter;
    this.t = paramLong1;
    this.u = paramLong2;
    this.s = new Handler(Looper.getMainLooper());
  }
  
  public void run()
  {
    if ((this.r == null) || (this.r.shouldStopAdCheck())) {
      return;
    }
    new a(this.r.getWebViewWidth(), this.r.getWebViewHeight(), this.r.getWebView()).execute(new Void[0]);
  }
  
  public void start()
  {
    this.s.postDelayed(this, this.t);
  }
  
  private final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private final int v;
    private final int w;
    private final WebView x;
    private Bitmap y;
    
    public a(int paramInt1, int paramInt2, WebView paramWebView)
    {
      this.v = paramInt2;
      this.w = paramInt1;
      this.x = paramWebView;
    }
    
    protected Boolean a(Void... paramVarArgs)
    {
      for (;;)
      {
        int i;
        int m;
        try
        {
          int n = this.y.getWidth();
          int i1 = this.y.getHeight();
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
            if (this.y.getPixel(i, k) != 0) {
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
      AdViewCheckTask.a(AdViewCheckTask.this);
      if (paramBoolean.booleanValue())
      {
        AdViewCheckTask.b(AdViewCheckTask.this).sendAdReceivedUpdate();
        return;
      }
      if (AdViewCheckTask.c(AdViewCheckTask.this) > 0L)
      {
        if (ct.n(2)) {
          ct.r("Ad not detected, scheduling another run.");
        }
        AdViewCheckTask.e(AdViewCheckTask.this).postDelayed(AdViewCheckTask.this, AdViewCheckTask.d(AdViewCheckTask.this));
        return;
      }
      ct.r("Ad not detected, Not scheduling anymore runs.");
      AdViewCheckTask.b(AdViewCheckTask.this).sendAdNotReceivedUpdate();
    }
    
    protected void onPreExecute()
    {
      try
      {
        this.y = Bitmap.createBitmap(this.w, this.v, Bitmap.Config.ARGB_8888);
        this.x.setVisibility(0);
        this.x.measure(View.MeasureSpec.makeMeasureSpec(this.w, 0), View.MeasureSpec.makeMeasureSpec(this.v, 0));
        this.x.layout(0, 0, this.w, this.v);
        Canvas localCanvas = new Canvas(this.y);
        this.x.draw(localCanvas);
        this.x.invalidate();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/ads/mediation/jsadapter/AdViewCheckTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */