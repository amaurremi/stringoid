package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.Set;

final class dk
  extends b
  implements Requests.UpdateRequestsResult
{
  private final RequestUpdateOutcomes a;
  
  dk(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = RequestUpdateOutcomes.U(paramDataHolder);
  }
  
  public Set<String> getRequestIds()
  {
    return this.a.getRequestIds();
  }
  
  public int getRequestOutcome(String paramString)
  {
    return this.a.getRequestOutcome(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */