package com.pocket.widget.premium;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.pocket.b.h;
import com.pocket.widget.y;

public class b
  extends ResizeDetectRelativeLayout
  implements h
{
  private float a;
  
  public b(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    z.f(this, getResources().getDimensionPixelSize(2131296360));
    setClipToPadding(false);
  }
  
  public void a()
  {
    a(0.0F, 0.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
  }
  
  @TargetApi(14)
  protected void a(float paramFloat1, float paramFloat2, View paramView)
  {
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {}
    for (paramFloat1 = paramFloat1 / paramFloat2 * 0.08F + 1.0F;; paramFloat1 = 1.0F)
    {
      paramView.setAlpha(Math.min(1.0F, paramFloat1));
      paramView.setScaleX(paramFloat1);
      return;
    }
  }
  
  @TargetApi(14)
  public void a(long paramLong)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView.getTranslationX() != 0.0F) || (localView.getTranslationY() != 0.0F)) {
        localView.animate().setDuration(paramLong).translationX(0.0F).translationY(0.0F);
      }
      i += 1;
    }
  }
  
  @TargetApi(14)
  public void a(d paramd)
  {
    paramd.a();
  }
  
  @TargetApi(11)
  public void a(float[] paramArrayOfFloat)
  {
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = this.a;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      paramArrayOfFloat = getChildAt(i);
      if ((paramArrayOfFloat instanceof y))
      {
        y localy = (y)paramArrayOfFloat;
        float f4 = localy.getDepthX();
        float f5 = localy.getDepthY();
        paramArrayOfFloat.setTranslationX(f4 * f1);
        paramArrayOfFloat.setTranslationY(f5 * (f2 + f3));
      }
      i += 1;
    }
  }
  
  @TargetApi(14)
  public void b()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setTranslationX(0.0F);
      localView.setTranslationY(0.0F);
      i += 1;
    }
  }
  
  protected float getOffsetY()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */