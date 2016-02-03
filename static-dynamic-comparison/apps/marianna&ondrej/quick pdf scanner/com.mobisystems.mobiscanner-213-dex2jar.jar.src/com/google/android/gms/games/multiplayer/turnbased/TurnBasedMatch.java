package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.games.Game;

public abstract interface TurnBasedMatch
  extends Parcelable, com.google.android.gms.common.data.c<TurnBasedMatch>, com.google.android.gms.games.multiplayer.c
{
  public static final int[] wo = { 0, 1, 2, 3 };
  
  public abstract byte[] getData();
  
  public abstract String getDescription();
  
  public abstract int getStatus();
  
  public abstract int getVersion();
  
  public abstract Game nX();
  
  public abstract int oA();
  
  public abstract boolean oB();
  
  public abstract String oC();
  
  public abstract long oa();
  
  public abstract int oc();
  
  public abstract int od();
  
  public abstract String op();
  
  public abstract Bundle oq();
  
  public abstract String ot();
  
  public abstract int ou();
  
  public abstract String ov();
  
  public abstract long ow();
  
  public abstract String ox();
  
  public abstract String oy();
  
  public abstract byte[] oz();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */