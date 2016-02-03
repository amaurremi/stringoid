package com.pocket.widget.premium;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.pocket.i.a.i;

public class a
  extends Drawable
{
  private final Paint a = new Paint();
  
  public a()
  {
    this.a.setColor(i.b);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), localRect.width() / 2.0F, this.a);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */