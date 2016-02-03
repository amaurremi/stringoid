package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class ThemedTextView
  extends TextView
{
  private boolean a = false;
  
  public ThemedTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThemedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ThemedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int i = paramTypedArray.getInt(0, 0);
    if (i != 0) {
      i.a(i, this);
    }
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
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a)
    {
      Layout localLayout = getLayout();
      paramInt1 = getMeasuredWidth();
      paramInt2 = getMeasuredHeight();
      setMeasuredDimension(paramInt1, localLayout.getLineDescent(localLayout.getLineCount() - 1) + paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 < 1.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      super.setLineSpacing(paramFloat1, paramFloat2);
      return;
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    paramContext = getContext().obtainStyledAttributes(paramInt, b.ThemedTextView);
    a(paramContext);
    paramContext.recycle();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ThemedTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */