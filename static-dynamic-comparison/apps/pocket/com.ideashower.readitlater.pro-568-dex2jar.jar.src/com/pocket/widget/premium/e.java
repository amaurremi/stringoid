package com.pocket.widget.premium;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.util.j;
import com.pocket.i.a.i;

class e
  extends Drawable
{
  private final Paint b = new Paint(1);
  private final Path c = new Path();
  private final float d = j.a(12.0F);
  
  public e(PremiumUpgradeView paramPremiumUpgradeView)
  {
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(i.b);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.c, this.b);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.set(j.a(3.0F), j.a(3.0F), j.a(3.0F), 0);
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.c.rewind();
    this.c.moveTo(paramRect.left, paramRect.top);
    this.c.lineTo(paramRect.right, paramRect.top);
    this.c.lineTo(paramRect.right, paramRect.bottom);
    this.c.quadTo(paramRect.left + paramRect.width() / 2.0F, paramRect.bottom - this.d, paramRect.left, paramRect.bottom);
    this.c.close();
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */