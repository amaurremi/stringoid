package com.pocket.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.ideashower.readitlater.views.ResizeDetectLinearLayout;
import com.ideashower.readitlater.views.toolbars.b;
import com.ideashower.readitlater.views.toolbars.c;

public class ai
  extends ResizeDetectLinearLayout
  implements b
{
  private final c a = new c(this);
  
  public ai(Context paramContext)
  {
    super(paramContext);
  }
  
  public ai(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getStyle()
  {
    return this.a.a();
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (this.a != null) {
      this.a.a(arrayOfInt);
    }
    return arrayOfInt;
  }
  
  public void setStyle(int paramInt)
  {
    this.a.a(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */