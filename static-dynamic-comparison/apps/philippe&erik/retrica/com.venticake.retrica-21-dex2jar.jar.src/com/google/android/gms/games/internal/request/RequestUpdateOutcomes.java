package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
  private static final String[] Sn = { "requestId", "outcome" };
  private final int CT;
  private final HashMap<String, Integer> So;
  
  private RequestUpdateOutcomes(int paramInt, HashMap<String, Integer> paramHashMap)
  {
    this.CT = paramInt;
    this.So = paramHashMap;
  }
  
  public static RequestUpdateOutcomes U(DataHolder paramDataHolder)
  {
    RequestUpdateOutcomes.Builder localBuilder = new RequestUpdateOutcomes.Builder();
    localBuilder.cw(paramDataHolder.getStatusCode());
    int j = paramDataHolder.getCount();
    int i = 0;
    while (i < j)
    {
      int k = paramDataHolder.ae(i);
      localBuilder.v(paramDataHolder.c("requestId", i, k), paramDataHolder.b("outcome", i, k));
      i += 1;
    }
    return localBuilder.iy();
  }
  
  public Set<String> getRequestIds()
  {
    return this.So.keySet();
  }
  
  public int getRequestOutcome(String paramString)
  {
    hm.b(this.So.containsKey(paramString), "Request " + paramString + " was not part of the update operation!");
    return ((Integer)this.So.get(paramString)).intValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/request/RequestUpdateOutcomes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */