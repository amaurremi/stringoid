package com.pocket.h;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class a
  extends MultiAutoCompleteTextView
{
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
  
  public boolean enoughToFilter()
  {
    return true;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */