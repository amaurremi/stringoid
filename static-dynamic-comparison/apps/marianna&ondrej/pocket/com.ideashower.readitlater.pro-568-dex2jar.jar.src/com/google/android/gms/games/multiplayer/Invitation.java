package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Game;

public abstract interface Invitation
  extends Parcelable, b, e
{
  public abstract Game b();
  
  public abstract String c();
  
  public abstract Participant d();
  
  public abstract long e();
  
  public abstract int f();
  
  public abstract int g();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/multiplayer/Invitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */