package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.internal.hm;

final class bl
  extends AbstractGamesCallbacks
{
  private final a.d<Status> b;
  
  bl(a.d<Status> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void cd(int paramInt)
  {
    this.b.a(new Status(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */