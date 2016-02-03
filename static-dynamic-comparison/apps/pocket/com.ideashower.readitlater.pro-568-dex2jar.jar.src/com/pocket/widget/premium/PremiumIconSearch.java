package com.pocket.widget.premium;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.ideashower.readitlater.util.j;
import com.pocket.i.a.e;

public class PremiumIconSearch
  extends b
{
  private PremiumSearchLensContentView a;
  
  public PremiumIconSearch(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public PremiumIconSearch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public PremiumIconSearch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2130903163, this, true);
    this.a = ((PremiumSearchLensContentView)findViewById(2131231093));
  }
  
  @TargetApi(14)
  public void a(d paramd)
  {
    paramd = new c(paramd);
    View localView = findViewById(2131231091);
    localView.setRotation(-15.0F);
    localView.setTranslationX(-j.a(15.0F));
    localView.setTranslationY(-j.a(3.0F));
    localView.animate().setStartDelay(600L).setDuration(450L).rotation(0.0F).translationX(0.0F).translationY(0.0F).setListener(paramd).setInterpolator(e.f);
    localView = findViewById(2131231092);
    localView.setRotation(12.0F);
    localView.setTranslationX(j.a(13.0F));
    localView.setTranslationY(j.a(4.0F));
    localView.animate().setStartDelay(600L).setDuration(500L).rotation(0.0F).translationX(0.0F).translationY(0.0F).setListener(paramd).setInterpolator(e.f);
    localView = findViewById(2131231094);
    localView.setAlpha(0.0F);
    localView.setScaleX(0.75F);
    localView.setScaleY(0.75F);
    localView.animate().setStartDelay(500L).setDuration(500L).alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setListener(paramd).setInterpolator(e.f);
    localView = findViewById(2131231093);
    localView.setAlpha(0.0F);
    localView.setScaleX(0.75F);
    localView.setScaleY(0.75F);
    localView.animate().setStartDelay(500L).setDuration(500L).alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setListener(paramd).setInterpolator(e.f);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    super.a(paramArrayOfFloat);
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = getOffsetY();
    this.a.a(f1, f2 + f3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumIconSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */