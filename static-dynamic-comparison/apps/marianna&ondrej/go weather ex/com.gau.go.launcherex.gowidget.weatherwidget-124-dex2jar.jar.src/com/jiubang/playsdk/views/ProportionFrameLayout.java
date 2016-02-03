package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.jiubang.playsdk.k;

public class ProportionFrameLayout
  extends TouchMaskFrameLayout
{
  public float a = 1.0F;
  private boolean b = true;
  private boolean c = true;
  
  public ProportionFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProportionFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.c);
    this.a = paramContext.getFloat(0, 1.0F);
    paramContext.recycle();
  }
  
  public void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.c)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if (this.b)
    {
      if (View.MeasureSpec.getMode(paramInt2) == 1073741824)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
      i = (int)(paramInt2 * this.a);
      setMeasuredDimension(paramInt2, i);
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      return;
    }
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    int i = (int)(paramInt1 / this.a);
    setMeasuredDimension(i, paramInt1);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/ProportionFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */