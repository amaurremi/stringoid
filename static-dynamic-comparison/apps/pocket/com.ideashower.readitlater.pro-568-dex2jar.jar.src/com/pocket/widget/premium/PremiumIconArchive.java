package com.pocket.widget.premium;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.ideashower.readitlater.util.j;
import com.pocket.i.a.e;

public class PremiumIconArchive
  extends b
{
  private View a;
  private View b;
  private int c;
  private View d;
  
  public PremiumIconArchive(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public PremiumIconArchive(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public PremiumIconArchive(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  @TargetApi(14)
  private void a(float paramFloat, View paramView)
  {
    float f = this.c * 0.3F;
    paramFloat %= f;
    if (paramFloat < this.c * 0.1F) {}
    for (paramFloat = 1.0F;; paramFloat = e.c.getInterpolation(paramFloat / f))
    {
      paramView.setAlpha(paramFloat);
      return;
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2130903161, this, true);
    this.c = getResources().getDimensionPixelSize(2131296360);
    this.a = findViewById(2131231086);
    this.b = findViewById(2131231087);
    this.d = findViewById(2131231083);
  }
  
  @TargetApi(14)
  public void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    a(paramFloat1, paramFloat2, this.d);
  }
  
  @TargetApi(14)
  public void a(d paramd)
  {
    paramd = new c(paramd);
    View localView = findViewById(2131231084);
    localView.setTranslationX(j.a(5.0F));
    localView.setTranslationY(j.a(15.0F));
    localView.setRotation(-5.0F);
    localView.setAlpha(0.0F);
    localView.animate().setDuration(1000L).rotation(0.0F).alpha(1.0F).translationX(0.0F).translationY(0.0F).setListener(paramd).setInterpolator(e.f);
    localView = findViewById(2131231085);
    localView.setTranslationX(-j.a(7.8F));
    localView.setTranslationY(-j.a(17.0F));
    localView.setRotation(12.0F);
    localView.setScaleX(0.71F);
    localView.setScaleY(0.71F);
    localView.setAlpha(0.0F);
    localView.animate().setStartDelay(200L).setDuration(1000L).rotation(0.0F).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setListener(paramd).setInterpolator(e.f);
    this.a.setAlpha(0.0F);
    this.a.setRotation(-15.0F);
    this.a.setScaleX(0.9F);
    this.a.setScaleY(0.9F);
    this.a.animate().setStartDelay(1000L).setDuration(500L).rotation(0.0F).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setListener(paramd).setInterpolator(e.f);
    this.b.setAlpha(0.0F);
    this.b.setRotation(-8.0F);
    this.b.setScaleX(0.8F);
    this.b.setScaleY(0.9F);
    this.b.animate().setStartDelay(1100L).setDuration(450L).rotation(0.0F).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setListener(paramd).setInterpolator(e.f);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    super.a(paramArrayOfFloat);
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = getOffsetY();
    a(f1, this.a);
    a(f2 + f3, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumIconArchive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */