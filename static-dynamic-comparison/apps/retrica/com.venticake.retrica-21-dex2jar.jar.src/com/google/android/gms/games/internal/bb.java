package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import java.util.Iterator;
import java.util.Set;

final class bb
  implements Requests.LoadRequestsResult
{
  private final Status a;
  private final Bundle b;
  
  bb(Status paramStatus, Bundle paramBundle)
  {
    this.a = paramStatus;
    this.b = paramBundle;
  }
  
  public GameRequestBuffer getRequests(int paramInt)
  {
    String str = RequestType.cm(paramInt);
    if (!this.b.containsKey(str)) {
      return null;
    }
    return new GameRequestBuffer((DataHolder)this.b.get(str));
  }
  
  public Status getStatus()
  {
    return this.a;
  }
  
  public void release()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (DataHolder)this.b.getParcelable((String)localObject);
      if (localObject != null) {
        ((DataHolder)localObject).close();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */