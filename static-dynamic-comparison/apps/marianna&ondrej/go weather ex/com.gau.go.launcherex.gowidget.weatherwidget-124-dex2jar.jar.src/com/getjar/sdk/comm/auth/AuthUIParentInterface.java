package com.getjar.sdk.comm.auth;

import android.app.Activity;
import android.app.Dialog;
import java.util.List;

public abstract interface AuthUIParentInterface
{
  public abstract Activity getParentActivity();
  
  public abstract String getTheTitle();
  
  public abstract void relinquishUI();
  
  public abstract void takeoverUI(List<Dialog> paramList);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/auth/AuthUIParentInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */