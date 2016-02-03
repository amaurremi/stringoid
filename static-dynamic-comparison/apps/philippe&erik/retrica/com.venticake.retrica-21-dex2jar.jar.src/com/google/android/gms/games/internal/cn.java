package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.hm;

final class cn
  extends AbstractGamesCallbacks
{
  private final a.d<Requests.UpdateRequestsResult> b;
  
  public cn(a.d<Requests.UpdateRequestsResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void F(DataHolder paramDataHolder)
  {
    this.b.a(new dk(paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */