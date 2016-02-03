package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.IInterface;
import com.google.android.gms.common.data.DataHolder;

public abstract interface IGamesSignInCallbacks
  extends IInterface
{
  public abstract void S(DataHolder paramDataHolder);
  
  public abstract void T(DataHolder paramDataHolder);
  
  public abstract void b(int paramInt, Intent paramIntent);
  
  public abstract void ci(int paramInt);
  
  public abstract void cj(int paramInt);
  
  public abstract void g(DataHolder paramDataHolder);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IGamesSignInCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */