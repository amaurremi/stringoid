package com.ideashower.readitlater.views;

import com.ideashower.readitlater.util.a;

public abstract class ba
{
  protected final BaseWebView a;
  
  protected ba(BaseWebView paramBaseWebView)
  {
    this.a = paramBaseWebView;
  }
  
  public static ba a(BaseWebView paramBaseWebView)
  {
    if (a.a()) {
      return new bb(paramBaseWebView);
    }
    return new bc(paramBaseWebView);
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */