package com.go.weatherex.viewex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class FrameImageView
  extends ImageView
{
  private Drawable a;
  private int b;
  private int[] c;
  private long d = 70L;
  private long e = 1000L;
  private int f = -1;
  private int g;
  private Runnable h = new b(this);
  
  public FrameImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    this.b = 0;
    this.g = 0;
    if (this.a != null) {
      setImageDrawable(this.a);
    }
  }
  
  private void d()
  {
    this.a = getDrawable();
  }
  
  private void e()
  {
    c();
  }
  
  public void a()
  {
    b();
    d();
    post(this.h);
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
  }
  
  public void b()
  {
    removeCallbacks(this.h);
    c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/FrameImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */