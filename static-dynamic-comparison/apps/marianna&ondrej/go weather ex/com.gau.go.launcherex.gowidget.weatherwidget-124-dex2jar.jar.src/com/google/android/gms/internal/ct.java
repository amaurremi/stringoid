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

public class ct
  implements Runnable
{
  private final int kr;
  private final int ks;
  protected final dz lC;
  private final Handler oT;
  private final long oU;
  private long oV;
  private ea.a oW;
  protected boolean oX;
  protected boolean oY;
  
  public ct(ea.a parama, dz paramdz, int paramInt1, int paramInt2)
  {
    this(parama, paramdz, paramInt1, paramInt2, 200L, 50L);
  }
  
  public ct(ea.a parama, dz paramdz, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.oU = paramLong1;
    this.oV = paramLong2;
    this.oT = new Handler(Looper.getMainLooper());
    this.lC = paramdz;
    this.oW = parama;
    this.oX = false;
    this.oY = false;
    this.ks = paramInt2;
    this.kr = paramInt1;
  }
  
  public void a(cz paramcz, ee paramee)
  {
    this.lC.setWebViewClient(paramee);
    dz localdz = this.lC;
    if (TextUtils.isEmpty(paramcz.ol)) {}
    for (paramee = null;; paramee = dq.r(paramcz.ol))
    {
      localdz.loadDataWithBaseURL(paramee, paramcz.pm, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public void b(cz paramcz)
  {
    a(paramcz, new ee(this, this.lC, paramcz.pv));
  }
  
  public void ba()
  {
    this.oT.postDelayed(this, this.oU);
  }
  
  public void bb()
  {
    try
    {
      this.oX = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean bc()
  {
    try
    {
      boolean bool = this.oX;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean bd()
  {
    return this.oY;
  }
  
  public void run()
  {
    if ((this.lC == null) || (bc()))
    {
      this.oW.a(this.lC);
      return;
    }
    new a(this.lC).execute(new Void[0]);
  }
  
  protected final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private final WebView oZ;
    private Bitmap pa;
    
    public a(WebView paramWebView)
    {
      this.oZ = paramWebView;
    }
    
    protected Boolean a(Void... paramVarArgs)
    {
      for (;;)
      {
        int i;
        int m;
        try
        {
          int n = this.pa.getWidth();
          int i1 = this.pa.getHeight();
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
            if (this.pa.getPixel(i, k) != 0) {
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
      ct.c(ct.this);
      if ((paramBoolean.booleanValue()) || (ct.this.bc()) || (ct.d(ct.this) <= 0L))
      {
        ct.this.oY = paramBoolean.booleanValue();
        ct.e(ct.this).a(ct.this.lC);
      }
      while (ct.d(ct.this) <= 0L) {
        return;
      }
      if (dw.n(2)) {
        dw.v("Ad not detected, scheduling another run.");
      }
      ct.g(ct.this).postDelayed(ct.this, ct.f(ct.this));
    }
    
    protected void onPreExecute()
    {
      try
      {
        this.pa = Bitmap.createBitmap(ct.a(ct.this), ct.b(ct.this), Bitmap.Config.ARGB_8888);
        this.oZ.setVisibility(0);
        this.oZ.measure(View.MeasureSpec.makeMeasureSpec(ct.a(ct.this), 0), View.MeasureSpec.makeMeasureSpec(ct.b(ct.this), 0));
        this.oZ.layout(0, 0, ct.a(ct.this), ct.b(ct.this));
        Canvas localCanvas = new Canvas(this.pa);
        this.oZ.draw(localCanvas);
        this.oZ.invalidate();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */