package com.appbrain.d;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class d
  extends c
{
  d(Drawable[] paramArrayOfDrawable, float[] paramArrayOfFloat, Drawable paramDrawable)
  {
    super(paramArrayOfDrawable, paramArrayOfFloat);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    this.a.draw(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void setBounds(Rect paramRect)
  {
    this.a.setBounds(paramRect);
    super.setBounds(paramRect);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */