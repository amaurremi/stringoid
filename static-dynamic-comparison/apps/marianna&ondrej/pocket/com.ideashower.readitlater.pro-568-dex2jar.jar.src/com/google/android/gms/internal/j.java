package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.webkit.DownloadListener;
import android.webkit.WebView;

public final class j
  extends WebView
  implements DownloadListener
{
  private final MutableContextWrapper a;
  private final Object b;
  private final cl c;
  private x d;
  private boolean e;
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      getContext().startActivity(paramString2);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      h.a("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = Integer.MAX_VALUE;
    for (;;)
    {
      int i;
      int m;
      int k;
      synchronized (this.b)
      {
        if ((isInEditMode()) || (this.e))
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
        }
        int n = View.MeasureSpec.getMode(paramInt1);
        i = View.MeasureSpec.getSize(paramInt1);
        m = View.MeasureSpec.getMode(paramInt2);
        k = View.MeasureSpec.getSize(paramInt2);
        if (n == Integer.MIN_VALUE) {
          break label234;
        }
        if (n != 1073741824) {
          break label228;
        }
        break label234;
        if ((this.d.g > paramInt1) || (this.d.d > paramInt2))
        {
          h.b("Not enough space to show ad. Needs " + this.d.g + "x" + this.d.d + ", but only has " + i + "x" + k);
          if (getVisibility() != 8) {
            setVisibility(4);
          }
          setMeasuredDimension(0, 0);
          return;
        }
      }
      if (getVisibility() != 8) {
        setVisibility(0);
      }
      setMeasuredDimension(this.d.g, this.d.d);
      continue;
      label228:
      paramInt1 = Integer.MAX_VALUE;
      break label236;
      label234:
      paramInt1 = i;
      label236:
      if (m != Integer.MIN_VALUE)
      {
        paramInt2 = j;
        if (m != 1073741824) {}
      }
      else
      {
        paramInt2 = k;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c != null) {
      this.c.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContext(Context paramContext)
  {
    this.a.setBaseContext(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */