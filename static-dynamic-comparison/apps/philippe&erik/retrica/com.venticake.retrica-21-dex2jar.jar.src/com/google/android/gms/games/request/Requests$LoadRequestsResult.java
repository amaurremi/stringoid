package com.google.android.gms.games.request;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Requests$LoadRequestsResult
  extends Releasable, Result
{
  public abstract GameRequestBuffer getRequests(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/request/Requests$LoadRequestsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */