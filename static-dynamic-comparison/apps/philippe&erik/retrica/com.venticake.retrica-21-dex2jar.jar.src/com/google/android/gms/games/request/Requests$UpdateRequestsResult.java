package com.google.android.gms.games.request;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import java.util.Set;

public abstract interface Requests$UpdateRequestsResult
  extends Releasable, Result
{
  public abstract Set<String> getRequestIds();
  
  public abstract int getRequestOutcome(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/request/Requests$UpdateRequestsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */