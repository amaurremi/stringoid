package com.pocket.widget;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

public class aq
{
  private final View a;
  private final Context b;
  private boolean c;
  
  public void a()
  {
    if (!this.c) {
      return;
    }
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    try
    {
      localWindowManager.removeView(this.a);
      this.c = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.a.setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */