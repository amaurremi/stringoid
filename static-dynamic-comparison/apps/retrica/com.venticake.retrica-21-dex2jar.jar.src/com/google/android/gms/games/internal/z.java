package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Notifications.InboxCountResult;

final class z
  implements Notifications.InboxCountResult
{
  private final Status a;
  private final Bundle b;
  
  z(Status paramStatus, Bundle paramBundle)
  {
    this.a = paramStatus;
    this.b = paramBundle;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */