package com.jiubang.core.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class n
  extends l
{
  public n(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bitmap paramBitmap)
  {
    super(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBitmap);
  }
  
  protected void a(Canvas paramCanvas, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.j != null)
    {
      paramInt1 = this.i.getAlpha();
      this.i.setAlpha(paramInt2);
      if ((!this.n.h()) && (!this.n.b())) {
        paramCanvas.drawBitmap(this.j, this.n.a(), this.n.g(), this.i);
      }
      if ((!this.n.d()) && (!this.n.f())) {
        paramCanvas.drawBitmap(this.j, this.n.c(), this.n.e(), this.i);
      }
      this.i.setAlpha(paramInt1);
    }
  }
  
  public void h()
  {
    try
    {
      if ((this.j != null) && (this.j.isRecycled()))
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */