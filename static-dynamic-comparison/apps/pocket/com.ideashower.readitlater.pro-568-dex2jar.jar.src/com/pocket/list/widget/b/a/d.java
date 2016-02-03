package com.pocket.list.widget.b.a;

import android.content.Context;
import android.widget.FrameLayout;

public class d
  extends FrameLayout
{
  private e b;
  
  public d(c paramc, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.b != null) {
      this.b.d();
    }
  }
  
  public void setItemCellAnimationListener(e parame)
  {
    this.b = parame;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */