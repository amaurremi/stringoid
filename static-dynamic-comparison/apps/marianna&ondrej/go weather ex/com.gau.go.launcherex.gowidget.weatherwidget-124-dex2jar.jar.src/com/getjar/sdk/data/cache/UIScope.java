package com.getjar.sdk.data.cache;

public class UIScope
{
  private final Scope _scope;
  
  public UIScope(Scope paramScope)
  {
    if (paramScope == null) {
      throw new IllegalArgumentException("'scope' can not be NULL");
    }
    this._scope = paramScope;
  }
  
  public Scope getScope()
  {
    return this._scope;
  }
  
  public static enum Scope
  {
    INTERSTITIAL;
    
    private Scope() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/cache/UIScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */