package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.internal.hm;

final class aa
  extends AbstractGamesCallbacks
{
  private final a.d<Notifications.InboxCountResult> b;
  
  aa(a.d<Notifications.InboxCountResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void f(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    Status localStatus = new Status(paramInt);
    this.b.a(new z(localStatus, paramBundle));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */