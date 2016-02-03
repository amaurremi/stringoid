package com.google.android.gms.games.internal.player;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public abstract interface ExtendedPlayer
  extends Freezable<ExtendedPlayer>
{
  public abstract Player getPlayer();
  
  public abstract String hu();
  
  public abstract long hv();
  
  public abstract Uri hw();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/player/ExtendedPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */