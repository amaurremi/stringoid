package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class ThemedButton
  extends Button
{
  public ThemedButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThemedButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ThemedButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.ThemedTextView);
    int i = paramAttributeSet.getInt(0, 0);
    if (i != 0) {
      i.a(i, this);
    }
    paramAttributeSet.recycle();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ThemedButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */