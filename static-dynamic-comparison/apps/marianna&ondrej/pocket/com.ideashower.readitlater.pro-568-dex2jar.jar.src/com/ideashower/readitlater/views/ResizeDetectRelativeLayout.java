package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.ideashower.readitlater.activity.f;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class ResizeDetectRelativeLayout
  extends RelativeLayout
  implements x
{
  private u a;
  private f b;
  private int c;
  private int d;
  
  public ResizeDetectRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ResizeDetectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, b.ResizeDetectRelativeLayout);
    this.c = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, b.PocketTheme);
    this.d = paramContext.getDimensionPixelSize(2, 0);
    paramContext.recycle();
  }
  
  public ResizeDetectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.a(this, this.b));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = paramInt1;
    if (this.c > 0)
    {
      i = paramInt1;
      if (this.c < j)
      {
        paramInt1 = View.MeasureSpec.getMode(paramInt1);
        i = View.MeasureSpec.makeMeasureSpec(this.c, paramInt1);
      }
    }
    j = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = paramInt2;
    if (this.d > 0)
    {
      paramInt1 = paramInt2;
      if (this.d < j)
      {
        paramInt1 = View.MeasureSpec.getMode(paramInt2);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.d, paramInt1);
      }
    }
    super.onMeasure(i, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setFrag(f paramf)
  {
    this.b = paramf;
  }
  
  public void setOnResizeListener(u paramu)
  {
    this.a = paramu;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ResizeDetectRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */