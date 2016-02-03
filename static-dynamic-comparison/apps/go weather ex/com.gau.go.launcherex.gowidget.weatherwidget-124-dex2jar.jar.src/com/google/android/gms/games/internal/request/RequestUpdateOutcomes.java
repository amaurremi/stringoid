package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.fq;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
  private static final String[] LN = { "requestId", "outcome" };
  private final int Ah;
  private final HashMap<String, Integer> LO;
  
  private RequestUpdateOutcomes(int paramInt, HashMap<String, Integer> paramHashMap)
  {
    this.Ah = paramInt;
    this.LO = paramHashMap;
  }
  
  public static RequestUpdateOutcomes J(DataHolder paramDataHolder)
  {
    Builder localBuilder = new Builder();
    localBuilder.bm(paramDataHolder.getStatusCode());
    int j = paramDataHolder.getCount();
    int i = 0;
    while (i < j)
    {
      int k = paramDataHolder.G(i);
      localBuilder.s(paramDataHolder.getString("requestId", i, k), paramDataHolder.getInteger("outcome", i, k));
      i += 1;
    }
    return localBuilder.hB();
  }
  
  public Set<String> getRequestIds()
  {
    return this.LO.keySet();
  }
  
  public int getRequestOutcome(String paramString)
  {
    fq.b(this.LO.containsKey(paramString), "Request " + paramString + " was not part of the update operation!");
    return ((Integer)this.LO.get(paramString)).intValue();
  }
  
  public static final class Builder
  {
    private int Ah = 0;
    private HashMap<String, Integer> LO = new HashMap();
    
    public Builder bm(int paramInt)
    {
      this.Ah = paramInt;
      return this;
    }
    
    public RequestUpdateOutcomes hB()
    {
      return new RequestUpdateOutcomes(this.Ah, this.LO, null);
    }
    
    public Builder s(String paramString, int paramInt)
    {
      if (RequestUpdateResultOutcome.isValid(paramInt)) {
        this.LO.put(paramString, Integer.valueOf(paramInt));
      }
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/request/RequestUpdateOutcomes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */