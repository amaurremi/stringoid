package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class gw
  extends ImageView
{
  private Uri FL;
  private int FM;
  private int FN;
  private a FO;
  
  public void al(int paramInt)
  {
    this.FM = paramInt;
  }
  
  public void f(Uri paramUri)
  {
    this.FL = paramUri;
  }
  
  public int fd()
  {
    return this.FM;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.FO != null) {
      paramCanvas.clipPath(this.FO.d(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (this.FN != 0) {
      paramCanvas.drawColor(this.FN);
    }
  }
  
  public static abstract interface a
  {
    public abstract Path d(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */