package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public final class do$a
  extends AsyncTask<Void, Void, Boolean>
{
  private final WebView pQ;
  private Bitmap pR;
  
  public do$a(do paramdo, WebView paramWebView)
  {
    this.pQ = paramWebView;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    for (;;)
    {
      int i;
      int m;
      try
      {
        int n = this.pR.getWidth();
        int i1 = this.pR.getHeight();
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
          if (this.pR.getPixel(i, k) != 0) {
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
    do.c(this.pS);
    if ((paramBoolean.booleanValue()) || (this.pS.bq()) || (do.d(this.pS) <= 0L))
    {
      this.pS.pP = paramBoolean.booleanValue();
      do.e(this.pS).a(this.pS.lN);
    }
    while (do.d(this.pS) <= 0L) {
      return;
    }
    if (eu.p(2)) {
      eu.z("Ad not detected, scheduling another run.");
    }
    do.g(this.pS).postDelayed(this.pS, do.f(this.pS));
  }
  
  protected void onPreExecute()
  {
    try
    {
      this.pR = Bitmap.createBitmap(do.a(this.pS), do.b(this.pS), Bitmap.Config.ARGB_8888);
      this.pQ.setVisibility(0);
      this.pQ.measure(View.MeasureSpec.makeMeasureSpec(do.a(this.pS), 0), View.MeasureSpec.makeMeasureSpec(do.b(this.pS), 0));
      this.pQ.layout(0, 0, do.a(this.pS), do.b(this.pS));
      Canvas localCanvas = new Canvas(this.pR);
      this.pQ.draw(localCanvas);
      this.pQ.invalidate();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/do$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */