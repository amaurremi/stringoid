package com.ideashower.readitlater.views.toolbars;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.p;
import java.util.ArrayList;
import java.util.Iterator;

public class Toggle
  extends StyledIconButton
{
  private Paint f;
  private ArrayList g;
  private int[] h;
  
  public Toggle(Context paramContext)
  {
    super(paramContext);
  }
  
  public Toggle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean b(int paramInt)
  {
    if (paramInt == 2130772083) {}
    while ((paramInt == -2130772083) || (paramInt == 2130772084) || (paramInt == -2130772084) || (paramInt == 2130772082) || (paramInt == -2130772082) || (paramInt == 2130772087) || (paramInt == -2130772087) || (paramInt == 2130772089) || (paramInt == -2130772089) || (paramInt == 2130772090) || (paramInt == -2130772090)) {
      return true;
    }
    return false;
  }
  
  protected void a()
  {
    super.a();
    this.f = new Paint();
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt);
    if (this.g == null) {
      this.g = new ArrayList();
    }
    for (;;)
    {
      int i = arrayOfInt.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (b(arrayOfInt[paramInt])) {
          this.g.add(Integer.valueOf(arrayOfInt[paramInt]));
        }
        paramInt += 1;
      }
      this.g.clear();
    }
    this.h = new int[this.g.size() + 1];
    Iterator localIterator = this.g.iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.h[paramInt] = localInteger.intValue();
      paramInt += 1;
    }
    this.h[paramInt] = 16842910;
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.f.setColor(p.a(this.h, 0, getContext()));
    float f2 = getWidth();
    if (isSelected()) {}
    for (float f1 = 6.0F;; f1 = 2.0F)
    {
      paramCanvas.drawRect(0.0F, 0.0F, f2, j.a(f1), this.f);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/toolbars/Toggle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */