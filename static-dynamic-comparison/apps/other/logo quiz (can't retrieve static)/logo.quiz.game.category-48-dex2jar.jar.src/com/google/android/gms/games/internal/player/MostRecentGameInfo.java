package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface MostRecentGameInfo
  extends Parcelable, Freezable<MostRecentGameInfo>
{
  public abstract String ln();
  
  public abstract String lo();
  
  public abstract long lp();
  
  public abstract Uri lq();
  
  public abstract Uri lr();
  
  public abstract Uri ls();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */