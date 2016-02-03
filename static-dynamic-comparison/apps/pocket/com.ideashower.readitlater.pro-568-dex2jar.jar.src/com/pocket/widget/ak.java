package com.pocket.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextPaint;
import com.pocket.i.a.g;
import com.pocket.i.a.l;

class ak
  extends l
{
  private final Paint b = new Paint();
  private final g c = new g();
  
  public ak(TextBubbleDividerView paramTextBubbleDividerView)
  {
    a(this.b);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(TextBubbleDividerView.a());
    a();
  }
  
  public void a()
  {
    this.b.setColor(this.a.getTextColors().getColorForState(this.a.getDrawableState(), this.a.getTextColors().getDefaultColor()));
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.c.a(paramCanvas, this.b);
    Rect localRect = getBounds();
    float f = (localRect.width() - this.c.a() - TextBubbleDividerView.f() * 2) / 2.0F;
    if (f > 0.0F)
    {
      paramCanvas.drawLine(localRect.left, localRect.exactCenterY(), localRect.left + f, localRect.exactCenterY(), this.b);
      paramCanvas.drawLine(localRect.right, localRect.exactCenterY(), localRect.right - f, localRect.exactCenterY(), this.b);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return TextBubbleDividerView.b();
  }
  
  public int getIntrinsicWidth()
  {
    return -1;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a.getPaint().getTextBounds(this.a.getText().toString(), 0, this.a.getText().length(), TextBubbleDividerView.c());
    float f2 = TextBubbleDividerView.c().width() + TextBubbleDividerView.d() * 2;
    float f1 = f2;
    if (f2 < TextBubbleDividerView.e()) {
      f1 = TextBubbleDividerView.e();
    }
    g localg = this.c;
    f2 = paramRect.exactCenterX();
    float f3 = f1 / 2.0F;
    float f4 = paramRect.exactCenterY();
    float f5 = TextBubbleDividerView.e() / 2;
    float f6 = paramRect.exactCenterX();
    localg.a(f2 - f3, f4 - f5, f1 / 2.0F + f6, paramRect.exactCenterY() + TextBubbleDividerView.e() / 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */