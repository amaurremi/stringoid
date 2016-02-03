package com.jiubang.playsdk.detail.a;

import android.support.v4.view.PagerAdapter;

public abstract class c
  extends PagerAdapter
{
  protected d a;
  protected boolean b = true;
  protected boolean c = true;
  
  public void a(d paramd)
  {
    this.a = paramd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */