package com.google.android.gms.games.internal.request;

import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;

public final class RequestUpdateOutcomes$Builder
{
  private int CT = 0;
  private HashMap<String, Integer> So = new HashMap();
  
  public Builder cw(int paramInt)
  {
    this.CT = paramInt;
    return this;
  }
  
  public RequestUpdateOutcomes iy()
  {
    return new RequestUpdateOutcomes(this.CT, this.So, null);
  }
  
  public Builder v(String paramString, int paramInt)
  {
    if (RequestUpdateResultOutcome.isValid(paramInt)) {
      this.So.put(paramString, Integer.valueOf(paramInt));
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/request/RequestUpdateOutcomes$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */