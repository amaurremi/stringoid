package com.ideashower.readitlater.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;

public class CheckableTextView
  extends ThemedTextView
  implements Checkable
{
  public static final int[] a = { 16842912 };
  private boolean b = false;
  
  public CheckableTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CheckableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CheckableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isChecked()
  {
    return this.b;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, a);
    }
    return arrayOfInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void toggle()
  {
    if (!this.b) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/CheckableTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */