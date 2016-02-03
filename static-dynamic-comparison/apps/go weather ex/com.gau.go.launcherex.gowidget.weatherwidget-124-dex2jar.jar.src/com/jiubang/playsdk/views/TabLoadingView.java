package com.jiubang.playsdk.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.jiubang.playsdk.adapter.o;
import com.jiubang.playsdk.f;

public class TabLoadingView
  extends FrameLayout
  implements o, q
{
  private RotateView a;
  private com.jiubang.playsdk.a.x b;
  private com.jiubang.playsdk.e.d c;
  private boolean d = false;
  private o e;
  private int f = 400;
  private int g = 0;
  private Handler h = new x(this);
  
  public TabLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d()
  {
    this.e = ((o)a.a(LayoutInflater.from(getContext()), this.c, this.b).a());
    if (this.g != 0) {
      this.e.a(0, this.g, 0, 0);
    }
    addView(this.e.a());
    this.a.setVisibility(8);
    removeView(this.a);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.e != null)
    {
      this.e.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    this.g = paramInt2;
  }
  
  public void a(com.jiubang.playsdk.a.x paramx)
  {
    this.b = paramx;
  }
  
  public void a(com.jiubang.playsdk.e.d paramd)
  {
    this.c = paramd;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.e != null) {
      this.e.a(paramBoolean);
    }
  }
  
  public void b()
  {
    if (!this.d) {
      if (this.f != 0)
      {
        com.jiubang.playsdk.c.d.a(new y(this));
        this.d = true;
      }
    }
    while (this.e == null) {
      for (;;)
      {
        return;
        this.h.sendEmptyMessage(1);
      }
    }
    this.e.b();
  }
  
  public void c()
  {
    if (this.e != null) {
      this.e.c();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((RotateView)findViewById(f.al));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/TabLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */