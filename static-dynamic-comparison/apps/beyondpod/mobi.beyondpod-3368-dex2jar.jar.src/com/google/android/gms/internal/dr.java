package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class dr
  extends ImageView
{
  private Uri oU;
  private int oV;
  private int oW;
  
  public void H(int paramInt)
  {
    this.oV = paramInt;
  }
  
  public int bE()
  {
    return this.oV;
  }
  
  public void d(Uri paramUri)
  {
    this.oU = paramUri;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.oW != 0) {
      paramCanvas.drawColor(this.oW);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */