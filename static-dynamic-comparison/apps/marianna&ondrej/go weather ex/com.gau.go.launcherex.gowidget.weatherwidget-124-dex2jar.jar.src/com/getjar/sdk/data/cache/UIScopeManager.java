package com.getjar.sdk.data.cache;

import android.content.Context;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UIScopeManager
{
  private static volatile UIScopeManager _Instance = null;
  private final Context _context;
  private final ConcurrentLinkedQueue<UIScope> _uiScopes = new ConcurrentLinkedQueue();
  
  private UIScopeManager(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public static UIScopeManager getInstance(Context paramContext)
  {
    try
    {
      if (_Instance == null) {
        _Instance = new UIScopeManager(paramContext);
      }
      paramContext = _Instance;
      return paramContext;
    }
    finally {}
  }
  
  public void addUiScope(UIScope paramUIScope)
  {
    if (!this._uiScopes.contains(paramUIScope)) {
      this._uiScopes.add(paramUIScope);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/cache/UIScopeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */