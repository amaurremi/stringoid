package com.getjar.sdk.config;

import java.util.Comparator;

public abstract interface ConfigChangedListener
  extends Comparator<ConfigChangedListener>
{
  public abstract String getUniqueId();
  
  public abstract void onConfigChanged(SettingsManager.Scope paramScope);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/config/ConfigChangedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */