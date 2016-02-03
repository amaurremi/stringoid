package com.pocket.widget;

import android.view.View;
import java.util.ArrayList;

public abstract class ba
{
  private final ArrayList a = new ArrayList();
  
  protected abstract View a(View paramView);
  
  public View b(View paramView)
  {
    if (this.a.isEmpty()) {
      return a(paramView);
    }
    return (View)this.a.remove(0);
  }
  
  public void c(View paramView)
  {
    if (paramView.getParent() != null) {
      throw new RuntimeException("View cannot be recycled while still attached to a parent");
    }
    this.a.add(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */