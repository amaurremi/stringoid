package com.pocket.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.ThemedTextView;

public class Tab
  extends ThemedTextView
{
  private static final int a = j.a(0.0F);
  private static final int b = j.a(4.0F);
  private final Paint c = new Paint();
  private ColorStateList d;
  
  public Tab(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public Tab(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
    a();
  }
  
  public Tab(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
    a();
  }
  
  private void a()
  {
    if (getBackground() == null) {
      setBackgroundResource(2130837774);
    }
    setGravity(17);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.PocketTheme);
    setIndicatorColor(paramAttributeSet.getColorStateList(3));
    paramAttributeSet.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    ColorStateList localColorStateList;
    if (this.d != null)
    {
      localColorStateList = this.d;
      this.c.setColor(localColorStateList.getColorForState(getDrawableState(), -16777216));
      if (!isSelected()) {
        break label80;
      }
    }
    label80:
    for (int i = b;; i = a)
    {
      paramCanvas.drawRect(0.0F, getHeight() - i, getWidth(), getHeight(), this.c);
      super.onDraw(paramCanvas);
      return;
      localColorStateList = getTextColors();
      break;
    }
  }
  
  public void setIndicatorColor(ColorStateList paramColorStateList)
  {
    this.d = paramColorStateList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/Tab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */