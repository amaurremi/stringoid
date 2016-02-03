package com.pocket.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public abstract class h
{
  protected final ViewGroup b;
  
  protected h(g paramg, View paramView)
  {
    this.b = ((ViewGroup)paramView);
  }
  
  protected abstract void a(int paramInt);
  
  protected void a(View.OnClickListener paramOnClickListener, View paramView)
  {
    paramView.setTag(this);
    paramView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */