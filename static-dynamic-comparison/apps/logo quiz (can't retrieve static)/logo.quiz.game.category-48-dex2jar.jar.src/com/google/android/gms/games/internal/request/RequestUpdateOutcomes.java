package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
  private static final String[] abh = { "requestId", "outcome" };
  private final int HF;
  private final HashMap<String, Integer> abi;
  
  private RequestUpdateOutcomes(int paramInt, HashMap<String, Integer> paramHashMap)
  {
    this.HF = paramInt;
    this.abi = paramHashMap;
  }
  
  public static RequestUpdateOutcomes V(DataHolder paramDataHolder)
  {
    Builder localBuilder = new Builder();
    localBuilder.dR(paramDataHolder.getStatusCode());
    int j = paramDataHolder.getCount();
    int i = 0;
    while (i < j)
    {
      int k = paramDataHolder.ar(i);
      localBuilder.x(paramDataHolder.c("requestId", i, k), paramDataHolder.b("outcome", i, k));
      i += 1;
    }
    return localBuilder.lw();
  }
  
  public Set<String> getRequestIds()
  {
    return this.abi.keySet();
  }
  
  public int getRequestOutcome(String paramString)
  {
    n.b(this.abi.containsKey(paramString), "Request " + paramString + " was not part of the update operation!");
    return ((Integer)this.abi.get(paramString)).intValue();
  }
  
  public static final class Builder
  {
    private int HF = 0;
    private HashMap<String, Integer> abi = new HashMap();
    
    public Builder dR(int paramInt)
    {
      this.HF = paramInt;
      return this;
    }
    
    public RequestUpdateOutcomes lw()
    {
      return new RequestUpdateOutcomes(this.HF, this.abi, null);
    }
    
    public Builder x(String paramString, int paramInt)
    {
      if (RequestUpdateResultOutcome.isValid(paramInt)) {
        this.abi.put(paramString, Integer.valueOf(paramInt));
      }
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/request/RequestUpdateOutcomes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */