package com.ideashower.readitlater.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class ThemedListView
  extends ListView
{
  boolean a = false;
  private int b = -1;
  
  public ThemedListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThemedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ThemedListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    if (getAdapter() != null)
    {
      int j = 0;
      View localView = null;
      int k;
      for (int i = 0; j < getAdapter().getCount(); i = k)
      {
        localView = getAdapter().getView(j, localView, this);
        k = i;
        if (localView != null)
        {
          localView.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
          localView.measure(0, 0);
          k = i;
          if (localView.getMeasuredWidth() > i) {
            k = localView.getMeasuredWidth();
          }
        }
        j += 1;
      }
      j = i;
      if (this.b != -1)
      {
        j = i;
        if (i < this.b) {
          j = this.b;
        }
      }
      return j;
    }
    return 0;
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
    if (this.a)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(a() + getPaddingLeft() + getPaddingRight(), 1073741824), paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    Drawable localDrawable = getDivider();
    if (localDrawable != null) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void setMinWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setWrapWidth(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ThemedListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */