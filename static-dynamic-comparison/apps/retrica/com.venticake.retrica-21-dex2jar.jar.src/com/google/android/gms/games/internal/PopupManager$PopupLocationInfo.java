package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class PopupManager$PopupLocationInfo
{
  public IBinder Pa;
  public int Pb = -1;
  public int bottom = 0;
  public int gravity;
  public int left = 0;
  public int right = 0;
  public int top = 0;
  
  private PopupManager$PopupLocationInfo(int paramInt, IBinder paramIBinder)
  {
    this.gravity = paramInt;
    this.Pa = paramIBinder;
  }
  
  public Bundle hO()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("popupLocationInfo.gravity", this.gravity);
    localBundle.putInt("popupLocationInfo.displayId", this.Pb);
    localBundle.putInt("popupLocationInfo.left", this.left);
    localBundle.putInt("popupLocationInfo.top", this.top);
    localBundle.putInt("popupLocationInfo.right", this.right);
    localBundle.putInt("popupLocationInfo.bottom", this.bottom);
    return localBundle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/PopupManager$PopupLocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */