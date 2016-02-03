package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcelable;

public abstract interface Room
  extends Parcelable, com.google.android.gms.common.data.c<Room>, com.google.android.gms.games.multiplayer.c
{
  public abstract String getDescription();
  
  public abstract int getStatus();
  
  public abstract long oa();
  
  public abstract int oc();
  
  public abstract String oo();
  
  public abstract String op();
  
  public abstract Bundle oq();
  
  public abstract int or();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/Room.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */