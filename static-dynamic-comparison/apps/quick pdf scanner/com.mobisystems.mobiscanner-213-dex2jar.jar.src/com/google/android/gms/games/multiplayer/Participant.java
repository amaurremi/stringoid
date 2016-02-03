package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.c;
import com.google.android.gms.games.Player;

public abstract interface Participant
  extends Parcelable, c<Participant>
{
  public abstract int getCapabilities();
  
  public abstract String getDisplayName();
  
  public abstract int getStatus();
  
  public abstract Uri nC();
  
  @Deprecated
  public abstract String nD();
  
  public abstract Uri nE();
  
  @Deprecated
  public abstract String nF();
  
  public abstract String og();
  
  public abstract boolean oh();
  
  public abstract String oi();
  
  public abstract Player oj();
  
  public abstract ParticipantResult ok();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/Participant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */