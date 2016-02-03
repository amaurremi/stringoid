package com.pocket.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class ThemedView
  extends View
{
  public ThemedView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThemedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ThemedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ThemedView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */