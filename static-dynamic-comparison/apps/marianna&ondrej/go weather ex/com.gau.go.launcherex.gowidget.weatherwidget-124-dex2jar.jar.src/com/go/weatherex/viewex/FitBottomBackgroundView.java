package com.go.weatherex.viewex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class FitBottomBackgroundView
  extends View
{
  private Bitmap a;
  private Paint b;
  private Rect c = new Rect();
  private Rect d = new Rect();
  private int e = -1;
  
  public FitBottomBackgroundView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FitBottomBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int i = 1;
    int j;
    for (;;)
    {
      j = i;
      if (m / i <= paramInt1) {
        break;
      }
      i += 1;
    }
    while (k / j > paramInt2) {
      j += 1;
    }
    return Math.min(6, j);
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt2, paramInt3);
    localOptions.inJustDecodeBounds = false;
    localOptions.inPreferredConfig = Bitmap.Config.ALPHA_8;
    return BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
  }
  
  private void a()
  {
    this.b = new Paint(1);
  }
  
  private void b()
  {
    if (this.a != null)
    {
      int k = getWidth();
      int m = getHeight();
      int i = this.a.getWidth();
      int j = this.a.getHeight();
      float f = i / k;
      k = (int)(j - f * m);
      this.c.set(0, k, i, j);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a = paramBitmap;
      b();
      invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.a != null) && (!this.a.isRecycled())) {
      this.a.recycle();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.a == null) && (this.e != -1))
    {
      int i = getWidth();
      int j = getHeight();
      this.a = a(getResources(), this.e, i, j);
      b();
    }
    if (this.a != null) {
      paramCanvas.drawBitmap(this.a, this.c, this.d, this.b);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.d.set(paramInt1, paramInt2, paramInt3, paramInt4);
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/FitBottomBackgroundView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */