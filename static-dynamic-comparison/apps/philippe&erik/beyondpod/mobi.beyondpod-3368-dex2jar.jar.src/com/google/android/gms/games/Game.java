package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface Game
  extends Parcelable, Freezable<Game>
{
  public abstract int getAchievementTotalCount();
  
  public abstract String getApplicationId();
  
  public abstract String getDescription();
  
  public abstract void getDescription(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract String getDeveloperName();
  
  public abstract void getDeveloperName(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract String getDisplayName();
  
  public abstract void getDisplayName(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Uri getFeaturedImageUri();
  
  public abstract int getGameplayAclStatus();
  
  public abstract Uri getHiResImageUri();
  
  public abstract Uri getIconImageUri();
  
  public abstract String getInstancePackageName();
  
  public abstract int getLeaderboardCount();
  
  public abstract String getPrimaryCategory();
  
  public abstract String getSecondaryCategory();
  
  public abstract boolean isInstanceInstalled();
  
  public abstract boolean isPlayEnabledGame();
  
  public abstract boolean isRealTimeMultiplayerEnabled();
  
  public abstract boolean isTurnBasedMultiplayerEnabled();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/Game.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */