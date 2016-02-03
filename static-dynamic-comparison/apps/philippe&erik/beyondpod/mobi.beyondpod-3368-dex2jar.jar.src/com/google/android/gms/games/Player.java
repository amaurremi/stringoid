package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface Player
  extends Parcelable, Freezable<Player>
{
  public abstract int db();
  
  public abstract String getDisplayName();
  
  public abstract void getDisplayName(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract Uri getHiResImageUri();
  
  public abstract Uri getIconImageUri();
  
  public abstract long getLastPlayedWithTimestamp();
  
  public abstract String getPlayerId();
  
  public abstract long getRetrievedTimestamp();
  
  public abstract boolean hasHiResImage();
  
  public abstract boolean hasIconImage();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */