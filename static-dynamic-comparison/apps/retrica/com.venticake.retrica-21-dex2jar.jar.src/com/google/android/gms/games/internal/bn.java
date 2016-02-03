package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.internal.hm;

final class bn
  extends AbstractGamesCallbacks
{
  private final a.d<Players.LoadOwnerCoverPhotoUrisResult> b;
  
  bn(a.d<Players.LoadOwnerCoverPhotoUrisResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    this.b.a(new aw(paramInt, paramBundle));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */