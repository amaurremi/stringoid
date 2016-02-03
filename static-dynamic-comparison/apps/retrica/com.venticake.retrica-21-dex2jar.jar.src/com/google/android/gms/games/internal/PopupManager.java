package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.internal.ip;

public class PopupManager
{
  protected GamesClientImpl OY;
  protected PopupManager.PopupLocationInfo OZ;
  
  private PopupManager(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    this.OY = paramGamesClientImpl;
    cl(paramInt);
  }
  
  public static PopupManager a(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    if (ip.gd()) {
      return new dp(paramGamesClientImpl, paramInt);
    }
    return new PopupManager(paramGamesClientImpl, paramInt);
  }
  
  protected void cl(int paramInt)
  {
    this.OZ = new PopupManager.PopupLocationInfo(paramInt, new Binder(), null);
  }
  
  public void g(View paramView) {}
  
  public void hL()
  {
    this.OY.a(this.OZ.Pa, this.OZ.hO());
  }
  
  public Bundle hM()
  {
    return this.OZ.hO();
  }
  
  public IBinder hN()
  {
    return this.OZ.Pa;
  }
  
  public void setGravity(int paramInt)
  {
    this.OZ.gravity = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/PopupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */