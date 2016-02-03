package com.pocket.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ideashower.readitlater.util.z;

public class az
{
  private final View a;
  private final ViewGroup b;
  private final ViewGroup c;
  
  public az(View paramView)
  {
    this.a = paramView;
    this.b = new FrameLayout(paramView.getContext());
    this.c = new FrameLayout(paramView.getContext());
  }
  
  public ViewGroup a()
  {
    return this.b;
  }
  
  public ViewGroup b()
  {
    return this.c;
  }
  
  public void c()
  {
    z.a(this.a, this.b);
  }
  
  public void d()
  {
    z.a(this.a, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */