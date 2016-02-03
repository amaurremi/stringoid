package com.pocket.widget.premium;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.ideashower.readitlater.util.j;
import com.pocket.i.a.e;

public class PremiumIconTags
  extends b
{
  private View a;
  
  public PremiumIconTags(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public PremiumIconTags(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public PremiumIconTags(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2130903164, this, true);
    this.a = findViewById(2131231095);
  }
  
  @TargetApi(14)
  public void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    a(paramFloat1, paramFloat2, this.a);
  }
  
  @TargetApi(14)
  public void a(d paramd)
  {
    paramd = new c(paramd);
    View localView = findViewById(2131231097);
    localView.setTranslationX(-j.a(3.0F));
    localView.setTranslationY(j.a(3.0F));
    localView.setRotation(-15.0F);
    localView.setScaleX(0.79F);
    localView.setScaleY(0.79F);
    localView.setAlpha(0.0F);
    localView.animate().setStartDelay(900L).setDuration(500L).rotation(0.0F).alpha(1.0F).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).setListener(paramd).setInterpolator(e.f);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/premium/PremiumIconTags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */