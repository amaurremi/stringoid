package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public final class bf
  extends AsyncTask
{
  private final WebView a;
  private Bitmap b;
  
  public bf(be parambe, WebView paramWebView)
  {
    this.a = paramWebView;
  }
  
  private Boolean a()
  {
    for (;;)
    {
      int i;
      int m;
      try
      {
        int n = this.b.getWidth();
        int i1 = this.b.getHeight();
        Boolean localBoolean;
        if ((n == 0) || (i1 == 0))
        {
          localBoolean = Boolean.valueOf(false);
          return localBoolean;
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
          if (this.b.getPixel(i, k) != 0) {
            m = j + 1;
          }
        }
        else
        {
          if (j / (n * i1 / 100.0D) > 0.1D)
          {
            bool = true;
            localBoolean = Boolean.valueOf(bool);
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
  
  protected final void onPreExecute()
  {
    try
    {
      this.b = Bitmap.createBitmap(be.a(this.c), be.b(this.c), Bitmap.Config.ARGB_8888);
      this.a.setVisibility(0);
      this.a.measure(View.MeasureSpec.makeMeasureSpec(be.a(this.c), 0), View.MeasureSpec.makeMeasureSpec(be.b(this.c), 0));
      this.a.layout(0, 0, be.a(this.c), be.b(this.c));
      Canvas localCanvas = new Canvas(this.b);
      this.a.draw(localCanvas);
      this.a.invalidate();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */