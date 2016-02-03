package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
  private static final String[] Sk = { "requestId", "outcome" };
  private final int CQ;
  private final HashMap<String, Integer> Sl;
  
  private RequestUpdateOutcomes(int paramInt, HashMap<String, Integer> paramHashMap)
  {
    this.CQ = paramInt;
    this.Sl = paramHashMap;
  }
  
  public static RequestUpdateOutcomes U(DataHolder paramDataHolder)
  {
    Builder localBuilder = new Builder();
    localBuilder.cw(paramDataHolder.getStatusCode());
    int j = paramDataHolder.getCount();
    int i = 0;
    while (i < j)
    {
      int k = paramDataHolder.ae(i);
      localBuilder.v(paramDataHolder.c("requestId", i, k), paramDataHolder.b("outcome", i, k));
      i += 1;
    }
    return localBuilder.it();
  }
  
  public Set<String> getRequestIds()
  {
    return this.Sl.keySet();
  }
  
  public int getRequestOutcome(String paramString)
  {
    hn.b(this.Sl.containsKey(paramString), "Request " + paramString + " was not part of the update operation!");
    return ((Integer)this.Sl.get(paramString)).intValue();
  }
  
  public static final class Builder
  {
    private int CQ = 0;
    private HashMap<String, Integer> Sl = new HashMap();
    
    public Builder cw(int paramInt)
    {
      this.CQ = paramInt;
      return this;
    }
    
    public RequestUpdateOutcomes it()
    {
      return new RequestUpdateOutcomes(this.CQ, this.Sl, null);
    }
    
    public Builder v(String paramString, int paramInt)
    {
      if (RequestUpdateResultOutcome.isValid(paramInt)) {
        this.Sl.put(paramString, Integer.valueOf(paramInt));
      }
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/request/RequestUpdateOutcomes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */