package com.ideashower.readitlater.views.toolbars;

import android.view.View;
import android.view.ViewGroup;
import com.ideashower.readitlater.util.z;

public class c
{
  private final View a;
  private int b;
  
  public c(View paramView)
  {
    this.a = paramView;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    if ((this.a instanceof ViewGroup)) {
      z.a((ViewGroup)this.a, paramInt);
    }
    this.a.refreshDrawableState();
  }
  
  public int[] a(int[] paramArrayOfInt)
  {
    return StyledToolbar.a(this.a, paramArrayOfInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/toolbars/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */