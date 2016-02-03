package com.pocket.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class ThemedScrollView
  extends ScrollView
{
  private boolean a;
  private ColorStateList b;
  
  public ThemedScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThemedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ThemedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.ThemedScrollView);
    this.a = paramAttributeSet.hasValue(0);
    if (this.a) {
      setShadowColor(paramAttributeSet.getColorStateList(0));
    }
    paramAttributeSet.recycle();
  }
  
  private void setShadowColor(ColorStateList paramColorStateList)
  {
    this.a = true;
    this.b = paramColorStateList;
  }
  
  public int getSolidColor()
  {
    if ((this.a) && (this.b != null)) {
      return this.b.getColorForState(getDrawableState(), super.getSolidColor());
    }
    return super.getSolidColor();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ThemedScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */