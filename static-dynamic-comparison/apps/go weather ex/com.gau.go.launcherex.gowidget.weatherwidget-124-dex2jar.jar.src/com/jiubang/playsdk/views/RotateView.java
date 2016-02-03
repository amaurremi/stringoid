package com.jiubang.playsdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.main.c;

public class RotateView
  extends ImageView
{
  private Animation a;
  
  public RotateView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RotateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RotateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setImageResource(aa.a().b().m());
    this.a = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.a.setInterpolator(new LinearInterpolator());
    this.a.setDuration(1000L);
    this.a.setRepeatCount(-1);
    this.a.setFillAfter(true);
    startAnimation(this.a);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      clearAnimation();
      startAnimation(this.a);
      return;
    }
    clearAnimation();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/RotateView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */