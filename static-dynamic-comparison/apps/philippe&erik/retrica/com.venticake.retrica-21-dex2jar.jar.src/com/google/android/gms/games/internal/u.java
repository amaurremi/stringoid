package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.internal.hm;

final class u
  extends AbstractGamesCallbacks
{
  private final a.d<Notifications.GameMuteStatusChangeResult> b;
  
  u(a.d<Notifications.GameMuteStatusChangeResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.b.a(new t(paramInt, paramString, paramBoolean));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */