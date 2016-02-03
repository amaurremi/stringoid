package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class ez
  extends ImageView
{
  private Uri CO;
  private int CP;
  private int CQ;
  
  public void L(int paramInt)
  {
    this.CP = paramInt;
  }
  
  public void e(Uri paramUri)
  {
    this.CO = paramUri;
  }
  
  public int eB()
  {
    return this.CP;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.CQ != 0) {
      paramCanvas.drawColor(this.CQ);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */