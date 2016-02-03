package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class PhotoPreview
  extends View
{
  private Drawable a;
  private boolean b = false;
  
  public PhotoPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public PhotoPreview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b() {}
  
  private void c()
  {
    if (this.a != null)
    {
      float f3 = this.a.getIntrinsicWidth();
      float f1 = this.a.getIntrinsicHeight();
      float f2 = Math.min(getWidth() / f3, getHeight() / f1);
      f3 *= f2;
      f1 *= f2;
      int i = (int)((getWidth() - f3) / 2.0F);
      int j = (int)((getHeight() - f1) / 2.0F);
      int k = (int)(f3 + i);
      int m = (int)(f1 + j);
      this.a.setBounds(i, j, k, m);
      this.b = false;
    }
  }
  
  public Rect a()
  {
    if (this.a != null) {
      return this.a.getBounds();
    }
    return null;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.a != paramDrawable)
    {
      this.a = paramDrawable;
      this.b = true;
    }
    requestLayout();
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null) {
      this.a.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || (this.b)) {
      c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/PhotoPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */