package com.pocket.widget.navigation;

import android.view.View;

public class a
  implements android.support.v4.widget.a
{
  private int a;
  private float b;
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      this.a = 1;
      return;
    }
    if ((paramInt == 1) && ((this.a == 2) || (this.a == 3)))
    {
      this.a = 0;
      return;
    }
    this.a = 0;
  }
  
  public void a(View paramView)
  {
    if (this.a != 3) {
      a();
    }
    this.a = 0;
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.a == 1)
    {
      if (paramFloat >= this.b) {
        break label32;
      }
      b();
    }
    for (this.a = 2;; this.a = 3)
    {
      this.b = paramFloat;
      return;
      label32:
      a();
    }
  }
  
  protected void b() {}
  
  public void b(View paramView)
  {
    if (this.a != 2) {
      b();
    }
    this.a = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */