package com.jiubang.core.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class o
  extends u
{
  private Bitmap C;
  
  public o(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBitmap1);
    this.C = paramBitmap2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.j != null) {
      b(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.C != null) {
      b(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    super.a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2);
    if (this.C != null)
    {
      paramInt1 = this.i.getAlpha();
      this.i.setAlpha(paramInt2);
      paramCanvas.drawBitmap(this.C, null, this.k, this.i);
      this.i.setAlpha(paramInt1);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.p = paramBoolean;
    super.a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, paramBoolean);
    if (this.C != null)
    {
      paramInt1 = this.i.getAlpha();
      this.i.setAlpha(paramInt2);
      paramCanvas.drawBitmap(this.C, null, this.k, this.i);
      this.i.setAlpha(paramInt1);
    }
  }
  
  public void h()
  {
    try
    {
      super.h();
      if ((this.C != null) && (!this.C.isRecycled()))
      {
        this.C.recycle();
        this.C = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */