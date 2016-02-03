package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Acls
{
  public static abstract interface LoadAclResult
    extends Releasable, Result
  {}
  
  public static abstract interface LoadFAclResult
    extends Releasable, Result
  {}
  
  public static abstract interface OnGameplayAclLoadedCallback {}
  
  public static abstract interface OnGameplayAclUpdatedCallback {}
  
  public static abstract interface OnNotifyAclLoadedCallback {}
  
  public static abstract interface OnNotifyAclUpdatedCallback {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/game/Acls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */