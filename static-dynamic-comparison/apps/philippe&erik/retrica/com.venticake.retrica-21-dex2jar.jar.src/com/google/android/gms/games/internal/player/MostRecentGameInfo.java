package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface MostRecentGameInfo
  extends Parcelable, Freezable<MostRecentGameInfo>
{
  public abstract String ip();
  
  public abstract String iq();
  
  public abstract long ir();
  
  public abstract Uri is();
  
  public abstract Uri it();
  
  public abstract Uri iu();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */