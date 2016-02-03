package com.pocket.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import com.pocket.i.a.g;

class aa
  extends ac
{
  private final Paint c = new Paint();
  private final ColorStateList d;
  private final g e = new g();
  
  private aa(PocketSeekBar paramPocketSeekBar, Resources paramResources, int paramInt)
  {
    super(paramPocketSeekBar, paramResources, null);
    a(this.c);
    this.c.setStyle(Paint.Style.FILL);
    this.d = paramResources.getColorStateList(paramInt);
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    this.c.setColor(this.d.getColorForState(paramArrayOfInt, 0));
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.e.a(paramCanvas, this.c);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    float f = PocketSeekBar.a() / 2.0F;
    this.e.a(paramRect.left, paramRect.exactCenterY() - f, paramRect.right, f + paramRect.exactCenterY());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */