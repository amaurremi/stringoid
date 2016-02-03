package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class ec
  extends ImageView
{
  private Uri GD;
  private int GE;
  private int GF;
  
  public void cE(int paramInt)
  {
    this.GE = paramInt;
  }
  
  public void d(Uri paramUri)
  {
    this.GD = paramUri;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.GF != 0) {
      paramCanvas.drawColor(this.GF);
    }
  }
  
  public int qh()
  {
    return this.GE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */