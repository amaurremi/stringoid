package com.go.weatherex.home.refresh;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;

public abstract class a
{
  protected View a;
  protected float b;
  protected long c;
  protected long d;
  protected boolean e;
  protected String f = "";
  private int g;
  
  public a(View paramView)
  {
    this.a = paramView;
    this.g = ((int)(this.a.getResources().getDisplayMetrics().density * 70.0F));
  }
  
  public void a()
  {
    if (!this.e)
    {
      this.b = 0.0F;
      this.c = AnimationUtils.currentAnimationTimeMillis();
      this.e = true;
      this.a.postInvalidate();
    }
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat <= 0.4F)
    {
      this.b = 0.0F;
      ViewCompat.postInvalidateOnAnimation(this.a);
      return;
    }
    this.b = ((paramFloat - 0.4F) / 0.6F);
    this.c = 0L;
    ViewCompat.postInvalidateOnAnimation(this.a);
  }
  
  abstract void a(Canvas paramCanvas);
  
  public void a(String paramString)
  {
    if (this.e)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.f = paramString;
      }
      this.b = 0.0F;
      this.d = AnimationUtils.currentAnimationTimeMillis();
      this.e = false;
      this.a.postInvalidate();
    }
  }
  
  public long b()
  {
    return 1000L;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  int c()
  {
    return this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */