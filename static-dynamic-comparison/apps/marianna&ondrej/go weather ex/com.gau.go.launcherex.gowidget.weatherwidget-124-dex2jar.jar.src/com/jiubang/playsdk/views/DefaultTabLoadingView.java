package com.jiubang.playsdk.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.jiubang.playsdk.adapter.o;
import com.jiubang.playsdk.c.d;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.main.s;

public class DefaultTabLoadingView
  extends FrameLayout
  implements o
{
  private RotateView a;
  private HeaderListView b;
  private s c;
  private boolean d = false;
  private int e = 0;
  private Handler f = new b(this);
  
  public DefaultTabLoadingView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DefaultTabLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.b != null)
    {
      this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    this.e = paramInt2;
  }
  
  public void a(s params)
  {
    this.c = params;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.a(paramBoolean);
    }
  }
  
  public void b()
  {
    if (!this.d)
    {
      d.a(new c(this));
      this.d = true;
    }
  }
  
  public void c()
  {
    if (this.b != null) {
      this.b.c();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((RotateView)findViewById(f.al));
    this.b = ((HeaderListView)LayoutInflater.from(getContext()).inflate(g.k, null));
    this.b.b(false);
    if (this.e != 0) {
      this.b.a(0, this.e, 0, 0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/DefaultTabLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */