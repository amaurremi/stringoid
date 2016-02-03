package com.jiubang.core.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class r
  extends l
{
  public r(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bitmap paramBitmap)
  {
    super(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBitmap);
  }
  
  protected void a(Canvas paramCanvas, float paramFloat, int paramInt1, int paramInt2)
  {
    paramFloat = paramInt2 / 255.0F;
    this.i.setAlpha((int)(paramFloat * 255.0F * this.m.b()));
    if ((this.i.getAlpha() != 0) && (this.j != null)) {
      paramCanvas.drawBitmap(this.j, this.m.a(), this.i);
    }
  }
  
  public void h()
  {
    try
    {
      if ((this.j != null) && (!this.j.isRecycled()))
      {
        this.j.recycle();
        this.j = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean s()
  {
    return r() != null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */