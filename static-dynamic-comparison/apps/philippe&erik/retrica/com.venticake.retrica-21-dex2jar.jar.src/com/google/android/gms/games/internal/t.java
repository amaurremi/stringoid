package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;

final class t
  implements Notifications.GameMuteStatusChangeResult
{
  private final Status a;
  private final String b;
  private final boolean c;
  
  public t(int paramInt, String paramString, boolean paramBoolean)
  {
    this.a = new Status(paramInt);
    this.b = paramString;
    this.c = paramBoolean;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */