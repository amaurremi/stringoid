package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.c;

public abstract interface Player
  extends Parcelable, c<Player>
{
  public abstract String getDisplayName();
  
  public abstract Uri nC();
  
  @Deprecated
  public abstract String nD();
  
  public abstract Uri nE();
  
  @Deprecated
  public abstract String nF();
  
  public abstract String nS();
  
  public abstract long nT();
  
  public abstract long nU();
  
  public abstract int nV();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */