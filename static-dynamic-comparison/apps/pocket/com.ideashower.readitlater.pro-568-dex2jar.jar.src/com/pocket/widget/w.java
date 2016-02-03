package com.pocket.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class w
{
  private final List a = new ArrayList();
  private View b;
  
  public v a()
  {
    if (this.a.isEmpty()) {
      throw new RuntimeException("no choices added");
    }
    if ((this.b != null) && (!this.a.contains(this.b))) {
      throw new RuntimeException("selected view not one of the choices");
    }
    return new v(this.a, this.b, null);
  }
  
  public w a(View paramView)
  {
    this.a.add(paramView);
    if (this.b == null) {
      this.b = paramView;
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */