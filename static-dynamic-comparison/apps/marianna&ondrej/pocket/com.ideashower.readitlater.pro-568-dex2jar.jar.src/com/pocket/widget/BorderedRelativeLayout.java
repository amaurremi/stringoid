package com.pocket.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;

public class BorderedRelativeLayout
  extends ResizeDetectRelativeLayout
{
  private Paint a;
  private ColorStateList b;
  private int c = 0;
  
  public BorderedRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public BorderedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BorderedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if ((this.a == null) || (this.b == null)) {
      return;
    }
    this.a.setColor(this.b.getColorForState(getDrawableState(), 0));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.c > 0) && (this.a != null)) {
      paramCanvas.drawRect(0.0F, getHeight() - this.c, getWidth(), getHeight(), this.a);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    a();
  }
  
  public void setBorder(int paramInt)
  {
    if (this.a == null) {
      this.a = new Paint();
    }
    this.b = getResources().getColorStateList(paramInt);
    a();
    invalidate();
  }
  
  public void setBottomBorderLength(int paramInt)
  {
    this.c = paramInt;
    z.b(this, Math.max(0, getPaddingBottom() + (paramInt - this.c)));
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/BorderedRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */