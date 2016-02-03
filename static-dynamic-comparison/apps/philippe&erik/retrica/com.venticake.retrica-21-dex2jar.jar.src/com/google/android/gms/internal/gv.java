package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class gv
  extends ImageView
{
  private Uri FO;
  private int FP;
  private int FQ;
  private gv.a FR;
  
  public void al(int paramInt)
  {
    this.FP = paramInt;
  }
  
  public int fi()
  {
    return this.FP;
  }
  
  public void g(Uri paramUri)
  {
    this.FO = paramUri;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.FR != null) {
      paramCanvas.clipPath(this.FR.d(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (this.FQ != 0) {
      paramCanvas.drawColor(this.FQ);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */