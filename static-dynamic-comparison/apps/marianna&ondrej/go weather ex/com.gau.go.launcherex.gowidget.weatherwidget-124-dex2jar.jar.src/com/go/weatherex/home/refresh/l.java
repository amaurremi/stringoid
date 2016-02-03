package com.go.weatherex.home.refresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;

public class l
  extends a
{
  private int[] g = { 2130838188, 2130838189, 2130838190, 2130838191, 2130838192, 2130838193, 2130838194, 2130838195, 2130838196, 2130838197, 2130838198, 2130838199, 2130838200, 2130838201 };
  private Drawable[] h = new Drawable[this.g.length];
  private Drawable i;
  private Paint j;
  
  public l(View paramView)
  {
    super(paramView);
    d();
    e();
    this.i = this.h[0];
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.i = this.h[paramInt];
    paramInt = (int)(paramFloat1 - this.i.getIntrinsicWidth() / 2);
    int k = this.i.getIntrinsicWidth();
    int m = this.i.getIntrinsicHeight();
    this.i.setBounds(paramInt, 0, k + paramInt, m + 0);
    this.i.draw(paramCanvas);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, String paramString)
  {
    if (!TextUtils.isEmpty(this.f)) {
      paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.j);
    }
  }
  
  private void c(float paramFloat)
  {
    if (paramFloat != this.j.getTextSize()) {
      this.j.setTextSize(paramFloat);
    }
  }
  
  private void d()
  {
    this.j = new Paint(1);
    this.j.setTextAlign(Paint.Align.CENTER);
    b(15.0F);
    this.j.setColor(-1);
    Typeface localTypeface = Typeface.createFromAsset(this.a.getResources().getAssets(), "fonts/Roboto-Light.ttf");
    this.j.setTypeface(localTypeface);
  }
  
  private void e()
  {
    Resources localResources = this.a.getResources();
    int k = 0;
    while (k < this.g.length)
    {
      this.h[k] = localResources.getDrawable(this.g[k]);
      k += 1;
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    Object localObject = this.a.getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      c(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      return;
    }
  }
  
  void a(Canvas paramCanvas)
  {
    int k = this.a.getWidth();
    int m = c();
    k /= 2;
    m /= 2;
    int i1 = k - this.i.getIntrinsicWidth() / 2;
    int i2 = this.i.getIntrinsicWidth();
    int n = this.i.getIntrinsicHeight() + 0;
    this.i.setBounds(i1, 0, i2 + i1, n);
    if ((this.e) || (this.d > 0L))
    {
      l = AnimationUtils.currentAnimationTimeMillis();
      f = (float)((l - this.c) % 1000L) / 10.0F;
      if (!this.e) {
        if ((float)(l - this.d) / 1000.0F >= 1.0F) {
          this.d = 0L;
        }
      }
    }
    while ((this.b <= 0.0F) || (this.b > 1.0D))
    {
      long l;
      float f;
      return;
      a(paramCanvas, k, m, 13);
      a(paramCanvas, k, n + this.j.getFontSpacing(), this.f);
      for (;;)
      {
        ViewCompat.postInvalidateOnAnimation(this.a);
        return;
        i1 = (int)(9.0F * f / 100.0F);
        a(paramCanvas, k, m, i1 + 5);
        a(paramCanvas, k, n + this.j.getFontSpacing(), this.f);
      }
    }
    i1 = (int)(this.b * 5.0F);
    a(paramCanvas, k, m, i1);
    a(paramCanvas, k, n + this.j.getFontSpacing(), this.f);
  }
  
  public void b(float paramFloat)
  {
    a(2, paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/refresh/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */