package com.pocket.widget.navigation;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.pocket.p.y;
import org.apache.a.c.k;

public class t
  extends Drawable
{
  private final int b = j.a(10.0F);
  private final int c = j.a(10.5F);
  private final Paint d = new Paint();
  private final Paint e = new Paint();
  private final RectF f = new RectF();
  private final ColorStateList g;
  private String h;
  private int i;
  
  public t(s params)
  {
    this.e.setColor(-1);
    this.e.setTypeface(i.a(i.d));
    this.e.setTextSize(j.a(14.0F));
    this.e.setFlags(this.e.getFlags() | 0x80);
    this.e.setTextAlign(Paint.Align.CENTER);
    this.e.setAntiAlias(true);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setAntiAlias(true);
    this.g = params.getResources().getColorStateList(2131165768);
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    if (k.a(paramString)) {
      return;
    }
    float f1 = this.e.measureText(paramString);
    if (f1 > this.b)
    {
      this.i = ((int)(f1 - this.b));
      return;
    }
    this.i = 0;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.h == null) {
      return;
    }
    Rect localRect = getBounds();
    float f1 = this.c * 2;
    if (localRect.width() - f1 <= 0.0F) {
      paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), this.c, this.d);
    }
    for (;;)
    {
      f1 = y.a(localRect, this.e);
      paramCanvas.drawText(this.h, localRect.exactCenterX(), f1, this.e);
      return;
      this.f.set(localRect.left, localRect.top, localRect.left + f1, localRect.bottom);
      paramCanvas.drawArc(this.f, 90.0F, 180.0F, true, this.d);
      paramCanvas.drawRect(localRect.left + this.c, localRect.top, localRect.right - this.c, localRect.bottom, this.d);
      this.f.set(localRect.right - f1, localRect.top, localRect.right, localRect.bottom);
      paramCanvas.drawArc(this.f, 270.0F, 180.0F, true, this.d);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.c * 2;
  }
  
  public int getIntrinsicWidth()
  {
    return this.c * 2 + this.i;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.d.setColor(this.g.getColorForState(paramArrayOfInt, 0));
    getState();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.e.setAlpha(paramInt);
    this.d.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
    this.d.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */